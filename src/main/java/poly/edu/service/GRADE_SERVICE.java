/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.service;

import java.util.ArrayList;
import poly.edu.model.GRADES;
import poly.edu.reponsitory.GRADE_REPONSITORY;

/**
 *
 * @author Asus
 */
public class GRADE_SERVICE {

    GRADE_REPONSITORY grdr = new GRADE_REPONSITORY();

    public ArrayList<GRADES> getAllsGrade() throws Exception {
        return grdr.getAllsGrade();
    }

    public boolean themDiemSinhVien(GRADES d) throws Exception {
        return grdr.themDiemSinhVien(d);
    }

    public boolean upDateDiemSinhVien(GRADES d) throws Exception {
        return grdr.upDateDiemSinhVien(d);
    }

    public boolean deLeteDiemSinhVien(String MaSV) throws Exception {
        return grdr.deleteDiemSinhVien(MaSV);
    }
    public GRADES findByid(String MaSV) throws Exception {
        return grdr.findByid(MaSV);
    }
    public ArrayList<GRADES> findByTop3(int top)throws Exception{
        return grdr.findTop3(top);
    }

    

   
}
