/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.reponsitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import poly.edu.model.USER;

/**
 *
 * @author Asus
 */
public class USER_REPONSITORY {
    public USER checkLogin(String tendangnhap , String matkhau)throws Exception{
        String sql = "SELECT USERNAME , [PASSWORD],[ROLE] FROM USERS "
                + " WHERE USERNAME = ? AND [PASSWORD] =  ?";
        try(
                Connection con = DATABASE_CONNECT.openConnection();
                PreparedStatement ST = con.prepareStatement(sql);
                ){
                ST.setString(1, tendangnhap);
                ST.setString(2, matkhau);
                try (ResultSet RS = ST.executeQuery()){
                if(RS.next()){
                    USER us = new USER();
                    us.setTendangnhap(tendangnhap);
                    us.setVaitro(RS.getString("ROLE"));
                 return us;
                }
            } 
            
        }
        return null;
    }
}
