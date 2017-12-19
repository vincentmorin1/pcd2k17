package eu.telecomnancy.pcd2k17;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController{

  final static Logger log = LogManager.getLogger(MainController.class);


  @FXML
  TextField identifiant = new TextField();
  @FXML
  TextField mdp = new TextField();
  @FXML
  Button connexion = new Button();
  
  

  @FXML
  public void handleClickConnexion(ActionEvent event) throws IOException {
    log.debug(identifiant.getText());
	log.debug(mdp.getText());
	Stage primaryStage = (Stage) connexion.getScene().getWindow();
	primaryStage.close();
	
	Stage stage = new Stage();
	new creationDevoirView(stage);
  }
  
  
  
  @FXML
  public void initialize() {
	  
  }
  

}
