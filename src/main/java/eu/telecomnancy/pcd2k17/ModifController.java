package eu.telecomnancy.pcd2k17;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

public class ModifController{
	
  final static Logger log = LogManager.getLogger(ModifController.class);
  
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
  private DatePicker fin = new DatePicker();
  
  @FXML
  private ToggleButton aleatoire = new ToggleButton();
  
  @FXML
  private Button modif = new Button();
  
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
	  Stage primaryStage = (Stage) quit.getScene().getWindow();
	  primaryStage.hide();
  }
  
  @FXML
  public void handleClickDeco(ActionEvent event) throws IOException {
	  Stage primaryStage = (Stage) deco.getScene().getWindow();
	  primaryStage.hide();
	  
	  Stage stage = new Stage();
	  new ConnexionView(stage);
  }
  
  @FXML
  public void handleClickCreation(ActionEvent event) throws IOException {
	  Stage primaryStage = (Stage) devoir.getScene().getWindow();
	  primaryStage.hide();
	  
	  Stage stage = new Stage();
	  new CreationView(stage);
  }
  
  @FXML
  public void handleClickModifier(ActionEvent event) throws IOException {
	  Stage primaryStage = (Stage) devoir.getScene().getWindow();
	  primaryStage.hide();
	  
	  Stage stage = new Stage();
	  new ModifView(stage);
  }
  
  @FXML
  public void handleClickModif(ActionEvent event) throws IOException {
	  Stage primaryStage = (Stage) modif.getScene().getWindow();
	  primaryStage.hide();
	  
	  Stage stage = new Stage();
	  new ModifView(stage);
  }
  
  @FXML
  public void initialize() {
	  
}
  

}
