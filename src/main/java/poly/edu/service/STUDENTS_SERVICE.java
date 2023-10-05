/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.service;

import java.sql.SQLException;
import java.util.ArrayList;
import poly.edu.model.STUDENTS;
import poly.edu.reponsitory.STUDENT_REPONSITORY;

/**
 *
 * @author Asus
 */
public class STUDENTS_SERVICE {

    STUDENT_REPONSITORY stdrs = new STUDENT_REPONSITORY();

    public ArrayList<STUDENTS> getAllsStudent() throws Exception {
        return stdrs.getAllsStudent();
    }

    public boolean themSinhvien(STUDENTS sv) throws SQLException, Exception {
        return stdrs.themSinhvien(sv);
    }

    public boolean updateSinhvien(STUDENTS sv) throws SQLException, Exception {
        return stdrs.updateSinhvien(sv);
    }
    public boolean xoaSinhvien(String maSV) throws SQLException, Exception{
        return stdrs.xoaSinhvien(maSV);
    }
    public STUDENTS findById(String maSV) throws SQLException, Exception {
        return stdrs.findById(maSV);
    }
    }


