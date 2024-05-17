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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class Giao_Dien_Thong_Tin_Nhom extends JFrame {

    public Giao_Dien_Thong_Tin_Nhom() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 500));

        // Panel chứa nội dung chính
        JPanel contentPanel = new JPanel(new BorderLayout());

        // Panel chứa phần header
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(101, 178, 161));

        JLabel logoLabel = new JLabel(new ImageIcon(getClass().getResource("/ANH_NEN/GDTT_ICON_1.png")));
        JLabel titleLabel = new JLabel("Kỹ Thuật Robot và Trí tuệ nhân tạo K62", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);

        // Label chứa chữ "Thành Viên Nhóm 06"
        JLabel teamLabel = new JLabel("Thành Viên Nhóm 06", SwingConstants.CENTER);
        teamLabel.setFont(new Font("Times New Roman", Font.BOLD, 34));
        teamLabel.setForeground(Color.WHITE);

        headerPanel.add(teamLabel, BorderLayout.NORTH); // Thêm label "Thành Viên Nhóm 06" vào phía Bắc
        headerPanel.add(logoLabel, BorderLayout.CENTER);
        headerPanel.add(titleLabel, BorderLayout.SOUTH);

        contentPanel.add(headerPanel, BorderLayout.NORTH);

        // Panel chứa danh sách thành viên nhóm
        JPanel memberPanel = new JPanel(new GridLayout(5, 1));
        memberPanel.setBackground(Color.WHITE);

        JLabel[] memberLabels = {
            new JLabel("NGUYỄN THANH NGỌC", SwingConstants.CENTER),
            new JLabel("KIỂU VIỆT CƯỜNG", SwingConstants.CENTER),
            new JLabel("PHẠM NGỌC HẢI", SwingConstants.CENTER),
            new JLabel("LÊ VĂN PHÚ", SwingConstants.CENTER),
            new JLabel("NGUYỄN THÀNH VINH", SwingConstants.CENTER)
        };

        for (JLabel label : memberLabels) {
            label.setFont(new Font("Times New Roman", Font.BOLD, 24));
            label.setForeground(new Color(101, 178, 161));
            memberPanel.add(label);
        }

        contentPanel.add(memberPanel, BorderLayout.CENTER);

        add(contentPanel);
        pack();
        setLocationRelativeTo(null); // Đưa cửa sổ ra giữa màn hình
        setSize(500, 600);
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Giao_Dien_Thong_Tin_Nhom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Giao_Dien_Thong_Tin_Nhom().setVisible(true);
        });
    }
}
