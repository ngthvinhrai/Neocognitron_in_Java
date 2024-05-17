/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UX;

/**
 *
 * @author admin
 */
import Layer.CLayer;
import Layer.SLayer;
import Model.Neocognitron;
import Numerical.Numerical;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.UIManager;

public class Giao_Dien_3 extends JFrame implements ActionListener {

    private JPanel jPanel1, jPanel2;
    private JButton jButton1, jButton2, jButton3, jButton4;
    private JLabel jLabel3;

    private static final int NUM_ROWS = 16;
    private static final int NUM_COLS = 16;
    private static final int CELL_SIZE = 25;

    private boolean[][] currentMatrix;
    private DrawingPanel drawingPanel;
    private int fileCounter = 1;
    private double[][][] matrix;
    private int ketQua;
    private Neocognitron model;

    public double[][][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][][] matrix) {
        this.matrix = matrix;
    }

    public Giao_Dien_3() {
        initComponents();
        try {
            model = new Neocognitron(new SLayer[] {new SLayer(0,0,0,0,0), new SLayer(40,16,5,2,0.9), new SLayer(32,10,5,1.5,0.9), new SLayer(26,2,5,1.5,0.9)}, 
                                            new CLayer[] {new CLayer(1,16,0,0,0,0), new CLayer(40,14,5,0.4,4,0.9), new CLayer(32,6,5,0.4,4,0.8), new CLayer(26,1,2,0.4,2.5,0.6)});
            model.load("weightsForAlphabet6");
        } catch (IOException ex) {
            Logger.getLogger(Giao_Dien_3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1 = new JPanel(new GridBagLayout()); // Sử dụng GridBagLayout cho jPanel1

        jButton4 = new JButton();
        jButton4.setBackground(new Color(101, 178, 161));
        jButton4.setIcon(new ImageIcon(getClass().getResource("/ANH_NEN/GD2_ICON_3.png")));
        jButton4.addActionListener(this);

        drawingPanel = new DrawingPanel(); // Tạo DrawingPanel ở đây
        drawingPanel.setPreferredSize(new Dimension(400, 400));
        jPanel1.setBackground(new Color(101, 178, 161));

        jButton1 = new JButton();
        jButton1.setIcon(new ImageIcon(getClass().getResource("/ANH_NEN/GD3_ICON_2.png")));
        jButton1.addActionListener(e -> startExtracting());
        jButton1.setPreferredSize(new Dimension(100, 20));

        jButton2 = new JButton();
        jButton2.setIcon(new ImageIcon(getClass().getResource("/ANH_NEN/GD3_ICON_1.png")));
        jButton2.addActionListener(e -> cleanMatrix());
        jButton2.setPreferredSize(new Dimension(100, 20));

        jButton3 = new JButton();
        jButton3.setIcon(new ImageIcon(getClass().getResource("/ANH_NEN/GD3_ICON_3.png")));
        jButton3.setPreferredSize(new Dimension(100, 20));

        jLabel3 = new JLabel();
        jLabel3.setIcon(new ImageIcon(getClass().getResource("/ANH_NEN/GD3_ICON_4.png")));

        jPanel2 = new JPanel(new GridLayout(4, 1, 20, 20));
        jPanel2.setBackground(new Color(101, 178, 161));
        jPanel2.add(jLabel3);
        jPanel2.add(jButton1);
        jPanel2.add(jButton2);
        jPanel2.add(jButton3);
        jPanel2.setPreferredSize(new Dimension(140, 500));

        // Thiết lập GridBagConstraints để căn giữa drawingPanel
        GridBagConstraints gbcDrawingPanel = new GridBagConstraints();
        gbcDrawingPanel.gridx = 0;
        gbcDrawingPanel.gridy = 0;
        gbcDrawingPanel.weightx = 1.0; // Đảm bảo drawingPanel mở rộng hết không gian trống
        gbcDrawingPanel.weighty = 1.0;
        gbcDrawingPanel.fill = GridBagConstraints.CENTER; // Đặt drawingPanel để lấp đầy toàn bộ không gian trống
        gbcDrawingPanel.anchor = GridBagConstraints.CENTER;
        gbcDrawingPanel.insets = new Insets(5, 5, 5, 5); // Đặt margin cho drawingPanel
        jPanel1.add(drawingPanel, gbcDrawingPanel);

// Thiết lập GridBagConstraints để đặt jButton4 ở góc bên trái của màn hình
        GridBagConstraints gbcButton4 = new GridBagConstraints();
        gbcButton4.gridx = 0;
        gbcButton4.gridy = 0;
        gbcButton4.anchor = GridBagConstraints.NORTHWEST; // Đặt góc của jButton4 ở phía Tây Bắc
        gbcButton4.insets = new Insets(5, 5, 5, 5); // Đặt margin cho jButton4
        jPanel1.add(jButton4, gbcButton4);

// Thêm panel2 vào phía Đông của jPanel1
        GridBagConstraints gbcPanel2 = new GridBagConstraints();
        gbcPanel2.gridx = 1;
        gbcPanel2.gridy = 0;
        gbcPanel2.anchor = GridBagConstraints.NORTH;
        gbcPanel2.insets = new Insets(5, 5, 5, 5); // Đặt margin cho panel2
        jPanel1.add(jPanel2, gbcPanel2);

        getContentPane().add(jPanel1);
        pack();
        setLocationRelativeTo(null);
        setSize(850, 665);
    }

    private void startExtracting() {
        matrix = new double[1][16][16]; // Tạo ma trận 1 x 16 x 16
        double[][][] drawingMatrix = drawingPanel.getMatrix();
        // Copy giá trị từ ma trận drawingPanel vào ma trận của extractor
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                matrix[0][i][j] = drawingMatrix[0][i][j];
            }
        }

        model.forward(matrix);

        ketQua = Numerical.argmax(model.Complex[3].getCLayer());
        Giao_Dien_5 giaoDien5 = new Giao_Dien_5(ketQua, matrix);
        giaoDien5.setVisible(true); // Show Giao_Dien_5
    }

    private void cleanMatrix() {
        drawingPanel.cleanMatrix();
        matrix = null; // Đặt ma trận về null
    }

    private void saveMatrix(double[][][] matrix) {
        // Save matrix to memory or file
        System.out.println("Matrix saved to memory.");
    }

    private void saveMatrixToFile(boolean[][] matrix, String filePath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            for (int i = 0; i < NUM_ROWS; i++) {
                for (int j = 0; j < NUM_COLS; j++) {
                    writer.write(matrix[i][j] ? "1" : "0");
                    if (j < NUM_COLS - 1) {
                        writer.write(" ");
                    }
                }
                writer.newLine();
            }
            writer.close();
            System.out.println("Matrix saved to file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// Tạo một phương thức public để trả về ma trận boolean từ drawingPanel

    public JButton getjButton1() {
        return jButton1;
    }

    public JButton getjButton4() {
        return jButton4;
    }

    public int getKetQua() {
        return ketQua;
    }

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    private void jButton4ActionPerformed(ActionEvent evt) {
        // Handle jButton4 click event
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        // Handle jButton3 click event
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        // Handle jButton1 click event
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton4) {
            jButton4ActionPerformed(e);
        } else if (e.getSource() == jButton3) {
            jButton3ActionPerformed(e);
        } else if (e.getSource() == jButton1) {
            jButton1ActionPerformed(e);
        }
    }

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            java.awt.EventQueue.invokeLater(new Runnable() {

                public void run() {
                    new Giao_Dien_3().setVisible(true);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
