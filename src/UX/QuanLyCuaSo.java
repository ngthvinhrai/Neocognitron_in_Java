/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UX;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class QuanLyCuaSo {

    private JFrame frame;
    private Giao_Dien_1 giaoDien1;
    private Giao_Dien_2 giaoDien2;
    private Giao_Dien_3 giaoDien3;
    private Giao_Dien_4 giaoDien4;
    private Giao_Dien_5 giaoDien5;
    private Giao_Dien_Thong_Tin_Nhom giaoDienThongTinNhom;
    private JFrame infoWindow; // Thêm cửa sổ mới để hiển thị Giao Diện Thông Tin

    public QuanLyCuaSo() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Giao Diện Chung");
        frame.setSize(850, 665);

        giaoDien1 = new Giao_Dien_1();
        giaoDien2 = new Giao_Dien_2();
        giaoDien3 = new Giao_Dien_3();
        giaoDien4 = new Giao_Dien_4();
        giaoDien5 = new Giao_Dien_5(); // Khởi tạo Giao_Dien_5

        giaoDien1.getjButton1().addActionListener(e -> hienThiGiaoDien2());
        giaoDien2.getjButton1().addActionListener(e -> hienThiGiaoDien4());
        giaoDien2.getjButton2().addActionListener(e -> hienThiGiaoDien3());

        giaoDien1.getjButton3().addActionListener(e -> hienThiGiaoDienThongTin()); // Khi nút 3 ở Giao Diện 1 được nhấn
        giaoDien2.getjButton3().addActionListener(e -> hienThiGiaoDien1());

        giaoDien3.getjButton4().addActionListener(e -> hienThiGiaoDien2());
        giaoDien4.getjButton4().addActionListener(e -> hienThiGiaoDien2());

        hienThiGiaoDien1();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                confirmExit();
            }
        });
    }

    private void confirmExit() {
        int choice = JOptionPane.showConfirmDialog(frame, "Bạn có chắc chắn muốn thoát không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0); // Chỉ gọi System.exit(0) nếu người dùng chọn "Yes"
        }
    }

    private void hienThiGiaoDien1() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(giaoDien1.getContentPane());
        frame.revalidate();
        frame.repaint();
        frame.setSize(850, 665);
    }

    private void hienThiGiaoDien2() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(giaoDien2.getContentPane());
        frame.revalidate();
        frame.repaint();
        frame.setSize(850, 665);
    }

    private void hienThiGiaoDien3() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(giaoDien3.getContentPane());
        frame.revalidate();
        frame.repaint();
        frame.setSize(850, 665);
    }

    private void hienThiGiaoDien4() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(giaoDien4.getContentPane());
        frame.revalidate();
        frame.repaint();
        frame.setSize(850, 665);
    }

    // Phương thức để hiển thị Giao Diện Thông Tin trong một cửa sổ mới
    private void hienThiGiaoDienThongTin() {
        if (infoWindow == null) {
            infoWindow = new JFrame();
            infoWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Đóng chỉ cửa sổ thông tin, không tác động đến cửa sổ chính
            infoWindow.setTitle("Thông Tin Nhóm");
            infoWindow.setSize(480, 600);
            infoWindow.setLocationRelativeTo(null);

            giaoDienThongTinNhom = new Giao_Dien_Thong_Tin_Nhom();
            infoWindow.getContentPane().add(giaoDienThongTinNhom.getContentPane());
        }

        infoWindow.setVisible(true);
    }

    public void hienThiCuaSo() {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 665);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    QuanLyCuaSo quanLyCuaSo = new QuanLyCuaSo();
                    quanLyCuaSo.hienThiCuaSo();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
