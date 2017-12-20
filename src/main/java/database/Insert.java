package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert{
	

	 

	 
	    private Connection connect() {
	        // SQLite connection string
	    	String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "/src/main/java/database/eleves2.db";
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return conn;
	    }
	 

	    public void insert(int id, String nom,String email,int age,String classe,String appro) {
	        String sql = "INSERT INTO eleves2(id,nom,email,age,classe,appro) VALUES(?,?,?,?,?,?)";
	      
	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            pstmt.setString(2, nom);
	            pstmt.setString(3, email);
	            pstmt.setInt(4, age);
	            pstmt.setString(5, classe);
	            pstmt.setString(6, appro);
	            pstmt.executeUpdate();
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	    
	    public void insertdev(String matiere,String titre,String datedeb,String datefin,String liste,int groupe){
	    	String sql2 = "INSERT INTO devoir(matiere,titre,datedeb,datefin,liste,groupe) VALUES(?,?,?,?,?,?)";
	    	
	    	try(Connection conn = this.connect();
	    			PreparedStatement pstmt = conn.prepareStatement(sql2)) {
	    		pstmt.setString(1,matiere);
	    		pstmt.setString(2,titre);
	    		pstmt.setString(3,datedeb);
	    		pstmt.setString(4,datefin);
	    		pstmt.setString(5,liste);
	    		pstmt.setInt(6,groupe);
	    		pstmt.executeUpdate();
	    	} catch (SQLException e) {
	    		System.out.println(e.getMessage());
	    	}
	    }
	}

