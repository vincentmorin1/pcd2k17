package eu.telecomnancy.pcd2k17;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gitlab4j.api.GitLabApiException;

import Authentification.auth;
import database.maindatabase;
import devoir.Devoir;
import devoir.Matiere;
import devoir.Room;
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
import javafx.scene.control.RadioButton;

public class NewPbModifDateController extends maindatabase{
	Devoir dev;
	Matiere mat;
	
  final static Logger log = LogManager.getLogger(NewPbModifDateController.class);
  
  ObservableList<String> list = FXCollections.observableArrayList("1A","2A","3A");
  ObservableList<String> matier = FXCollections.observableArrayList("TOP","POO","SD","CSHELL","RS","MOCI","AMIO","BDA","IA");

  @FXML
  private Button accueil = new Button();
  
  @FXML
  private SplitMenuButton devoir = new SplitMenuButton();
  
  @FXML
private MenuItem creation = new MenuItem();
  
  @FXML
  private MenuItem modifier = new MenuItem();
  
  @FXML
  private Button listesEleves = new Button();
  
  @FXML
  private Button deco = new Button();
  
  @FXML
  private Button quit = new Button();
  
  @FXML
  private Button modification = new Button();
  
  @FXML
  private ChoiceBox<String> matiere;
  
  @FXML
  private TextField titre = new TextField();
  
  @FXML 
  private TextField pre = new TextField();
  
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
  private RadioButton privee = new RadioButton();
  
  @FXML
  private RadioButton publique = new RadioButton();
  
  @FXML 
  private ChoiceBox<String> liste;
  
  private boolean alea;
  
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
	  Stage primaryStage = (Stage) modification.getScene().getWindow();
	  primaryStage.hide();
	  
	  Stage stage = new Stage();
	  new CreationView(stage);
	  
  }
  
  @FXML
  public void handleClickRandom(ActionEvent event) throws IOException {
	  if (aleatoire.isSelected()) {
		  alea = true;
	  }
	  else {
		  alea = false;
	  }
  }
  
  @FXML
  public void handleClickModifier(ActionEvent event) throws IOException {
	  Stage primaryStage = (Stage) modification.getScene().getWindow();
	  primaryStage.hide();
	  
	  Stage stage = new Stage();
	  new ModifView(stage);
  }
  
  @FXML
  public void handleClickListesEleves(ActionEvent event) throws IOException {
	  Stage primaryStage = (Stage) listesEleves.getScene().getWindow();
	  primaryStage.hide();
	  
	  Stage stage = new Stage();
	  new ListesElevesView(stage);
  }
  
  @FXML
  public void initialize() {
	  liste.setItems(list);
	  matiere.setItems(matier);
}
  
  @FXML
  public void handleClickModification(ActionEvent event) throws IOException{
	  Stage primaryStage = (Stage) modification.getScene().getWindow();
		primaryStage.close();
	  /*log.debug(liste.getValue());
	  log.debug(titre.getText());
	  log.debug(matiere.getValue());
	  log.debug(nb.getText());
	  log.debug(desc.getText());
	  log.debug(debut.getValue());
	  log.debug(fin.getValue());
	  log.debug(aleatoire.getText());
	  log.debug(privee.getText());
	  log.debug(publique.getText());
	  log.debug(pre.getText());*/
	  
	  if (debut.getValue() != null && fin.getValue() != null && titre.getText() != "" && matiere.getValue() != null) {
		  if (debut.getValue().compareTo(fin.getValue()) > 0) {
			  Stage stage = new Stage();
			new PbCreationDateView(stage);
		  }
		  else {
			  try {
				  auth lab = new auth();
				  Room room = new Room(lab);
				  mat = new Matiere(lab,room);
				  dev = new Devoir(lab,mat);
				  String devoir = titre.getText();
				  String nomMat = matiere.getValue();
				  try {
					  mat.creerMatiere(nomMat);
				  } catch (GitLabApiException e) { }
				  
				  if (!alea){
					  dev.creerDevoir(devoir, desc.getText(),nomMat,privee.isSelected(),debut.getValue(),fin.getValue(),liste.getValue());
				  } else {
				  		dev.creerDevoirAlea(devoir, desc.getText(), nomMat,privee.isSelected(),debut.getValue(),fin.getValue(),liste.getValue());
				  }
				  
				  Stage stage = new Stage();
				  new ModifView(stage);
			  } catch (GitLabApiException e) {
				  Stage stage = new Stage();
				  new PbCreationView(stage);
			  }
		  }
	  }
	  else {
		  	Stage stage = new Stage();
			new PbCreationView(stage);
			//
	  }
	  
  }
  
  @FXML
  public void handleClickOui(ActionEvent event) throws IOException {
	  pre.setVisible(true);
  }
  
  @FXML
  public void handleClickNon(ActionEvent event) throws IOException {
	  pre.setText(null);
	  pre.setVisible(false);
  }
  

}
