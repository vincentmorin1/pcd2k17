package eu.telecomnancy.pcd2k17;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CreationView {
	
	final static Logger log = LogManager.getLogger(Main.class);
	
	
	public CreationView (Stage stage) throws IOException {
		stage = new Stage();
		
		stage.setTitle("Telecom Nancy SchoolRoom");
		
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(getClass().getResource("creation.fxml"));
		Parent root = loader.load();
		
		stage.setOnCloseRequest(event -> {
		 log.debug("terminating application.");
		 Platform.exit();
		});
		stage.setScene(new Scene(root, 1100, 1000));
		stage.setResizable(false);
		stage.show();
	}

}
