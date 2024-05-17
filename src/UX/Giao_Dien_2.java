/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UX;

/**
 *
 * @author admin
 */
import javax.swing.*;
import java.awt.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Giao_Dien_2 extends JFrame {

    private final JButton jButton1;
    private final JButton jButton2;
    private final JButton jButton3;
    private final JLabel jLabel1;
    private final JLabel jLabel2;
    private final JLabel jLabel3;
    private final JLabel jLabel4;
    private final JLabel jLabel5;
    private final JLabel jLabel6;
    private final JPanel jPanel1;
    private final JPanel jPanel2;
    private final JPanel jPanel3;

    public Giao_Dien_2() {
        jPanel1 = new JPanel(new BorderLayout());
        jPanel2 = new JPanel(new BorderLayout());
        jPanel3 = new JPanel(new GridLayout(2, 2,150,0));
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(101, 178, 161));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 28));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHÀO BẠN, TÔI SẼ GIÚP BẠN NHẬN DIỆN NHÉ ");

        jButton3.setBackground(new java.awt.Color(101, 178, 161));
        jButton3.setIcon(new ImageIcon(getClass().getResource("/ANH_NEN/GD2_ICON_3.png")));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new ImageIcon(getClass().getResource("/ANH_NEN/GD2_ICON_4.png")));

        jPanel1.add(jLabel1, BorderLayout.EAST);
        jPanel1.add(jButton3, BorderLayout.WEST);
        jPanel1.add(jLabel5, BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new ImageIcon(getClass().getResource("/ANH_NEN/GD2_ICON_1.png")));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new ImageIcon(getClass().getResource("/ANH_NEN/GD2_ICON_2.png")));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48));
        jLabel2.setForeground(new java.awt.Color(101, 178, 161));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CHỌN CHẾ ĐỘ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jLabel3.setForeground(new java.awt.Color(101, 178, 161));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("NHẬN DIỆN HÌNH ẢNH");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jLabel4.setForeground(new java.awt.Color(101, 178, 161));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("NHẬN DIỆN NÉT VẼ");

        jPanel2.add(jLabel2);

        jPanel3.add(jButton1);
        jPanel3.add(jButton2);
        jPanel3.add(jLabel3);
        jPanel3.add(jLabel4);

        getContentPane().add(jPanel1, BorderLayout.NORTH);
        getContentPane().add(jPanel2, BorderLayout.CENTER);
        getContentPane().add(jPanel3, BorderLayout.SOUTH);
        pack();
        this.setLocationRelativeTo(null);
        this.setSize(900, 700);
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public JButton getjButton2() {
        return jButton2;
    }

    public JButton getjButton3() {
        return jButton3;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Giao_Dien_2().setVisible(true);
            }
        });
    }
}
