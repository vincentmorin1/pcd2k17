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
	 

	    public void update(Integer id, String nom,String prenom, String email,String classe, String appro) {
	        String sql = "UPDATE eleves2 SET nom = ? , "
	                +"prenom = ? ,"
	        		+ "email = ? ,"
	                + "classe = ? ,"
	                + "appro = ? "
	                + "WHERE id = ?";
	        
	        System.out.println("bite");
	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {

		        System.out.println("bite12");
	 
	            // set the corresponding param
	            pstmt.setInt(6, id);
		        pstmt.setString(1, nom);
	            pstmt.setString(2, prenom);
	            pstmt.setString(3, email);
	            pstmt.setString(4, classe);
	            pstmt.setString(5, appro);
	            // update 
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            //System.out.println(e.getMessage());
	        }
	    }      
	        
	        public static void main(String args[]){	     
        		/*Update app = new Update();
	        	app.update(3,"festor","oliv","festor.oli@telecomnancy.eu","18A","TRS");
				*/
	        }
	    
	}


