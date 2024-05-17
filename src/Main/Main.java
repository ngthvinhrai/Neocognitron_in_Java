/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Layer.Layer;
import Layer.SLayer;
import Layer.CLayer;
import java.util.List;
import java.util.ArrayList;
import Model.Neocognitron;
import Numerical.Point2D;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import Numerical.Point2D;
import Numerical.Numerical;



/**
 *
 * @author asus
 */
public class Main {
    public static void remove(ArrayList<Integer> t){
        t.remove(3);
    }
    
    public static double[][][] readFromFile(String path) throws Exception{
        Scanner sc = new Scanner(new File(path));
        double output[][][] = new double[1][16][16];
        
        for(int i=0; i<16; i++){
            for(int j=0; j<16; j++)
                output[0][i][j] = Double.parseDouble(sc.next());
        }
        
        return output;
    }
    
    public static double[][][][][] createData(int numClass, int numEachClass, String path) throws Exception{
        double[][][][][] input = new double[numClass][numEachClass][1][16][16];
        for(int nc=0; nc<numClass; nc++){
            File dataFolder = new File(path + (char)(65+nc));
            for(int nd=0; nd<numEachClass; nd++){
                Scanner sc = new Scanner(new File(dataFolder.listFiles()[nd].getAbsolutePath()));
                for(int i=0; i<16; i++){
                    for(int j=0; j<16; j++)
                        input[nc][nd][0][i][j] = Double.parseDouble(sc.next());
                }
            }
        }
        
        return input;
    }
    
    public static void show1D(double[] input){
        for(double x:input) System.out.printf("%.5f ", x);
        System.out.println();
    }
    
    public static void show2D(double[][] input){
        System.out.print("[");
        for(int i=0; i<input.length; i++){
            System.out.print("[");
            for(int j=0; j<input[0].length; j++)
                System.out.printf("%f, ", input[i][j]);
            System.out.print("]");
            System.out.println();
        }
        System.out.println("]");
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
    
    public static void matrixToImage(int[][] matrix){

    }
    
    public static void testShow(double[][][][] inputs){
        for(double[][][] input:inputs) show3D(input);
    }
    
    
    public static void main(String[] args) throws Exception{
//        Neocognitron model = new Neocognitron(new SLayer[] {new SLayer(0,0,0,0,0), new SLayer(36,21,5,2,0.9), new SLayer(32,15,5,1.5,0.7), new SLayer(30,9,5,1.5,0.8), new SLayer(26,3,3,1.5,0.6)}, 
//                                            new CLayer[] {new CLayer(1,21,0,0,0,0), new CLayer(36,19,5,0.4,4,0.9), new CLayer(32,13,5,0.4,4,0.8), new CLayer(30,7,5,0.4,2.5,0.6), new CLayer(26,1,3,0.4,2,0.4)});
        
//        Neocognitron model = new Neocognitron(new SLayer[] {new SLayer(0,0,0,0,0), new SLayer(36,21,5,2,0.9), new SLayer(30,11,5,1.5,0.9), new SLayer(26,3,5,1.5,0.9)}, 
//                                            new CLayer[] {new CLayer(1,21,0,0,0,0), new CLayer(36,17,5,0.4,4,0.9), new CLayer(30,7,5,0.4,4,0.8), new CLayer(26,1,3,0.4,2.5,0.6)});
        
        Neocognitron model = new Neocognitron(new SLayer[] {new SLayer(0,0,0,0,0), new SLayer(40,16,5,2,0.9), new SLayer(32,10,5,1.5,0.9), new SLayer(26,2,5,1.5,0.9)}, 
                                            new CLayer[] {new CLayer(1,16,0,0,0,0), new CLayer(40,14,5,0.4,4,0.9), new CLayer(32,6,5,0.4,4,0.8), new CLayer(26,1,2,0.4,2.5,0.6)});

//        Neocognitron model = new Neocognitron(new SLayer[] {new SLayer(0,0,0,0,0), new SLayer(24,16,5,4,0.9)}, 
//                                            new CLayer[] {new CLayer(1,16,0,0,0,0), new CLayer(24,10,5,0.5,4,0.9)});
        
        String testpath = "dataset3\\";
        String trainpath = "dataset5\\";
        double[][][][][] testinput = createData(26,20, testpath);
        double[][][][][] traininput = createData(26,10, trainpath);

        model.load("weightsForAlphabet6");

//        for(int epoch=1; epoch<=1; epoch++){
//            for(int i=0; i<10; i++){
//                for(int j=0; j<26; j++){
//                    model.train(traininput[j][i], new int[]{0,5,5,2}, new double[]{0,1,10,10}, 1);
//                    model.save("weightsForAlphabet6_1");      
//                }
//            }
//        }

//        for(int i=0; i<26; i++){
//            int[] classes = new int[26];
//            for(int j=0; j<10; j++){
//                model.forward(testinput[i][j]);
//                classes[Numerical.argmax(model.Complex[3].getCLayer())]++;
//            }
//            System.out.print((char)(65+i) + ": ");
//            for(int x:classes) System.out.print(x + " ");
//            System.out.println(Numerical.argmax(classes));
//        }

//        model.forward(testinput[0][9]);


//        show1D(model.getMatrixB(1).b);
//        show1D(model.getMatrixB(2).b);
//        show1D(model.getMatrixB(3).b);
//        show3D(model.Simple[3].getSLayer());
//        show3D(model.Complex[3].getCLayer());
        show2D(model.getMatrixA(1).a[16][0]);
    }
}
