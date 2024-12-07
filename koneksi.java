/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubespbo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
    public static Connection connect(){
        Connection conn = null;
        String url = "jdbc:mysql://localhost:8111/tubes_pbo";
        String username = "root"; // Ganti dengan username yang benar
        String password = ""; // Ganti dengan password yang benar
        
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
        
        return conn;
    }
}
