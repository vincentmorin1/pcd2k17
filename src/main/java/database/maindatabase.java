package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class maindatabase{
	
	 

	 
	    public static void createNewDatabase(String fileName) {
	 
	    	String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "/src/main/java/database/"+fileName;

	        
	    			try (Connection conn = DriverManager.getConnection(url)) {
	            if (conn != null) {
	                DatabaseMetaData meta = conn.getMetaData();
	            }
	 
	        } catch (SQLException e) {
	            //System.out.println(e.getMessage());
	        }
	    }
	  
	    
	    public static void createNewTable() {
	        // SQLite connection string
	    	String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "/src/main/java/database/eleves2.db";
	        
	        // SQL statement for creating a new table
	        String sql = "CREATE TABLE IF NOT EXISTS eleves2 (\n"
	                + "	id integer PRIMARY KEY,\n"
	                + "	prenom text ,\n"
	                + "	nom text ,\n"
	                + "	email text,\n"
	                + "	classe text,\n"
	                + "	appro text\n"
	                + ");";
	        

	        
	        try (Connection conn = DriverManager.getConnection(url);
	                Statement stmt = conn.createStatement()) {
	            // create a new table
	            stmt.execute(sql);
	        } catch (SQLException e) {
	            //System.out.println(e.getMessage());
	        }
	    }
	    
	    public static void createNewTabledev(){
	    	String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "/src/main/java/database/eleves2.db";
	    	
	    	String sql2 = "CREATE TABLE IF NOT EXISTS devoir (\n"
	        		+"matiere text,\n"
	        		+"titre text,\n"
	        		+"datedeb text(8),\n"
	        		+"datefin text(8),\n"
	        		+"liste text\n"
	        		+");";
	    	
	    	try (Connection conn = DriverManager.getConnection(url);
	                Statement stmt = conn.createStatement()) {
	            // create a new table
	            stmt.execute(sql2);
	        } catch (SQLException e) {
	            //System.out.println(e.getMessage());
	        }

	    }
	 

}
