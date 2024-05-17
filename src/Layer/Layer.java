/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layer;

/**
 *
 * @author asus
 */
public abstract class Layer {
    protected int planeNum;
    protected int planeSize;
    protected int receptiveField;
    
    public Layer(int planeNum, int planeSize, int receptiveField){
        this.planeNum = planeNum;
        this.planeSize = planeSize;
        this.receptiveField = receptiveField;
    }
    
    
    // Propagate for S-Layer
    public abstract void propagate(double[][][] input, double[][][][] a, double[] b);
    
    // Propagate for C-Layer
    public abstract void propagate(double[][][] input);
    
    protected abstract void generateV(double[][][] innput);
}
