package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
	

	 
	    private Connection connect() {
	        // SQLite connection string
	    	String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "/src/main/java/database/eleves2.db";

	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url);
	        } catch (SQLException e) {
	            //System.out.println(e.getMessage());
	        }
	        return conn;
	    }
	 

	    public void update(int id, String nom, String email, int age,String classe, String appro) {
	        String sql = "UPDATE eleves SET nom = ? , "
	                + "email = ? ,"
	                + "age = ? ,"
	                + "classe = ? ,"
	                + "appro = ? ,"
	                + "WHERE id = ?";
	 
	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	 
	            // set the corresponding param
	            pstmt.setString(1, nom);
	            pstmt.setString(2, email);
	            pstmt.setInt(3, age);
	            pstmt.setString(4, classe);
	            pstmt.setString(5, appro);
	            // update 
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            //System.out.println(e.getMessage());
	        }
	    }
	}


