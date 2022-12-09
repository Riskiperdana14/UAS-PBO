package database;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class koneksi {
    static Connection con;
    static Statement stmt;
    static final String DB_URL = "jdbc:mysql://localhost/apotik2";
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
    public static void main(String[] args) {
        connect();
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
       
