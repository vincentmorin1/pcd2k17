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
	        
	        public static void main(String args[]){	     
        		/*Update app = new Update();
	        	app.update(3,"festor","oliv","festor.oli@telecomnancy.eu","18A","TRS");
				*/
	        }
	    
	}


