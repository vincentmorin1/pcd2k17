package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

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
	 

	    public void insert(int id,String prenom, String nom,String email,String classe,String appro) {
	        String sql = "INSERT INTO eleves2(id,prenom,nom,email,classe,appro) VALUES(?,?,?,?,?,?)";
	      
	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            pstmt.setString(2, prenom);
	            pstmt.setString(3, nom);
	            pstmt.setString(3, email);
	            pstmt.setString(5, classe);
	            pstmt.setString(6, appro);
	            pstmt.executeUpdate();
	            
	        } catch (SQLException e) {
	            //System.out.println(e.getMessage());
	        }
	    }
	    
	    public void insertdev(String matiere,String titre,String datedeb,String datefin,String liste){
	    	String sql2 = "INSERT INTO devoir(matiere,titre,datedeb,datefin,liste) VALUES(?,?,?,?,?)";
	    	
	    	try(Connection conn = this.connect();
	    			PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {
	    		pstmt2.setString(1,matiere);
	    		pstmt2.setString(2,titre);
	    		pstmt2.setString(3,datedeb);
	    		pstmt2.setString(4,datefin);
	    		pstmt2.setString(5,liste);
	    		pstmt2.executeUpdate();
	    	} catch (SQLException e) {
	    		//System.out.println(e.getMessage());
	    	}
	    }
	}

