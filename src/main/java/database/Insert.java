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
	            //System.out.println(e.getMessage());
	        }
	        return conn;
	    }
	 

	    public void insert(int id,String username,String prenom, String nom,String email,String classe,String appro) {
	        String sql = "INSERT INTO eleves2(id,username,prenom,nom,email,classe,appro) VALUES(?,?,?,?,?,?,?)";
	      
	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            pstmt.setString(2, username);
	            pstmt.setString(3, prenom);
	            pstmt.setString(4, nom);
	            pstmt.setString(5, email);
	            pstmt.setString(6, classe);
	            pstmt.setString(7, appro);
	            pstmt.executeUpdate();
	            
	        } catch (SQLException e) {
	            //System.out.println(e.getMessage());
	        }
	    }
	    
	    public void insertdev(int id, String matiere,String titre,String datedeb,String datefin,String liste){
	    	String sql2 = "INSERT INTO devoir(id,matiere,titre,datedeb,datefin,liste) VALUES(?,?,?,?,?,?)";
	    	
	    	try(Connection conn = this.connect();
	    			PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {
	    		pstmt2.setInt(1, id);
	    		pstmt2.setString(2,matiere);
	    		pstmt2.setString(3,titre);
	    		pstmt2.setString(4,datedeb);
	    		pstmt2.setString(5,datefin);
	    		pstmt2.setString(6,liste);
	    		pstmt2.executeUpdate();
	    	} catch (SQLException e) {
	    		
	    		//System.out.println(e.getMessage());
	    	}
	    }
	    
	    public void insertproj(int id,String nomproj,String devoir, String owner,String datedeb){
	    	String sql2 = "INSERT INTO project(id,nomproj,devoir,owner,datedeb) VALUES(?,?,?,?,?)";
	    	
	    	try(Connection conn = this.connect();
	    			PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {
	    		pstmt2.setInt(1,id);
	    		pstmt2.setString(2,nomproj);
	    		pstmt2.setString(3,devoir);
	    		pstmt2.setString(4,owner);
	    		pstmt2.setString(5,datedeb);
	    		pstmt2.executeUpdate();
	    	} catch (SQLException e) {
	    		//System.out.println(e.getMessage());
	    	}
	    }
	    
	    public void insertmat(int id,String nom){
	    	String sql2 = "INSERT INTO matiere(id,nom) VALUES(?,?)";
	    	
	    	try(Connection conn = this.connect();
	    			PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {
	    		pstmt2.setInt(1,id);
	    		pstmt2.setString(2,nom);
	    		pstmt2.executeUpdate();
	    	} catch (SQLException e) {
	    		//System.out.println(e.getMessage());
	    	}
	    }
	    
	}

