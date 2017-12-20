package eu.telecomnancy.pcd2k17;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gitlab4j.api.GitLabApiException;

import Authentification.auth;
import database.Insert;
import database.maindatabase;
import devoir.Devoir;
import devoir.Matiere;
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
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;

public class CreationController extends maindatabase{
	Devoir dev;
	Matiere mat;
	
  final static Logger log = LogManager.getLogger(CreationController.class);
  
  ObservableList<String> list = FXCollections.observableArrayList("1A","2A","3A");
  ObservableList<String> group = FXCollections.observableArrayList("1","2","3","4","5");

  @FXML
  private Button accueil = new Button();
  
  @FXML
  private SplitMenuButton devoir = new SplitMenuButton();
  
  @FXML
private MenuItem creation = new MenuItem();
  
  @FXML
  private MenuItem modifier = new MenuItem();
  
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
  private ToggleButton aleatoire = new ToggleButton();
  
  @FXML 
  private ChoiceBox<String> liste;
  
  @FXML
  private ChoiceBox<String> groupe;
  
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
  public void handleClickDeco(ActionEvent event) throws IOException {
	  Stage primaryStage = (Stage) accueil.getScene().getWindow();
	  primaryStage.hide();
	  
	  Stage stage = new Stage();
	  new ConnexionView(stage);
  }
  
  @FXML
  public void handleClickCreation(ActionEvent event) throws IOException {
	  Stage primaryStage = (Stage) creer.getScene().getWindow();
	  primaryStage.hide();
	  
	  Stage stage = new Stage();
	  new CreationView(stage);
	  
  }
  
  @FXML
  public void handleClickModifier(ActionEvent event) throws IOException {
	  Stage primaryStage = (Stage) creer.getScene().getWindow();
	  primaryStage.hide();
	  
	  Stage stage = new Stage();
	  new ModifView(stage);
  }
  
  @FXML
  public void initialize() {
	  liste.setItems(list);
	  groupe.setItems(group);
}
  
  @FXML
  public void handleClickCreer(ActionEvent event) throws IOException{
	  Stage primaryStage = (Stage) creer.getScene().getWindow();
		primaryStage.close();
	  log.debug(liste.getValue());
	  log.debug(groupe.getValue());
	  log.debug(titre.getText());
	  log.debug(matiere.getText());
	  log.debug(nb.getText());
	  log.debug(desc.getText());
	  log.debug(debut.getValue());
	  log.debug(fin.getValue());
	  log.debug(aleatoire.getText());
	  try {
		dev = new Devoir(new auth());
		mat = new Matiere(new auth());
		String devoir = titre.getText();
		String nomMat = matiere.getText();
		try {
			mat.getMatiere(nomMat);
		} catch (GitLabApiException e) {
			mat.creerMatiere(nomMat);
		}
		LocalDate date1 = debut.getValue();
		LocalDate date2 = fin.getValue();
		
		dev.creerDevoir(devoir, desc.getText(),nomMat,Date.valueOf(date1.toString()),Date.valueOf(date2.toString()),liste.getValue());
		//dev.ajouterMembre(devoir, "Schwien", "Victor");
		Stage stage = new Stage();
		  new ModifView(stage);
	} catch (GitLabApiException e) {
		Stage stage = new Stage();
		new PbCreationView(stage);
	}
	  
	  
  }
  

}
