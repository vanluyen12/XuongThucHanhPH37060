/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.reponsitory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Asus
 */
public class DATABASE_CONNECT {
    public static Connection openConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String URL = "jdbc:sqlserver://localhost\\LAPTOP-5SFMOS30\\SQLEXPRESS:1433;databaseName=FPL_DaoTao";
        String USERNAME = "sa";
        String PASS = "1";
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASS);
        return conn;
    }
}
