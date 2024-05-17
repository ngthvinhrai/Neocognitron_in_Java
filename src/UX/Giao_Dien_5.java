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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Giao_Dien_5 extends JFrame {

    public Giao_Dien_5() {
        initComponents();
    }
    private double[][][] matrix;

    public Giao_Dien_5(int ketQua, double[][][] pixelMatrix) {
        Map<Integer, String> ketQuaMap = new HashMap<>();

        // Thêm các cặp key-value vào map
        ketQuaMap.put(9, "A");
        ketQuaMap.put(12, "B");
        ketQuaMap.put(19, "C");
        ketQuaMap.put(11, "D");
        ketQuaMap.put(3, "E");
        ketQuaMap.put(0, "F");
        ketQuaMap.put(24, "G");
        ketQuaMap.put(4, "H");
        ketQuaMap.put(14, "I");
        ketQuaMap.put(7, "J");
        ketQuaMap.put(null, "K");
        ketQuaMap.put(10, "L");
        ketQuaMap.put(2, "M");
        ketQuaMap.put(5, "N");
        ketQuaMap.put(17, "O");
        ketQuaMap.put(13, "P");
        ketQuaMap.put(20, "Q");
        ketQuaMap.put(1, "R");
        ketQuaMap.put(23, "S");
        ketQuaMap.put(18, "T");
        ketQuaMap.put(6, "U");
        ketQuaMap.put(15, "V");
        ketQuaMap.put(25, "W");
        ketQuaMap.put(16, "X");
        ketQuaMap.put(8, "Y");
        ketQuaMap.put(21, "Z");
        this.ketQua = ketQua;
        ketQuaString = ketQuaMap.containsKey(ketQua) ? ketQuaMap.get(ketQua) : "null"; // Di chuyển đoạn này lên trước

//        System.out.println(ketQuaString);
        this.matrix = pixelMatrix;
        initComponents();
        displayImage();
    }

    private String ketQuaString;

    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private Giao_Dien_3 giaoDien3;
    private int ketQua;

    private void initComponents() {
//        System.out.println(ketQuaString);
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jLabel2 = new JLabel();
        jPanel3 = new JPanel();
        jLabel5 = new JLabel();
        jPanel4 = new JPanel();
        jLabel4 = new JLabel();
        jPanel5 = new JPanel();
        jButton1 = new JButton();
        jLabel1 = new JLabel();
        jButton2 = new JButton();
        jLabel3 = new JLabel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(101, 178, 161));
        jPanel2.setBackground(new Color(101, 178, 161));
        jPanel3.setBackground(new Color(101, 178, 161));
        jPanel4.setBackground(new Color(101, 178, 161));
        jPanel5.setBackground(new Color(101, 178, 161));

        jLabel2.setFont(new Font("Times New Roman", 1, 30));
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("                   NHẬN DIỆN THÀNH CÔNG - ĐÂY LÀ CHỮ " + ketQuaString);

        String imagePath = "/ANH_NEN/" + ketQuaString + ".png";
        jLabel5.setIcon(new ImageIcon(getClass().getResource(imagePath)));
        jLabel4.setText("");

        jButton1.setIcon(new ImageIcon(getClass().getResource("/ANH_NEN/GD5_ICON_1.png")));
        jButton1.addActionListener(e -> {
            String soundPath = "BangChuCaiTA\\" + ketQuaString + ".wav"; // Replace "path_to_your_sound_files/" with the actual path
            System.out.println(soundPath);
            playSound(soundPath);
        });
        jButton2.addActionListener(e -> {
            dispose();
        });
        jLabel1.setBackground(new Color(255, 255, 255));
        jLabel1.setFont(new Font("Times New Roman", 1, 24));
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("VOICE");

        jButton2.setBackground(new Color(101, 178, 161));
        jButton2.setIcon(new ImageIcon(getClass().getResource("/ANH_NEN/GD2_ICON_3.png")));

        jLabel3.setBackground(new Color(101, 178, 161));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setIcon(new ImageIcon(getClass().getResource("/ANH_NEN/GD5_ICON_2.png")));

        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(jLabel2, BorderLayout.CENTER);
        jPanel1.add(jButton2, BorderLayout.WEST);
        jPanel1.setPreferredSize(new Dimension(100, 100));

        jLabel4.setPreferredSize(new Dimension(360, 360));
        jLabel5.setPreferredSize(new Dimension(360, 360));
        jPanel4.setPreferredSize(new Dimension(1200, 500));
        jPanel2.add(jLabel4);
        jPanel3.add(jLabel5);

        jPanel4.setLayout(new GridLayout(1, 3));
        jPanel4.add(jPanel2);
        jPanel4.add(jLabel3);
        jPanel4.add(jPanel3);
        jPanel4.setPreferredSize(new Dimension(1200, 500));

        jPanel5.setLayout(new GridLayout(2, 1));
        jPanel5.add(jButton1);
        jPanel5.add(jLabel1);

        getContentPane().add(jPanel1, BorderLayout.NORTH);
        getContentPane().add(jPanel4, BorderLayout.CENTER);
        getContentPane().add(jPanel5, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private void displayImage() {
        BufferedImage image = new BufferedImage(matrix[0][0].length, matrix[0].length, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0][0].length; j++) {
                // Lấy giá trị RGB từ ma trận
                int pixelValue = (int) (matrix[0][i][j] * 255);
                // Đảo ngược màu cho phù hợp với yêu cầu
                int invertedPixelValue = 255 - pixelValue;
                Color color = new Color(invertedPixelValue, invertedPixelValue, invertedPixelValue);
                // Gán màu cho hình ảnh với thứ tự đúng
                image.setRGB(j, i, color.getRGB());
            }
        }

        // Scale và hiển thị hình ảnh
        Image scaledImage = image.getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(), Image.SCALE_SMOOTH);
        jLabel4.setIcon(new ImageIcon(scaledImage));
    }

    public JButton getjButton2() {
        return jButton2;
    }

    private void playSound(String soundPath) {
        try {
            // Kiểm tra nếu đường dẫn âm thanh không rỗng
            if (soundPath != null && !soundPath.isEmpty()) {
                // Tạo đối tượng File từ đường dẫn âm thanh
                File soundFile = new File(soundPath);
                // Kiểm tra nếu tệp âm thanh tồn tại
                if (soundFile.exists()) {
                    // Tạo AudioInputStream từ tệp âm thanh
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    // Tạo Clip từ AudioInputStream
                    Clip clip = AudioSystem.getClip();
                    // Mở Clip và phát âm thanh
                    clip.open(audioIn);
                    clip.start();
                } else {
                    System.err.println("File âm thanh không tồn tại: " + soundPath);
                }
            } else {
                System.err.println("Đường dẫn âm thanh không hợp lệ.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Giao_Dien_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Giao_Dien_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Giao_Dien_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Giao_Dien_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Giao_Dien_5().setVisible(true);
            }
        });
    }

}
