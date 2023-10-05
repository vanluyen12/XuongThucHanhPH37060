/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.model;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class STUDENTS implements Serializable{
    private String MaSV,TenSV,Email,SoDT,DiaChi;
    private boolean  gioitinh;
    private byte [] hinh;

    public STUDENTS() {
    }

    public STUDENTS(String MaSV, String TenSV, String Email, String SoDT, String DiaChi, boolean gioitinh, byte[] hinh) {
        this.MaSV = MaSV;
        this.TenSV = TenSV;
        this.Email = Email;
        this.SoDT = SoDT;
        this.DiaChi = DiaChi;
        this.gioitinh = gioitinh;
        this.hinh = hinh;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getTenSV() {
        return TenSV;
    }

    public void setTenSV(String TenSV) {
        this.TenSV = TenSV;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public byte[] getHinh() {
        return hinh;
    }

    public void setHinh(byte[] hinh) {
        this.hinh = hinh;
    }

    
}
