package eu.telecomnancy.pcd2k17;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ConnexionController{
	
  final static Logger log = LogManager.getLogger(ConnexionController.class);

  @FXML
  private TextField token = new TextField();
  @FXML
  private Button connexion = new Button();
  
  

  @FXML
  public void handleClickConnexion(ActionEvent event) throws IOException {
    log.debug(token.getText());
	Stage primaryStage = (Stage) connexion.getScene().getWindow();
	primaryStage.close();
	
	Stage stage = new Stage();
	new creationDevoirView(stage);
  }  
  
  @FXML
  public void initialize() {
	  
  }
  

}
