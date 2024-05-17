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
public class MatrixB {
    private int planeNum;
    public double[] b;
    
    public MatrixB(int planeNum){
        this.planeNum = planeNum;
        this.b = new double[planeNum];
        generateB();
    }
    
    private void generateB(){
        for(int i=0; i<this.planeNum; i++)
            this.b[i] = 0;
    }
}
