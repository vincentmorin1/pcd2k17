package eu.telecomnancy.pcd2k17;

import java.awt.TextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class MainController {

  final static Logger log = LogManager.getLogger(MainController.class);

  @FXML
  public void handleClickOk(ActionEvent event) {
    log.debug("ok button was clicked!");
  }
  
  @FXML
  TextField identifiant = new TextField();
  TextField mdp = new TextField();
  TextField connexion = new TextField();
  Text actiontarget = new Text();	
  
  public TextField getId() {
  	return this.identifiant;
  }
 
  public TextField getPwd() {
	  return this.mdp;
  }
  
  public void setId(TextField identifiant) {
	  this.identifiant = identifiant;
  }
  
  public void setPwd(TextField mdp) {
	  this.mdp = mdp;
  }
  
  @FXML
  public void ConnexionPressed (ActionEvent event) {
	  actiontarget.setText(identifiant.getText());
  }
  
  @FXML
  public void initialize() {
	  
  }
  

}
