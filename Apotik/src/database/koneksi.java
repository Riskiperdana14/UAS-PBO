package database;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class koneksi {
    static Connection con;
    static Statement stmt;
    static final String DB_URL = "jdbc:mysql://localhost/apotik";
    static String username = "root";
    static String password = "";

    public static Connection connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL,username,password);
            stmt = con.createStatement(); 
            System.out.println("Koneksi Berhasil");
        } catch (Exception e) {
            System.out.println("Koneksi Gagal");
        }
        return con;
    }
    
    public static void insert_user(String username, String password){
        try {
            String sql = "INSERT INTO username(username,password) VALUES('"+username+"','"+password+"')";
            stmt = connect().createStatement();
            stmt.execute(sql);
            
            
            System.out.println("Tambah Data Berhasil");
        } catch (Exception e) {
            System.out.println("Tambah Data Gagal");
        }  
    }
    public static void delete_user(String username){
        try {
            String sql = "DELETE FROM username WHERE username='"+username+"'";
            stmt = connect().createStatement();
            stmt.execute(sql);
            
            
            System.out.println("Hapus Data Berhasil");
        } catch (Exception e) {
            System.out.println("Hapus Data Gagal");
        }  
    }    
     public static void update_user(String username){
        try {
            String sql = "UPDATE TABLE username set username='"+username+"' WHERE username='"+username+"'";
            stmt = connect().createStatement();
            stmt.execute(sql);
            
            
            System.out.println("Hapus Data Berhasil");
        } catch (Exception e) {
            System.out.println("Hapus Data Gagal");
        }  
    }     
    public static void read_user(String username){
        try {
            String sql = "SELECT * FROM username WHERE username='"+username+"'";
            stmt = connect().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            System.out.println("Username :"+rs.getString("username"));
            System.out.println("Password :"+rs.getString("password"));
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ambil Data Gagal");
        }  
    }  
    public static void read_user_all(){
        try {
            String sql = "SELECT * FROM username ";
            stmt = connect().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println("Username :"+rs.getString("username"));
                System.out.println("Password :"+rs.getString("password"));            
            }
        } catch (Exception e) {
            System.out.println("Ambil Data Gagal");
            e.printStackTrace();
        }
    }
}
       
