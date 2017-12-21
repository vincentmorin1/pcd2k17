package eu.telecomnancy.pcd2k17;

import java.io.FileWriter;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gitlab4j.api.GitLabApiException;

import Authentification.auth;
import devoir.Projet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
	
       final String fichier = "token.txt";
       try {
           // creation d'un writer (un �crivain)
           final FileWriter writer = new FileWriter(fichier);
           try {
               writer.write(token.getText());
           } finally {
               // quoiqu'il arrive, on ferme le fichier
               writer.close();
           }
       } catch (Exception e) {
           System.out.println("Ca marche pas");
       }
       
       //test token
       
    	   		try { 
   	   		Projet test = new Projet(new auth());
   	   		test.testCo();
   	   		Stage stage = new Stage();
   	   		new HomeView(stage);
    	   		} catch(GitLabApiException e) {
   	   		Stage stage = new Stage();
   	   		new PbConnexionView(stage);
    	   		}
       
  
	
  }  

@FXML
public void enterKeyPressed(KeyEvent e) throws IOException {
	if (e.getCode().equals(KeyCode.ENTER)) {
		handleClickConnexion(null);
	}
	
}
  
  
  @FXML
  public void initialize() {
	  
  }
  

}