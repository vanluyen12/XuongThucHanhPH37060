/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package poly.edu.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import poly.edu.model.GRADES;
import poly.edu.model.STUDENTS;
import poly.edu.reponsitory.STUDENT_REPONSITORY;
import poly.edu.service.GRADE_SERVICE;
import poly.edu.service.ImageSelect;
import poly.edu.service.STUDENTS_SERVICE;

/**
 *
 * @author Asus
 */
public class MANAGEMENT_STUDENTS extends javax.swing.JPanel {

    private MANAGEMENT_STUDENTS mainForm;
    private final STUDENTS_SERVICE stdsv = new STUDENTS_SERVICE();
    private final STUDENT_REPONSITORY stdrs = new STUDENT_REPONSITORY();
    private DefaultTableModel model;
    private int index;
    private byte[] peopleImage;
    private ArrayList<STUDENTS> listSVV = stdsv.getAllsStudent();

    public MANAGEMENT_STUDENTS() throws Exception {
        initComponents();
        model = (DefaultTableModel) tblStudent.getModel();
        LoadToTable();
    }

    private void LoadToTable() throws Exception {

        model.setRowCount(0);
        ArrayList<STUDENTS> list = stdsv.getAllsStudent();
        for (STUDENTS students : list) {
            String gender = students.isGioitinh() ? "Nam" : "Nữ";
            model.addRow(new Object[]{
                students.getMaSV(), students.getTenSV(), students.getEmail(), students.getSoDT(),
                gender, students.getDiaChi(), students.getHinh()
            });
        }

        String[] data = {
            "MÃ SV", "HỌ TÊN", "EMAIL", "SỐ DT", "GIOITINH", "ĐỊA CHỈ", "HÌNH"
        };
        model.setColumnIdentifiers(data);
    }

    public void showDetail() throws IOException {
        STUDENTS sv = listSVV.get(index);
//        txtMaSVST.setText((String) tblStudent.getValueAt(index, 0).toString());
//        txtNameST.setText((String) tblStudent.getValueAt(index, 1).toString());
//        txtEmailST.setText((String) tblStudent.getValueAt(index, 2).toString());
//        txtSDTST.setText((String) tblStudent.getValueAt(index, 3).toString());
//        boolean gioitinh = (boolean) tblStudent.getValueAt(index, 4).equals("Nam");
//        rdoMale.setSelected(gioitinh);
//        rdoFemale.setSelected(!gioitinh);
//        txtAddressST.setText((String) tblStudent.getValueAt(index, 5).toString());

        txtMaSVST.setText(sv.getMaSV());
        txtNameST.setText(sv.getTenSV());
        txtEmailST.setText(sv.getEmail());
        txtSDTST.setText(sv.getSoDT());
        rdoMale.setSelected(sv.isGioitinh());
        rdoFemale.setSelected(!sv.isGioitinh());
        txtAddressST.setText(sv.getDiaChi());
        if (sv.getHinh() != null) {
            Image img = ImageSelect.createFromByArrayListImage(sv.getHinh(), "jgp");
            lblAnhSV.setIcon(new ImageIcon(img));
            peopleImage = sv.getHinh();
        } else {
            try {
                peopleImage = sv.getHinh();
                BufferedImage originalImage = ImageIO.read(new File("D:\\SOF203_SD18317\\ASSIGNMENT_HT\\src\\main\\java\\poly\\edu\\icons\\Occupations-Technical-Support-Representative-Male-Dark-icon-48.png"));
                int width = 140; // Desired width
                int height = 160; // Desired height
                Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaledImage);
                lblAnhSV.setIcon(icon);
            } catch (Exception e) {
            }
        }
//        tblStudent.setRowSelectionInterval(index, index);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGender = new javax.swing.ButtonGroup();
        lblTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblMaSV = new javax.swing.JLabel();
        lblTenSV = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        txtMaSVST = new javax.swing.JTextField();
        txtNameST = new javax.swing.JTextField();
        txtEmailST = new javax.swing.JTextField();
        txtSDTST = new javax.swing.JTextField();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddressST = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        lblAnhSV = new javax.swing.JLabel();
        btnNewST = new javax.swing.JButton();
        btnSaveST = new javax.swing.JButton();
        btnDeleteST = new javax.swing.JButton();
        btnUpdateST = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 0, 51));
        lblTitle.setText("QUẢN LÍ SINH VIÊN  ");

        lblMaSV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaSV.setText("Mã Sinh Viên : ");

        lblTenSV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenSV.setText("Tên Sinh Viên : ");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmail.setText("Email : ");

        lblSDT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSDT.setText("Số Điện Thoại : ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        lblGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGioiTinh.setText("Giới Tính : ");

        lblDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDiaChi.setText("Địa chỉ  :  ");

        txtMaSVST.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaSVSTFocusLost(evt);
            }
        });

        btnGender.add(rdoMale);
        rdoMale.setText("Nam");

        btnGender.add(rdoFemale);
        rdoFemale.setText("Nữ");

        txtAddressST.setColumns(20);
        txtAddressST.setRows(5);
        jScrollPane1.setViewportView(txtAddressST);

        lblAnhSV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnhSV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAnhSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhSVMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnhSV, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnhSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnNewST.setIcon(new javax.swing.ImageIcon("D:\\SOF203_SD18317\\ASSIGNMENT_HT\\src\\main\\java\\poly\\edu\\icons\\new-icon-16.png")); // NOI18N
        btnNewST.setText("New");
        btnNewST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewSTActionPerformed(evt);
            }
        });

        btnSaveST.setIcon(new javax.swing.ImageIcon("D:\\SOF203_SD18317\\ASSIGNMENT_HT\\src\\main\\java\\poly\\edu\\icons\\Save-icon.png")); // NOI18N
        btnSaveST.setText("Save");
        btnSaveST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSTActionPerformed(evt);
            }
        });

        btnDeleteST.setIcon(new javax.swing.ImageIcon("D:\\SOF203_SD18317\\ASSIGNMENT_HT\\src\\main\\java\\poly\\edu\\icons\\Button-Close-icon-16.png")); // NOI18N
        btnDeleteST.setText("Delete");
        btnDeleteST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSTActionPerformed(evt);
            }
        });

        btnUpdateST.setIcon(new javax.swing.ImageIcon("D:\\SOF203_SD18317\\ASSIGNMENT_HT\\src\\main\\java\\poly\\edu\\icons\\Actions-document-edit-icon-16.png")); // NOI18N
        btnUpdateST.setText("Update");
        btnUpdateST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSTActionPerformed(evt);
            }
        });

        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblStudent);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTitle)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblEmail)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTenSV)
                                        .addComponent(lblMaSV, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(lblSDT)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblGioiTinh))
                                    .addComponent(lblDiaChi))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaSVST)
                                    .addComponent(txtSDTST, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                    .addComponent(txtEmailST, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                    .addComponent(txtNameST, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdoMale)
                                        .addGap(39, 39, 39)
                                        .addComponent(rdoFemale))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(110, 110, 110)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnNewST)
                                            .addComponent(btnUpdateST))
                                        .addGap(43, 43, 43)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnDeleteST)
                                            .addComponent(btnSaveST))))))
                        .addGap(0, 326, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDeleteST, btnNewST, btnSaveST, btnUpdateST});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtMaSVST, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2))
                                    .addComponent(lblMaSV))
                                .addGap(18, 18, 18)
                                .addComponent(lblTenSV))
                            .addComponent(txtNameST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmailST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSDT)
                            .addComponent(txtSDTST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGioiTinh)
                            .addComponent(rdoMale)
                            .addComponent(rdoFemale)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDiaChi)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNewST)
                            .addComponent(btnSaveST))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeleteST)
                            .addComponent(btnUpdateST))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDeleteST, btnNewST, btnSaveST, btnUpdateST});

    }// </editor-fold>//GEN-END:initComponents

    private void btnNewSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewSTActionPerformed
        txtMaSVST.requestFocus();
        txtNameST.setText("");
        txtEmailST.setText("");
        txtSDTST.setText("");
        txtAddressST.setText("");
        btnGender.clearSelection();
        peopleImage = null;
//        ImageIcon icon3 = new ImageIcon(
//                getClass().getClassLoader().getResource("/10207-man-student-light-skin-tone-icon-64"));
//        lblAnhSV.setIcon(icon3);
        try {
            BufferedImage originalImage = ImageIO.read(new File("D:\\SOF203_SD18317\\ASSIGNMENT_HT\\src\\main\\java\\poly\\edu\\icons\\Login-icon-16.png"));
            int width = 140; // Desired width
            int height = 160; // Desired height
            Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImage);
            lblAnhSV.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnNewSTActionPerformed

    private void lblAnhSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhSVMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;

                } else {
                    return f.getName().toLowerCase().endsWith(".jpg");
                }
            }

            @Override
            public String getDescription() {
                return "Image file (*jpg)";
            }

        });
        if (chooser.showOpenDialog(mainForm) == JFileChooser.CANCEL_OPTION) {
            return;
        }
        File file = chooser.getSelectedFile();
        try {
            ImageIcon icon1 = new ImageIcon(file.getPath());
            Image img = ImageSelect.resize(icon1.getImage(), 140, 160);
            ImageIcon icon2 = new ImageIcon(img);
            lblAnhSV.setIcon(icon2);
            peopleImage = ImageSelect.toArrayListImage(img, "jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_lblAnhSVMouseClicked

    private void btnSaveSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSTActionPerformed
        try {
            if (checkEmty()) {
                return;
            }
//            STUDENTS sv = StudentMethod();
            STUDENTS sv = new STUDENTS();
            sv.setMaSV(txtMaSVST.getText());
            sv.setTenSV(txtNameST.getText());
            sv.setEmail(txtEmailST.getText());
            sv.setSoDT(txtSDTST.getText());
            boolean gioitinh = rdoMale.isSelected();
            sv.setGioitinh(gioitinh);
            sv.setDiaChi(txtAddressST.getText());
            sv.setHinh(peopleImage);
            if (stdsv.themSinhvien(sv)) {
                JOptionPane.showMessageDialog(this, "Thêm thành công !");
                LoadToTable();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại !");
                return;
            }
        } catch (Exception e) {
            String ma = txtMaSVST.getText();
            String errorMessage = e.getMessage();
            if (errorMessage.contains("Violation of PRIMARY KEY constraint 'PK__STUDENTS__60228A2818DB26B7'. Cannot insert duplicate key in object 'dbo.STUDENTS'. The duplicate key value is (" + ma + ").")) {
                // Nếu lỗi là do vi phạm ràng buộc PRIMARY KEY, hiển thị thông báo lỗi tương ứng
                // có thể sử dụng JLabel hoặc JOptionPane để hiển thị thông báo
                JOptionPane.showMessageDialog(this, "Mã Sinh Viên :  " + ma + " đã tồn tại!");
            }
        }
    }//GEN-LAST:event_btnSaveSTActionPerformed

    private void btnUpdateSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSTActionPerformed
        try {
//            STUDENTS sv = StudentMethod();

            STUDENTS sv = new STUDENTS();
            sv.setMaSV(txtMaSVST.getText());
            sv.setTenSV(txtNameST.getText());
            sv.setEmail(txtEmailST.getText());
            sv.setSoDT(txtSDTST.getText());
            boolean gioitinh = rdoMale.isSelected();
            sv.setGioitinh(gioitinh);
            sv.setDiaChi(txtAddressST.getText());
            sv.setHinh(peopleImage);
            if (checkEmty()) {
                return;
            }
            int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn Update hay không  ? ", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (chon != JOptionPane.YES_OPTION) {
                return;
            } else {
                if (stdsv.updateSinhvien(sv)) {
                    JOptionPane.showMessageDialog(this, "Update thành công !");
                    LoadToTable();
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Update thất bại !");
                    return;
                }
            }

        } catch (Exception e) {
            System.out.println("Lỗi : " + e);
        }
    }//GEN-LAST:event_btnUpdateSTActionPerformed

    private void btnDeleteSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSTActionPerformed
        try {
//            STUDENTS sv = StudentMethod();
            STUDENTS sv = new STUDENTS();
            sv.setMaSV(txtMaSVST.getText());
            sv.setTenSV(txtNameST.getText());
            sv.setEmail(txtEmailST.getText());
            sv.setSoDT(txtSDTST.getText());
            boolean gioitinh = rdoMale.isSelected();
            sv.setGioitinh(gioitinh);
            sv.setDiaChi(txtAddressST.getText());
            sv.setHinh(peopleImage);
            int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không ?", "Thông báo ", JOptionPane.YES_NO_OPTION);
            if (chon != JOptionPane.YES_OPTION) {
                return;
            } else {
                if (stdsv.xoaSinhvien(txtMaSVST.getText())) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công !");
                    LoadToTable();
                    btnNewSTActionPerformed(evt);
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại !");
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi : " + e);
        }
    }//GEN-LAST:event_btnDeleteSTActionPerformed

    private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentMouseClicked
        try {
            index = tblStudent.getSelectedRow();
            if (index >= 0 && index < tblStudent.getRowCount()) {
                showDetail();
//                LoadToTable();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Chưa có phần tử nào được chọn");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            index = tblStudent.getSelectedRow();
//
//            if (index >= 0) {
//                String id = (String) tblStudent.getValueAt(index, 0);
//                STUDENTS sv = stdrs.getAllsStudent();
//                if (sv != null) {
//                    txtMaSVST.setText(sv.getMaSV());
//                    txtNameST.setText(sv.getTenSV());
//                    txtEmailST.setText(sv.getEmail());
//                    txtSDTST.setText(sv.getSoDT());
//                    boolean gioitinh = rdoMale.isSelected();
//                    sv.setGioitinh(gioitinh);
//                    txtAddressST.setText(sv.getDiaChi());
//                }
//
//            }
//        } catch (Exception e) {
//        }
    }//GEN-LAST:event_tblStudentMouseClicked

    private void txtMaSVSTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaSVSTFocusLost
        try {
            STUDENTS sv = stdsv.findById(txtMaSVST.getText());
            if (sv != null) {
                txtNameST.setText(sv.getTenSV());
                txtEmailST.setText(sv.getEmail());
                txtSDTST.setText(sv.getSoDT());
                rdoMale.setSelected(sv.isGioitinh());
                rdoFemale.setSelected(!sv.isGioitinh());
                txtAddressST.setText(sv.getDiaChi());
                if (sv.getHinh() != null) {
                    Image img = ImageSelect.createFromByArrayListImage(sv.getHinh(), "jgp");
                    lblAnhSV.setIcon(new ImageIcon(img));
                    peopleImage = sv.getHinh();
                } else {

                    peopleImage = sv.getHinh();
                    BufferedImage originalImage = ImageIO.read(new File("D:\\SOF203_SD18317\\ASSIGNMENT_HT\\src\\main\\java\\poly\\edu\\icons\\Occupations-Technical-Support-Representative-Male-Dark-icon-48.png"));
                    int width = 140; // Desired width
                    int height = 160; // Desired height
                    Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaledImage);
                    lblAnhSV.setIcon(icon);
//                    txtMaSVSTFocusLost(null);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi" + e);
        }
    }//GEN-LAST:event_txtMaSVSTFocusLost

//    private STUDENTS StudentMethod() throws NumberFormatException {
    //        STUDENTS sv = new STUDENTS();
    //        sv.setMaSV(txtMaSVST.getText());
    //        sv.setTenSV(txtNameST.getText());
    //        sv.setEmail(txtEmailST.getText());
    //        sv.setSoDT(txtSDTST.getText());
    //        boolean gioitinh = rdoMale.isSelected();
    //        sv.setGioitinh(gioitinh);
    //        sv.setDiaChi(txtAddressST.getText());
    //
    //        return sv;
    //    }
    //    private boolean isSinhVienUnchanged(STUDENTS sv) {
    //        return sv.getTenSV().equals(sv.getTenSV())
    //                && sv.getEmail().equals(sv.getEmail())
    //                && sv.getSoDT().equals(sv.getSoDT())
    //                && sv.isGioitinh() == sv.isGioitinh()
    //                && sv.getDiaChi().equals(sv.getDiaChi())
    //                && Arrays.equals(sv.getHinh(), sv.getHinh());
    //    }
    public boolean checkEmty() {
        StringBuilder sb = new StringBuilder();

        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String email = txtEmailST.getText().trim(); // Thay bằng địa chỉ email cần kiểm tra

        if (txtMaSVST.getText().equals("")) {
            sb.append("Mã sinh viên trống ! \n");
        }
        if (txtMaSVST.getText().length() > 10) {
            sb.append("Mã sinh viên vượt quá kí tự cho phép ! \n");
        }
        if (txtNameST.getText().isEmpty()) {
            sb.append("Tên sinh viên đang trống !\n");
        } else {
            String name = txtNameST.getText();
            // Sử dụng biểu thức chính quy để kiểm tra xem có kí tự số trong tên hay không
            if (name.matches(".*\\d.*")) {
                sb.append("Tên không hợp lệ, không được chứa số!\n");
            }
        }
        if (email.matches(emailPattern)) {

        } else {
            // Email không hợp lệ
            sb.append("Email không hợp lệ!\n");
        }
        if (txtAddressST.getText().equals("")) {
            sb.append("Địa chỉ sinh viên trống ! \n");
        }
        if (txtSDTST.getText().length() > 10) {
            sb.append("Số điện thoại vượt quá kí tự cho phép ! \n");
        }
        if (txtSDTST.getText().isEmpty()) {
            sb.append("Số điện thoại trống!\n");
        } else {
            String phoneNumber = txtSDTST.getText().trim();
            // Sử dụng biểu thức chính quy để kiểm tra xem số điện thoại có chỉ chứa kí tự số hay không
            if (!phoneNumber.matches("\\d+")) {
                sb.append("Số điện thoại không hợp lệ, chỉ được chứa các kí tự số!\n");
            }
        }

        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteST;
    private javax.swing.ButtonGroup btnGender;
    private javax.swing.JButton btnNewST;
    private javax.swing.JButton btnSaveST;
    private javax.swing.JButton btnUpdateST;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAnhSV;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblMaSV;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblTenSV;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTextArea txtAddressST;
    private javax.swing.JTextField txtEmailST;
    private javax.swing.JTextField txtMaSVST;
    private javax.swing.JTextField txtNameST;
    private javax.swing.JTextField txtSDTST;
    // End of variables declaration//GEN-END:variables

}
