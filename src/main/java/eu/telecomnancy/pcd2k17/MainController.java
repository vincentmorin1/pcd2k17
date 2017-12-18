package eu.telecomnancy.pcd2k17;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class MainController{

  final static Logger log = LogManager.getLogger(MainController.class);


  @FXML
  TextField identifiant = new TextField();
  @FXML
  TextField mdp = new TextField();
  @FXML
  Button connexion = new Button();
  
  

  @FXML
  public void handleClickOk(ActionEvent event) {
    log.debug(identifiant.getText());
	log.debug(mdp.getText());
  }
  
  @FXML
  public void initialize() {
	  
  }
  

}
