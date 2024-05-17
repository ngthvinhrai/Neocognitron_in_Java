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
public class CLayer extends Layer {

    private double alpha;
    private double delta;
    private double subDelta;
    private double[][][] cLayer;
    private double[][] v;

    public CLayer(int planeNum, int planeSize, int receptiveField, double alpha, double theta, double subTheta) {
        super(planeNum, planeSize, receptiveField);
        this.alpha = alpha;
        this.delta = theta;
        this.subDelta = subTheta;
        this.cLayer = new double[planeNum][planeSize][planeSize];
    }

    public int getPlaneNum() {return this.planeNum;}
    public int getPlaneSize() {return this.planeSize;}
    public int getReceptiveField() {return this.receptiveField;}
    public double[][][] getCLayer() {return this.cLayer;}

    public void setCLayer(double[][][] input) {
        for (int plane = 0; plane < this.planeNum; plane++) {
            for (int x = 0; x < this.planeSize; x++) {
                for (int y = 0; y < this.planeSize; y++) {
                    this.cLayer[plane][x][y] = input[plane][x][y];
                }
            }
        }
    }

    @Override
    protected void generateV(double[][][] input) {
        this.v = new double[this.planeSize][this.planeSize];
        int prevPlaneNum = input.length;
        int rf = (int) Math.floor(super.receptiveField / 2);
        int dimDiff = (int) Math.abs(this.planeSize - input[0].length) / 2;

        for (int x = 0; x < this.planeSize; x++) {
            for (int y = 0; y < this.planeSize; y++) {
                for (int plane = 0; plane < prevPlaneNum; plane++) {
                    for (int i = -rf; i <= rf; i++) {
                        for (int j = -rf; j <= rf; j++) {
                            double dCell = this.delta * Math.pow(this.subDelta, Math.sqrt(i * i + j * j));
                            double prev;
                            try {
                                prev = input[plane][x + i + dimDiff][y + j + dimDiff];
                            } 
                            catch (ArrayIndexOutOfBoundsException e) {
                                prev = 0;
                            }
                            this.v[x][y] += dCell * prev;
                        }
                    }
                }
                this.v[x][y] /= prevPlaneNum;
            }
        }
    }

    private double generateCell(int cX, int cY, double[][] input, double v) {
        int rf = (int) Math.floor(super.receptiveField / 2);
        int dimDiff = (int) Math.abs(this.planeSize - input[0].length) / 2;
        double e = 0;

        for (int i = -rf; i <= rf; i++) {
            for (int j = -rf; j <= rf; j++) {
                double dCell = this.delta * Math.pow(this.subDelta, Math.sqrt(i * i + j * j));
                double prev;
                try {
                    prev = input[cX + i + dimDiff][cY + j + dimDiff];
                } 
                catch (ArrayIndexOutOfBoundsException ex) {
                    prev = 0;
                }
                e += dCell * prev;
            }
        }
        double res = Numerical.relu((1 + e) / (1 + v) - 1);
        return res / (res + this.alpha);
    }

    @Override
    public void propagate(double[][][] input) {
        generateV(input);
        for (int plane = 0; plane < this.planeNum; plane++) {
            for (int x = 0; x < planeSize; x++) {
                for (int y = 0; y < planeSize; y++) {
                    this.cLayer[plane][x][y] = generateCell(x, y, input[plane], v[x][y]);
                }
            }
        }
    }

    @Override
    public void propagate(double[][][] input, double[][][][] a, double[] b) {
        throw new UnsupportedOperationException("This is not S-Layer");
    }

    public void show() {
        System.out.println("This is C-Layer");
    }
}
