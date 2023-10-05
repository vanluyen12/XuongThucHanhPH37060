/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.reponsitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import poly.edu.model.GRADES;

/**
 *
 * @author Asus
 */
public class GRADE_REPONSITORY {

    public ArrayList<GRADES> getAllsGrade() throws Exception {
        ArrayList<GRADES> lstGR = new ArrayList<>();
        Connection con = DATABASE_CONNECT.openConnection();
        String sql = "SELECT * FROM GRADE";
        try ( Statement ST = con.createStatement();  ResultSet RS = ST.executeQuery(sql);) {
            while (RS.next()) {
                GRADES d = createBangDiem(RS);
                lstGR.add(d);
            }

        }
        return lstGR;
    }

    public boolean themDiemSinhVien(GRADES d) throws Exception {
        String sql = "INSERT INTO GRADE (MASV, TIENGANH, TINHOC, GDTC)"
                + "VALUES(?,?,?,?)";
        try ( Connection conn = DATABASE_CONNECT.openConnection();  PreparedStatement ST = conn.prepareStatement(sql);) {

            ST.setString(1, d.getMasSV());
            ST.setFloat(2, d.getTiengAnh());
            ST.setFloat(3, d.getTinHoc());
            ST.setFloat(4, d.getGDTC());
            return ST.executeUpdate() > 0;
        }
    }

    public boolean upDateDiemSinhVien(GRADES d) throws Exception {
        String sql = " UPDATE GRADE "
                + " SET TIENGANH = ?, TINHOC = ?, GDTC = ?"
                + " WHERE MASV = ?";
        try ( Connection conn = DATABASE_CONNECT.openConnection();  PreparedStatement ST = conn.prepareStatement(sql);) {

            ST.setString(4, d.getMasSV());
            ST.setFloat(1, d.getTiengAnh());
            ST.setFloat(2, d.getTinHoc());
            ST.setFloat(3, d.getGDTC());
            return ST.executeUpdate() > 0;
        }
    }

    public boolean deleteDiemSinhVien(String MaSV) throws Exception {
        String sql = "DELETE FROM GRADE WHERE MASV = ?";

        try ( Connection conn = DATABASE_CONNECT.openConnection();  PreparedStatement ST = conn.prepareStatement(sql);) {

            ST.setString(1, MaSV);

            return ST.executeUpdate() > 0;
        }
    }

    public GRADES findByid(String MaSV) throws Exception {
        Connection con = DATABASE_CONNECT.openConnection();
        String sql = "SELECT * FROM GRADE"
                + " WHERE MASV = ? ";
        try ( PreparedStatement ST = con.prepareStatement(sql);) {
            ST.setString(1, MaSV);
            try ( ResultSet RS = ST.executeQuery();) {
                if (RS.next()) {
                    GRADES d = createBangDiem(RS);

                    return d;
                }
            } 
        }
        return null;
    }

    public ArrayList<GRADES> findTop3(int top) throws Exception {
        ArrayList<GRADES> lstGR = new ArrayList<>();
        Connection con = DATABASE_CONNECT.openConnection();
        String sql = "SELECT TOP " + top + " *, (TIENGANH + TINHOC + GDTC) / 3 AS 'DIEMTB' FROM GRADE ORDER BY (TIENGANH + TINHOC + GDTC) / 3 DESC";

        try ( Statement ST = con.createStatement();  ResultSet RS = ST.executeQuery(sql);) {
            while (RS.next()) {
                GRADES d = createBangDiem(RS);
                lstGR.add(d);
            }

        }
        return lstGR;
    }

    private GRADES createBangDiem(final ResultSet RS) throws SQLException {
        GRADES d = new GRADES();
        d.setId(RS.getInt("ID"));
        d.setMasSV(RS.getString("MASV"));
        d.setTiengAnh(RS.getFloat("TIENGANH"));
        d.setTinHoc(RS.getFloat("TINHOC"));
        d.setGDTC(RS.getFloat("GDTC"));
        return d;
    }
}
