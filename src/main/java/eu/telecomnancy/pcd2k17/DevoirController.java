package eu.telecomnancy.pcd2k17;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gitlab4j.api.GitLabApiException;

import Authentification.auth;
import devoir.Devoir;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DevoirController{
	Devoir dev;
	
  final static Logger log = LogManager.getLogger(DevoirController.class);
  
  ObservableList<String> list = FXCollections.observableArrayList("1A","2A","3A");

  @FXML
  private Button accueil = new Button();
  
  @FXML
  private Button devoir = new Button();
  
  @FXML
  private Button deco = new Button();
  
  @FXML
  private Button quit = new Button();
  
  @FXML
  private Button creer = new Button();
  
  @FXML
  private TextField matiere = new TextField();
  
  @FXML
  private TextField titre = new TextField();
  
  @FXML
  private TextField nb = new TextField();
  
  @FXML
  private TextArea desc = new TextArea();
  
  @FXML
  private DatePicker debut = new DatePicker();
  
  @FXML 
  private DatePicker fin= new DatePicker();
  
  @FXML 
  private ChoiceBox<String> liste;
  
  @FXML
  public void handleClickAccueil(ActionEvent event) throws IOException{
	  Stage primaryStage = (Stage) accueil.getScene().getWindow();
		primaryStage.close();
		
		Stage stage = new Stage();
		new HomeView(stage);
  }
  
  @FXML
  public void handleClickQuit(ActionEvent event) throws IOException {
	  Stage primaryStage = (Stage) accueil.getScene().getWindow();
	  primaryStage.hide();
  }
  
  @FXML
  public void handleClickDevoir(ActionEvent event) throws IOException{
	  Stage primaryStage = (Stage) accueil.getScene().getWindow();
	  primaryStage.close();
	  
	  Stage stage = new Stage();
	  new DevoirView(stage);
  }
  
  @FXML
  public void handleClickDeco(ActionEvent event) throws IOException {
	  Stage primaryStage = (Stage) accueil.getScene().getWindow();
	  primaryStage.hide();
	  
	  Stage stage = new Stage();
	  new ConnexionView(stage);
  }
  
  @FXML
  public void initialize() {
	  liste.setItems(list);
}
  
  @FXML
  public void handleClickCreer(ActionEvent event) throws IOException{
	  log.debug(liste.getValue());
	  log.debug(titre.getText());
	  log.debug(matiere.getText());
	  log.debug(nb.getText());
	  log.debug(desc.getText());
	  log.debug(debut.getValue());
	  log.debug(fin.getValue());
	  try {
		dev = new Devoir(new auth());
		String devoir = titre.getText();
		dev.creerDevoir(devoir, desc.getText());
		//dev.ajouterMembre(devoir, "Schwien", "Victor");
	} catch (GitLabApiException e) {
		// TODO Auto-generated catch block
		System.out.println("Impossible de créer le devoir");
	}
  }
  

}
