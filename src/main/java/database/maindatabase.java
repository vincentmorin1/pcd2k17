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
	            System.out.println(e.getMessage());
	        }
	    }
	  
	    
	    public static void createNewTable() {
	        // SQLite connection string
	    	String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "/src/main/java/database/eleves2.db";
	        
	        // SQL statement for creating a new table
	        String sql = "CREATE TABLE IF NOT EXISTS eleves2 (\n"
	                + "	id integer PRIMARY KEY,\n"
	                + "	username text,\n"
	                + " prenom text,\n"
	                + "	nom text,\n"
	                + "	email text,\n"
	                + "	classe text,\n"
	                + "	appro text\n"
	                + ");";
	        
	        
	        try (Connection conn = DriverManager.getConnection(url);
	                Statement stmt = conn.createStatement()) {
	            // create a new table
	            stmt.execute(sql);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
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
	            System.out.println(e.getMessage());
	        }

	    }
	 
	    
	    public static void createNewTableProject(){
	    	String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "/src/main/java/database/eleves2.db";
	    	
	    	String sql2 = "CREATE TABLE IF NOT EXISTS projet (\n"
	        		+"id integer,\n"
	        		+"devoir text,\n"
	        		+"projet text\n"
	        		+");";
	    	
	    	try (Connection conn = DriverManager.getConnection(url);
	                Statement stmt = conn.createStatement()) {
	            // create a new table
	            stmt.execute(sql2);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }

	    }
	    
	    public static void createNewTableMatiere(){
	    	String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "/src/main/java/database/eleves2.db";
	    	
	    	String sql2 = "CREATE TABLE IF NOT EXISTS matiere (\n"
	        		+"id integer,\n"
	        		+"nom text\n"
	        		+");";
	    	
	    	try (Connection conn = DriverManager.getConnection(url);
	                Statement stmt = conn.createStatement()) {
	            // create a new table
	            stmt.execute(sql2);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }

	    }

	    public static void main(String[] args) {
	        /*createNewDatabase("eleves.db");
	        createNewTable();
	        Insert app = new Insert();
	        app.insert(1,"Loembe","Alex","alex-kevin.loembe@telecomnancy.eu",23,"3A","TRS");
	        app.insert(2,"Martin","Victoria","victoria.martin@telecomnancy.eu",22,"3A","SIE");
	        app.insert(3,"Pineau","Constance","constance.pineau@telecomnancy.eu",22,"3A","IAMD");
	        app.insert(4,"Frederic","Georges","frederic.georges@telecomnancy.eu",22,"3A","IAMD");
	        app.insert(5,"Eliot","Godard","eliot.godard@telecomnancy.eu",22,"3A","IL");
	        app.insert(6,"Cholley","Victor","victor.cholley@telecomnancy.eu",24,"3A","IL");
	        app.insert(7,"Vincent","Nahmias","vincent.nahmias@telecomnancy.eu",22,"3A","TRS");
	        app.insert(8,"Tom","Barat","@telecomnancy.eu",22,"3A","TRS");
	        app.insert(9,"Polizzi","Mathilde","mathilde.polizzi@telecomnancy.eu",22,"3A","SIE");
	        app.insert(10,"Louis-pol","Kelner","louis-pol.kelner@telecomnancy.eu",22,"3A","SIE");
	        app.insert(11,"Sofian","Chouder","sofian.chouder@telecomnancy.eu",23,"3A","SIE");
	        app.insert(12,"Victor","Schwien","Victor.schwien@telecomnancy.eu",20,"1A","null");*/
	}
}
