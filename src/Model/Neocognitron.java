/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Layer.SLayer;
import Layer.CLayer;
import WeightMatrix.MatrixA;
import WeightMatrix.MatrixB;
import Numerical.Point2D;
import Numerical.Point3D;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class Neocognitron {
    private MatrixA[] A;
    private MatrixB[] B;
    public SLayer[] Simple;
    public CLayer[] Complex;
    
    public Neocognitron(SLayer[] Simple, CLayer[] Complex){
        this.Simple = Simple;
        this.Complex = Complex;
        this.A = new MatrixA[this.Complex.length];
        this.B = new MatrixB[this.Complex.length];
        
        for(int i=1; i<this.Complex.length; i++){
            int planeNum = this.Simple[i].getPlaneNum();
            int prevPlaneNum = this.Complex[i-1].getPlaneNum();
            int receptiveField = this.Simple[i].getReceptiveField();
            this.A[i] = new MatrixA(planeNum, prevPlaneNum, receptiveField);
            this.B[i] = new MatrixB(planeNum);
        }
    }
    
    public MatrixA getMatrixA(int i){
        return this.A[i];
    }
    
    public MatrixB getMatrixB(int i){
        return this.B[i];
    }
    
    public void show(){
        for(int i=0;i<this.Simple.length; i++){
            this.Simple[i].show();
            this.Complex[i].show();
        }
    }

    public static void show3D(double[][][] input){
        for(int i=0; i<input.length; i++){
            for(int j=0; j<input[0].length; j++){
                for(int k=0; k<input[0][0].length; k++)
                    System.out.printf("%.5f ", input[i][j][k]);   
                System.out.println("");
            }
            System.out.println("");
        }
    }
    
    public static void show2D(double[][] input){
        for(int i=0; i<input.length; i++){
            for(int j=0; j<input[0].length; j++)
                System.out.printf("%.5f ", input[i][j]);
            System.out.println();
        }
    }
    
    public void forward(double[][][] input){
        assert this.Complex[0].getPlaneNum() == input.length;
        assert this.Complex[0].getPlaneSize() == input[0].length;
        this.Complex[0].setCLayer(input);
        
        for(int layer=1; layer<this.Complex.length; layer++){
            this.Simple[layer].propagate(this.Complex[layer-1].getCLayer(), this.A[layer].a, this.B[layer].b);
            this.Complex[layer].propagate(this.Simple[layer].getSLayer());
        }
    }
    
    public ArrayList<Point3D> getCellLocation(int layer, int sColumn){
        ArrayList<Point3D> location = new ArrayList<>();
        int residual = this.Simple[layer].getPlaneSize() - sColumn;
        Point3D temp = new Point3D();
        
        for(int i=0; i<=residual; i++){
            for(int j=0; j<=residual; j++){
                double maxValue = 0;
                for(int plane=0; plane<this.Simple[layer].getPlaneNum(); plane++){
                    for(int x=0; x<sColumn; x++){
                        for(int y=0; y<sColumn; y++){
                            if(this.Simple[layer].getSLayer()[plane][x+i][y+j] > maxValue){
                                maxValue = this.Simple[layer].getSLayer()[plane][x+i][y+j];
                                temp.plane = plane;
                                temp.x = x+i;
                                temp.y = y+j;
                            }
                        }
                    }
                }
                location.add(temp);
            }
        }
        return location;
    }
    
    public Point2D getMax(int layer, int plane, ArrayList<Point3D> location){
        Point2D p;
        ArrayList<Point2D> repPlane = new ArrayList<>();
        double maxValue = 0;
        for(Point3D tmp:location)
            if(tmp.plane == plane) repPlane.add(new Point2D(tmp.x, tmp.y));
        
        if(repPlane.isEmpty()) p=null;
        else{
            p = new Point2D();
            for(Point2D tmp:repPlane){
                if(this.Simple[layer].getSLayer()[plane][tmp.x][tmp.y] > maxValue){
                    p.x = tmp.x;
                    p.y = tmp.y;
                    maxValue = this.Simple[layer].getSLayer()[plane][tmp.x][tmp.y];
                }
            }       
        }
        return p;
    }
    
    public Point2D[] getRepresentativeCells(int layer, int sColumn){
        Point2D[] repCells = new Point2D[this.Simple[layer].getPlaneNum()];
        ArrayList<Point3D> location = getCellLocation(layer, sColumn);
        for(int plane=0; plane<this.Simple[layer].getPlaneNum(); plane++)
            repCells[plane] = getMax(layer, plane, location);
        
        return repCells;
    }
    
    public void update(int layer, Point2D[] repCells, double q){
        int prevPlaneNum = this.Complex[layer-1].getPlaneNum();
        int rf = (int)Math.floor(this.Simple[layer].getReceptiveField()/2);
        int dimDiff = (int)Math.abs(this.Simple[layer].getPlaneSize() - this.Complex[layer-1].getPlaneSize())/2;
        
        for(int plane=0; plane<this.Simple[layer].getPlaneNum(); plane++){
            if(repCells[plane] != null){
                int x = repCells[plane].x;
                int y = repCells[plane].y;
                this.B[layer].b[plane] += (q) * this.Simple[layer].getV()[x][y];
                for(int prevPlane=0; prevPlane<prevPlaneNum; prevPlane++){
                    for(int i=-rf; i<=rf; i++){
                        for(int j=-rf; j<=rf; j++){
                            double prev;
                            try{
                                prev = this.Complex[layer-1].getCLayer()[prevPlane][x+i+dimDiff][y+j+dimDiff];
                            }
                            catch(ArrayIndexOutOfBoundsException e){
                                prev = 0;
                            }
                            this.A[layer].a[plane][prevPlane][i+rf][j+rf] += q * prev * this.Simple[layer].getC()[i+rf][j+rf];
                        }
                    }
                }
            }
        }
    }

    public void save(String path) throws IOException{
        for(int layer=1; layer<this.A.length; layer++){
            File weightA = new File(path + "\\a" + Integer.toString(layer) + ".txt");
            weightA.createNewFile();
            File weightB = new File(path + "\\b" + Integer.toString(layer) + ".txt");
            weightB.createNewFile();
            FileWriter wra = new FileWriter(path + "\\a" + Integer.toString(layer) + ".txt");
            FileWriter wrb = new FileWriter(path + "\\b" + Integer.toString(layer) + ".txt");
            
            for(int plane=0; plane<this.A[layer].getPlaneNum(); plane++){
                wrb.write(String.valueOf(this.B[layer].b[plane]));
                wrb.write(" ");
                for(int prevPlane=0; prevPlane<this.A[layer].getPrevPlaneNum(); prevPlane++){
                    for(int x=0; x<this.A[layer].getReceptiveField(); x++){
                        for(int y=0; y<this.A[layer].getReceptiveField(); y++){
                            wra.write(String.valueOf(this.A[layer].a[plane][prevPlane][x][y]));
                            wra.write(" ");
                        }
                        wra.write("\n");
                    }
                    wra.write("\n");
                }
                wra.write("\n");
            }
            wra.close();
            wrb.close();
        }
    }
    
    public void load(String path) throws IOException{
        for(int layer=1; layer<this.Complex.length; layer++){
            Scanner ra = new Scanner(new File(path + "\\a" + String.valueOf(layer) + ".txt"));
            Scanner rb = new Scanner(new File(path + "\\b" + String.valueOf(layer) + ".txt"));
            
            for(int plane=0; plane<this.A[layer].getPlaneNum(); plane++){
                this.B[layer].b[plane] = Double.parseDouble(rb.next());
                for(int prevPlane=0; prevPlane<this.A[layer].getPrevPlaneNum(); prevPlane++){
                    for(int x=0; x<this.A[layer].getReceptiveField(); x++){
                        for(int y=0; y<this.A[layer].getReceptiveField(); y++){
                            this.A[layer].a[plane][prevPlane][x][y] = Double.parseDouble(ra.next());
                        }
                    }
                }
            }
            ra.close();
            rb.close();
        }
    }
    
    public void train(double[][][] inputs, int[] sColumn, double[] q, int epochs){
        for(int epoch=1; epoch<=epochs; epoch++){
//            System.out.printf("Epoch %d/%d \n", epoch, epochs);
//            for(double[][][][] input:inputs){
//                for(double[][][] data:input){
                    forward(inputs);
                    for(int layer=1; layer<this.Complex.length; layer++){
                        Point2D[] repCells = getRepresentativeCells(layer, sColumn[layer]);
                        update(layer, repCells, q[layer]);
//                    }
//                }
            }
        }
    }
}
