package eu.telecomnancy.pcd2k17;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
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
           System.out.println("Bizarre");
       }
   
	
	
	Stage stage = new Stage();
	new HomeView(stage);
  }  
  
  @FXML
  public void initialize() {
	  
  }
  

}
