/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VPlane;

/**
 *
 * @author asus
 */
public class Vs {
    private int planeSize;
    private double [][]v;
    
    public Vs(int planeSize){
        this.planeSize = planeSize;
        this.v = new double[planeSize][planeSize];
    }
    
    public double[][] getV() {return this.v;}
    
}
