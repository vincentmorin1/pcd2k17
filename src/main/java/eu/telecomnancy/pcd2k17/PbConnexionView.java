package eu.telecomnancy.pcd2k17;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PbConnexionView {
	
	final static Logger log = LogManager.getLogger(Main.class);
	
	
	public PbConnexionView (Stage stage) throws IOException {
		stage = new Stage();
		
		stage.setTitle("Telecom Nancy SchoolRoom");
		
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(getClass().getResource("pbConnexion.fxml"));
		Parent root = loader.load();
		
		stage.setOnCloseRequest(event -> {
		 //log.debug("terminating application.");
		 Platform.exit();
		});
		stage.setScene(new Scene(root, 600, 400));
		stage.setResizable(false);
		stage.show();
	}

}
