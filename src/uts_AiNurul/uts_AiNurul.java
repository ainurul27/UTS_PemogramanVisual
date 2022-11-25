/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_AiNurul;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class uts_AiNurul {
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String dbUrl = "jdbc:mysql://localhost/db_ainurul";
    String user = "root";
    String password = "";
    
    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    
    boolean responds;
    private boolean respons;
    
    public uts_AiNurul(){
        try {
            Class.forName(jdbcDriver);
            System.out.println("driver load.");
        } catch (ClassNotFoundException ex) {
            System.out.println("driver tidak ditemukan");
            Logger.getLogger(uts_AiNurul.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con = DriverManager.getConnection(dbUrl, user, password);
            System.out.println("berhasil koneksi dengan mysql");
        } catch (SQLException ex) {
            System.out.println("gagal terkoneksi, periksa confiq mysql");
            Logger.getLogger(uts_AiNurul.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean insertUts(String nim, String nama, String programstudi, String fakultas ){
        String query = "insert into tb_ainurul (NIM, Nama, Program_Studi, Fakultas) values (?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, nim);
            ps.setString(2, nama);
            ps.setString(3, programstudi);
            ps.setString(4, fakultas);
            ps.executeUpdate();
            responds = true;
            System.out.println("sukses insert");
        } catch (SQLException ex) {
            respons = false;
            System.out.println("gagal insert.");
            Logger.getLogger(uts_AiNurul.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respons;
    }  
}
