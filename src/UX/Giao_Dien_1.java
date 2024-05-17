/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UX;

/**
 *
 * @author admin
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Giao_Dien_1 extends JFrame {

    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel2_1;
    private JPanel jPanel2_2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel6;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;

    public Giao_Dien_1() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Necognitron");
        setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        jButton3 = new JButton();
        jPanel2 = new JPanel();
        jPanel2_1 = new JPanel();
        jPanel2_2 = new JPanel();
        jLabel2 = new JLabel();
        jLabel4 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel6 = new JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ANH_NEN/GD1_ICON_2.png")));

        jLabel3.setBackground(new java.awt.Color(101, 178, 161));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 36));
        jLabel3.setForeground(new java.awt.Color(101, 178, 161));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("GROUP 6");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ANH_NEN/GD1_ICON_3.png")));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.setPreferredSize(new Dimension(300, 500));

        // Thiết lập Layout cho jPanel1
        jPanel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

// Thiết lập ràng buộc cho jLabel1
        gbc.gridx = 0; // Cột 0
        gbc.gridy = 0; // Hàng 0
        gbc.gridwidth = 2; // Chiếm 2 cột
        gbc.insets = new Insets(10, 10, 10, 10); // Canh lề
        jPanel1.add(jLabel1, gbc);

// Thiết lập ràng buộc cho jLabel3
        gbc.gridx = 0; // Cột 0
        gbc.gridy = 1; // Hàng 1
        gbc.gridwidth = 2; // Chiếm 2 cột
        gbc.insets = new Insets(0, 10, 10, 10); // Canh lề
        jPanel1.add(jLabel3, gbc);

// Thiết lập ràng buộc cho jButton3
        gbc.gridx = 0; // Cột 0
        gbc.gridy = 2; // Hàng 2
        gbc.gridwidth = 2; // Chiếm 1 cột
        gbc.insets = new Insets(0, 10, 10, 10); // Canh lề
        jPanel1.add(jButton3, gbc);

        jPanel2.setBackground(new java.awt.Color(101, 178, 161));
        jPanel2_1.setBackground(new java.awt.Color(101, 178, 161));
        jPanel2_2.setBackground(new java.awt.Color(101, 178, 161));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("NHẬN DIỆN CHỮ VIẾT");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jButton1.setText("START");
        jButton1.setPreferredSize(new Dimension(150, 80)); 
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jButton2.setText("EXIT");
        jButton2.setPreferredSize(new Dimension(150, 80)); 

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ANH_NEN/GD1_ICON_1.png")));

        jPanel2.setLayout(new BorderLayout());
        jPanel2_1.setLayout(new GridBagLayout());
        jPanel2_2.setLayout(new GridBagLayout());

// Thiết lập ràng buộc cho jLabel6 trong jPanel2_1
        GridBagConstraints gbcLabel6 = new GridBagConstraints();
        gbcLabel6.gridx = 0; // Cột 0
        gbcLabel6.gridy = 0; // Hàng 0
        gbcLabel6.insets = new Insets(10, 10, 10, 10); // Canh lề
        jPanel2_1.add(jLabel6, gbcLabel6);

// Thiết lập ràng buộc cho jLabel4 trong jPanel2_1
        GridBagConstraints gbcLabel4 = new GridBagConstraints();
        gbcLabel4.gridx = 0; // Cột 0
        gbcLabel4.gridy = 1; // Hàng 1
        gbcLabel4.insets = new Insets(0, 10, 10, 10); // Canh lề
        jPanel2_1.add(jLabel4, gbcLabel4);

// Thiết lập ràng buộc cho jButton1 trong jPanel2_2
        GridBagConstraints gbcButton1 = new GridBagConstraints();
        gbcButton1.gridx = 0; // Cột 0
        gbcButton1.gridy = 0; // Hàng 0
        gbcButton1.insets = new Insets(10, 10, 10, 10); // Canh lề
        jPanel2_2.add(jButton1, gbcButton1);

// Thiết lập ràng buộc cho jButton2 trong jPanel2_2
        GridBagConstraints gbcButton2 = new GridBagConstraints();
        gbcButton2.gridx = 0; // Cột 0
        gbcButton2.gridy = 2; // Hàng 1
        gbcButton2.insets = new Insets(10, 10, 10, 10); // Canh lề
        jPanel2_2.add(jButton2, gbcButton2);

        jPanel2.add(jPanel2_1, BorderLayout.NORTH);
        jPanel2.add(jPanel2_2, BorderLayout.CENTER);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jPanel1, BorderLayout.WEST);
        getContentPane().add(jPanel2, BorderLayout.CENTER);

        pack();
        this.setLocationRelativeTo(null);
        this.setSize(850, 665);
    }

    public JButton getjButton1() {
        return jButton1;
    }
     public JButton getjButton3() {
        return jButton3;
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Giao_Dien_1().setVisible(true);
            }
        });
    }
}
