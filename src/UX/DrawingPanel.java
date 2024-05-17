/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UX;

import Main.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public class DrawingPanel extends JPanel {

    private static final int NUM_ROWS = 16;
    private static final int NUM_COLS = 16;
    private static final int NUM_LAYERS = 1;
    private static final int CELL_SIZE = 25;
    private double[][][] matrix;
    private boolean drawing;

    public DrawingPanel() {
        matrix = new double[NUM_LAYERS][NUM_ROWS][NUM_COLS];
        setPreferredSize(new Dimension(NUM_COLS * CELL_SIZE, NUM_ROWS * CELL_SIZE));
        drawing = false;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawing = true;
                drawPixel(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                drawing = false;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (drawing) {
                    drawPixel(e);
                }
            }
        });
    }

    private void drawPixel(MouseEvent e) {
        int row = e.getY() / CELL_SIZE;
        int col = e.getX() / CELL_SIZE;

        if (row >= 0 && row < NUM_ROWS && col >= 0 && col < NUM_COLS) {
            matrix[0][row][col] = 1.0; // Set giá trị thành 1
            repaint();
        }
    }

    public double[][][] getMatrix() {
        return matrix;
    }

    public void cleanMatrix() {
        for (int layer = 0; layer < NUM_LAYERS; layer++) {
            for (int row = 0; row < NUM_ROWS; row++) {
                for (int col = 0; col < NUM_COLS; col++) {
                    matrix[layer][row][col] = 0.0; // Đặt lại tất cả các giá trị thành 0
                }
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Vẽ các đường lưới ngang
        for (int row = 0; row <= NUM_ROWS; row++) {
            int y = row * CELL_SIZE;
            g.drawLine(0, y, NUM_COLS * CELL_SIZE, y);
        }

        // Vẽ các đường lưới dọc
        for (int col = 0; col <= NUM_COLS; col++) {
            int x = col * CELL_SIZE;
            g.drawLine(x, 0, x, NUM_ROWS * CELL_SIZE);
        }

        // Vẽ các ô được chọn
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                if (matrix[0][row][col] != 0.0) {
                    g.setColor(Color.BLACK);
                    // Vẽ hình chữ nhật tại vị trí ô
                    g.fillRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }
    }
}


