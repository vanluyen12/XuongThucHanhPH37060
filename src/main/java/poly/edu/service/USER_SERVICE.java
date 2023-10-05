/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.service;

import poly.edu.model.USER;
import poly.edu.reponsitory.USER_REPONSITORY;

/**
 *
 * @author Asus
 */
public class USER_SERVICE {

    USER_REPONSITORY usr = new USER_REPONSITORY();

    public USER checkLogin(String tenDangnhap, String matkhau) throws Exception {
        return usr.checkLogin(tenDangnhap, matkhau);
    }
}
