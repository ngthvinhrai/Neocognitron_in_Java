/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer;
import Numerical.Numerical;

/**
 *
 * @author asus
 */
public class SLayer extends Layer{
    private double rl;
    private double gamma;
    private double[][][] sLayer;
    private double[][] v;
    private double[][] c;
    
    public SLayer(int planeNum, int planeSize, int receptiveField, double rl, double gamma){
        super(planeNum, planeSize, receptiveField);
        this.rl = rl;
        this.gamma = gamma;
        this.sLayer = new double[planeNum][planeSize][planeSize];
    }
    
    public int getPlaneNum() {return this.planeNum;}
    public int getPlaneSize() {return this.planeSize;}
    public int getReceptiveField() {return this.receptiveField;}
    public double[][][] getSLayer() {return this.sLayer;}
    public double[][] getV() {return this.v;}
    public double[][] getC() {return this.c;}
    
    private void generateC(int prevPlaneNum){
        this.c = new double[this.receptiveField][this.receptiveField];
        int rf = (int)Math.floor(super.receptiveField/2);
        double sum = 0;
        
        for(int i=-rf; i<=rf; i++){
            for(int j=-rf; j<=rf; j++){
                this.c[i+rf][j+rf] = Math.pow(this.gamma, Math.sqrt(i*i + j*j));
                sum += this.c[i+rf][j+rf];
            }
        }
        
        for(int i=-rf; i<=rf; i++){
            for(int j=-rf; j<=rf; j++){
                this.c[i+rf][j+rf] = this.c[i+rf][j+rf]/(sum*prevPlaneNum);
            }
        }
    }
    
    @Override
    protected void generateV(double[][][] input){
        this.v = new double[this.planeSize][this.planeSize];
        int prevPlaneNum = input.length;
        int rf = (int)Math.floor(super.receptiveField/2);
        int dimDiff = (int)Math.abs(this.planeSize - input[0].length)/2;
        
        for(int x=0; x<this.planeSize; x++){
            for(int y=0; y<this.planeSize; y++){
                for(int plane=0; plane<prevPlaneNum; plane++){
                    for(int i=-rf; i<=rf; i++){
                        for(int j=-rf; j<=rf; j++){
                            double cCell = this.c[i+rf][j+rf];
                            double prev;
                            try{
                                prev = input[plane][x+i+dimDiff][y+j+dimDiff];
                            }
                            catch(ArrayIndexOutOfBoundsException e){
                                prev = 0;
                            }
                            this.v[x][y] += cCell * Math.pow(prev, 2);
                        }
                    }
                }
                this.v[x][y] = Math.sqrt(this.v[x][y]);
            }
        }       
    }
    
    private double generateCell(int cX, int cY, double[][][] input, double[][][] a, double b, double v){
        int prevPlaneNum = input.length;
        int rf = (int)Math.floor(super.receptiveField/2);
        int dimDiff = (int)Math.abs(this.planeSize - input[0].length)/2;
        double e = 0;
        double h = (this.rl/(this.rl + 1))*b*v;
        
        for(int plane=0; plane<prevPlaneNum; plane++){
            for(int i=-rf; i<=rf; i++){
                for(int j=-rf; j<=rf; j++){
                    double prev;
                    try{
                        prev = input[plane][cX+i+dimDiff][cY+j+dimDiff];
                    }
                    catch(ArrayIndexOutOfBoundsException ex){
                        prev = 0;
                    }
                    e += a[plane][i+rf][j+rf] * prev;
                }
            }
        }
        double res = Numerical.relu((1+e)/(1+h) - 1);
        return res;
    }
    
    @Override
    public void propagate(double[][][] input, double[][][][] a, double[] b){
        this.generateC(input.length);
        this.generateV(input);
        for(int plane=0; plane<this.planeNum; plane++){
            for(int x=0; x<this.planeSize; x++){
                for(int y=0; y<this.planeSize; y++){
                    this.sLayer[plane][x][y] = generateCell(x, y, input, a[plane], b[plane], v[x][y]);
                }
            }
        }
    }
    
    @Override
    public void propagate(double[][][] input){
        throw new UnsupportedOperationException("This is not C-Layer");
    }
    
    public void show(){
        System.out.println("This is S-Layer");
    }
}
