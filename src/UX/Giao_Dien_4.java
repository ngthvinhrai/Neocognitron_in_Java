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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Giao_Dien_4 extends JFrame implements ActionListener {

    private JPanel jPanel1, jPanel2;
    private JButton jButton1, jButton2, jButton3, jButton4;
    private JLabel jLabel1, jLabel2, jLabel3;

    public Giao_Dien_4() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jButton4 = new JButton();

        jPanel2 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();

        jPanel1.setBackground(new Color(101, 178, 161));

        jLabel1.setBackground(new Color(255, 255, 255));
        jLabel1.setText("jLabel1");

        jButton4.setBackground(new Color(101, 178, 161));
        jButton4.setIcon(new ImageIcon(getClass().getResource("/ANH_NEN/GD2_ICON_3.png")));
        jButton4.addActionListener(this);

        jPanel2.setBackground(new Color(101, 178, 161));

        jButton1.setIcon(new ImageIcon(getClass().getResource("/ANH_NEN/GD3_ICON_2.png")));
        jButton1.addActionListener(this);

        jButton2.setIcon(new ImageIcon(getClass().getResource("/ANH_NEN/GD3_ICON_1.png")));

        jButton3.setIcon(new ImageIcon(getClass().getResource("/ANH_NEN/GD3_ICON_3.png")));
        jButton3.addActionListener(this);

        jLabel2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("X");
        jLabel2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new ImageIcon(getClass().getResource("/ANH_NEN/GD4_ICON_1.png")));

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(71, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                                        .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(58, 58, 58))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGap(0, 39, Short.MAX_VALUE)
                                                .addComponent(jLabel3)
                                                .addGap(34, 34, 34)))
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jButton3)
                                .addGap(53, 53, 53))
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(56, 56, 56)
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        this.setLocationRelativeTo(null);
        this.setSize(850, 665);
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public JButton getjButton4() {
        return jButton4;
    }

    private void jButton4ActionPerformed(ActionEvent evt) {
        // Handle jButton4 click event
    }

    private void jLabel2MouseClicked(MouseEvent evt) {
        System.exit(0);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Giao_Dien_4().setVisible(true);
            }
        });
    }
}
