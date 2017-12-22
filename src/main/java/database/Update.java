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
	 

	    public void update(Integer id,String username, String nom,String prenom, String email,String classe, String appro) {
	        String sql = "UPDATE eleves2 SET username = ? , "
	        		+"nom = ? ,"
	        		+"prenom = ? ,"
	        		+ "email = ? ,"
	                + "classe = ? ,"
	                + "appro = ? "
	                + "WHERE id = ?";
	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	 
	            // set the corresponding param
	            pstmt.setInt(7, id);
	            pstmt.setString(1,username);
		        pstmt.setString(2, nom);
	            pstmt.setString(3, prenom);
	            pstmt.setString(4, email);
	            pstmt.setString(5, classe);
	            pstmt.setString(6, appro);
	            // update 
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            //System.out.println(e.getMessage());
	        }
	    }     
	    
	    public void updatedev(Integer id,String matiere, String titre,String datedebut, String datefin,String liste) {
	        String sql = "UPDATE devoir SET matiere = ? , "
	        		+ "titre = ? ,"
	        		+ "datedebut = ? ,"
	                + "datefin = ? ,"
	                + "liste = ? "
	                + "WHERE id = ?";
	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	 
	            // set the corresponding param
	            
	            pstmt.setString(1,matiere);
		        pstmt.setString(2, titre);
	            pstmt.setString(3, datedebut);
	            pstmt.setString(4, datefin);
	            pstmt.setString(5, liste);
	            pstmt.setInt(6, id);
	            // update 
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            //System.out.println(e.getMessage());
	        }
	    }
	        
	        public static void main(String args[]){	     
        		Update app = new Update();
	        	app.updatedev(1402,"POO","Projet","21/03/2017","26/03/2017","1A");
	        }
	    
	}


