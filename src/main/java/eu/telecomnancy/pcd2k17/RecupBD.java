package eu.telecomnancy.pcd2k17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RecupBD {
	
	private static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:src/main/java/database/eleves2.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connecté");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
 
    public static void select(){
        String sql = "SELECT * FROM eleves2";
        
        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
            		int idtableau = rs.getInt("id");
            		String nomtableau = rs.getString("nom");
            		String emailtableau = rs.getString("email");
            		int agetableau = rs.getInt("age");
            		String classetableau = rs.getString("classe");
            		String approtableau = rs.getString("appro");
            		
            		// A LA PLACE DE FAIRE UN PRINT METTRE DANS LE TABLEAU !
            		
            		System.out.println(idtableau + " " + nomtableau + " " + emailtableau + " " + agetableau + " " + classetableau + " " + approtableau);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}