package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
	

	 

	 
	    private Connection connect() {
	        // SQLite connection string
	    	String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "/src/main/java/database/eleves.db";
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return conn;
	    }
	 

	    public void insert(int id, String nom,String prenom,String email,int age,String classe,String appro) {
	        String sql = "INSERT INTO eleves(id,nom,prenom,email,age,classe,appro) VALUES(?,?,?,?,?,?,?)";
	 
	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            pstmt.setString(2, nom);
	            pstmt.setString(3, prenom);
	            pstmt.setString(4, email);
	            pstmt.setInt(5, age);
	            pstmt.setString(6, classe);
	            pstmt.setString(7, appro);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	}
	

