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
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PbConnexionController{
  final static Logger log = LogManager.getLogger(PbConnexionController.class);

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
           // creation d'un writer (un écrivain)
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
       
       try { //test token
    	   		Projet test = new Projet(new auth());
    	   		test.creerProjet("xvfsfd45");
    	   		test.supprProjet("xvfsfd45");
    	   		Stage stage = new Stage();
    	   		new HomeView(stage);
       } catch(GitLabApiException e) {
    	   		Stage stage = new Stage();
    	   		new PbConnexionView(stage);
    	   		System.out.println("Pb de connexion");
       }
  }  
  
  @FXML
  public void initialize() {
	  
  }
  

}
