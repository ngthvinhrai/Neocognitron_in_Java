/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WeightMatrix;


/**
 *
 * @author asus
 */
public class MatrixA {
    private int planeNum;
    private int prevPlaneNum;
    private int receptiveField;
    public double[][][][] a;
    
    public MatrixA(int planeNum, int prevPlaneNum, int receptiveField){
        this.planeNum = planeNum;
        this.prevPlaneNum = prevPlaneNum;
        this.receptiveField = receptiveField;
        this.a = new double[planeNum][prevPlaneNum][receptiveField][receptiveField];
        generateA();
    }
    
    public int getPlaneNum() {return this.planeNum;}
    public int getPrevPlaneNum() {return this.prevPlaneNum;}
    public int getReceptiveField() {return this.receptiveField;}
    
    private void generateA(){
        for(int plane=0; plane<this.planeNum; plane++){
            for(int prevPlane=0; prevPlane<this.prevPlaneNum; prevPlane++){
                for(int i=0; i<this.receptiveField; i++){
                    for(int j=0; j<this.receptiveField; j++)
                        this.a[plane][prevPlane][i][j] = Math.random()*0.1;
                }
            }
        }
    }
}
