/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.reponsitory;

import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.stream.Stream;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import poly.edu.model.STUDENTS;
import poly.edu.view.MAIN_FORM;

/**
 *
 * @author Asus
 */
public class STUDENT_REPONSITORY {

    public ArrayList<STUDENTS> getAllsStudent() throws Exception {
        ArrayList<STUDENTS> listST = new ArrayList<>();
        Connection con = DATABASE_CONNECT.openConnection();
        String sql = "SELECT * FROM STUDENTS";

        try ( Statement ST = con.createStatement();  ResultSet RS = ST.executeQuery(sql);) {
            while (RS.next()) {
                STUDENTS sv = createSinhVien(RS);
                listST.add(sv);

            }
        }
        return listST;
    }

    private STUDENTS createSinhVien(final ResultSet RS) throws SQLException {
        STUDENTS sv = new STUDENTS();
        sv.setMaSV(RS.getString("MASV"));
        sv.setTenSV(RS.getString("HOTEN"));
        sv.setEmail(RS.getString("EMAIL"));
        sv.setSoDT(RS.getString("SODT"));
        boolean gender = RS.getBoolean("GIOITINH");
        sv.setGioitinh(gender);
        sv.setDiaChi(RS.getString("DIACHI"));
        Blob blob = RS.getBlob("HINH");
        if(blob != null)
        sv.setHinh(blob.getBytes(1,(int) blob.length()));
        return sv;
    }

    public boolean themSinhvien(STUDENTS sv) throws SQLException, Exception {

        String sql = "INSERT INTO STUDENTS (MASV, HOTEN, EMAIL, SODT, GIOITINH, DIACHI, HINH) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try ( Connection con = DATABASE_CONNECT.openConnection();  PreparedStatement ST = con.prepareStatement(sql);) {
            ST.setString(1, sv.getMaSV());
            ST.setString(2, sv.getTenSV());
            ST.setString(3, sv.getEmail());
            ST.setString(4, sv.getSoDT());
            ST.setBoolean(5, sv.isGioitinh());
            ST.setString(6, sv.getDiaChi());
            if(sv.getHinh() !=  null){
                Blob hinh  = new SerialBlob(sv.getHinh());
                ST.setBlob(7, hinh);
            }else{
                Blob hinh = null;
                ST.setBlob(7, hinh);
            }
            return ST.executeUpdate() > 0;
        }

    }

    public boolean updateSinhvien(STUDENTS sv) throws SQLException, Exception {

        String sql = "UPDATE STUDENTS SET HOTEN = ?, EMAIL = ?, SODT = ?, GIOITINH = ?, DIACHI = ?, HINH = ? "
                + " WHERE MASV = ?";

        try ( Connection con = DATABASE_CONNECT.openConnection();  PreparedStatement ST = con.prepareStatement(sql);) {
            ST.setString(7, sv.getMaSV());
            ST.setString(1, sv.getTenSV());
            ST.setString(2, sv.getEmail());
            ST.setString(3, sv.getSoDT());
            ST.setBoolean(4, sv.isGioitinh());
            ST.setString(5, sv.getDiaChi());
            if(sv.getHinh() !=  null){
                Blob hinh  = new SerialBlob(sv.getHinh());
                ST.setBlob(6, hinh);
            }else{
                Blob hinh = null;
                ST.setBlob(6, hinh);
            }
            return ST.executeUpdate() > 0;
        }

    }

    public boolean xoaSinhvien(String maSV) throws SQLException, Exception {

        String sql = "DELETE FROM STUDENTS WHERE MASV = ?";

        try ( Connection con = DATABASE_CONNECT.openConnection();  PreparedStatement ST = con.prepareStatement(sql);) {

            ST.setString(1, maSV);
            return ST.executeUpdate() > 0;
        }

    }

    public STUDENTS findById(String maSV) throws SQLException, Exception {
        Connection con = DATABASE_CONNECT.openConnection();
        String sql = "SELECT * FROM STUDENTS"
                + " WHERE MASV = ? ";
        try ( PreparedStatement ST = con.prepareStatement(sql);) {
            ST.setString(1, maSV);
            try ( ResultSet RS = ST.executeQuery();) {
                if (RS.next()) {
                    STUDENTS sv = createSinhVien(RS);
                    return sv;
                }
            }
        }
        return null;

    }

    
}
