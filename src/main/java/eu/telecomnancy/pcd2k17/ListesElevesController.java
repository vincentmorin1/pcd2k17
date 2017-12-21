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
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

import eleve.Eleves;

public class ListesElevesController{
	
  final static Logger log = LogManager.getLogger(ListesElevesController.class);
  
  ObservableList<Integer> ideleve = FXCollections.observableArrayList();
  ObservableList<String> prom = FXCollections.observableArrayList();
  ObservableList<String> preno = FXCollections.observableArrayList();
  ObservableList<String> name = FXCollections.observableArrayList();
  ObservableList<String> grp = FXCollections.observableArrayList();
  

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
  private TreeTableView<Eleves> tableview = new TreeTableView<Eleves>();
  
  @FXML
  private TreeTableColumn<Eleves,String> idEleve = new TreeTableColumn<Eleves,String>();
  
  @FXML
  private TreeTableColumn<Eleves,String> promo = new TreeTableColumn<Eleves,String>();
  
  @FXML
  private TreeTableColumn<Eleves,String> prenom = new TreeTableColumn<Eleves,String>();
  
  @FXML
  private TreeTableColumn<Eleves,String> nom = new TreeTableColumn<Eleves,String>();
  
  @FXML
  private TreeTableColumn<Eleves,String> groupe = new TreeTableColumn<Eleves,String>();
  
  @FXML
  private Button liste1A = new Button();
  
  @FXML
  private Button liste2A = new Button();
  
  @FXML
  private Button liste3A = new Button();
  
  @FXML
  private Button all = new Button();
  
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
  public void handleClickListesEleves(ActionEvent event) throws IOException {
	  Stage primaryStage = (Stage) liste1A.getScene().getWindow();
	  primaryStage.hide();
	  
	  Stage stage = new Stage();
	  new ListesElevesView(stage);
  }
  
  @FXML
  public void handleClickListe1A(ActionEvent event) throws IOException {
	  Stage primaryStage = (Stage) liste1A.getScene().getWindow();
	  primaryStage.hide();
	  
	  Stage stage = new Stage();
	  new ListesElevesView(stage);
  }
  
  @FXML
  public void handleClickListe2A(ActionEvent event) throws IOException {
	  Stage primaryStage = (Stage) liste2A.getScene().getWindow();
	  primaryStage.hide();
	  
	  Stage stage = new Stage();
	  new ListesElevesView(stage);
  }
  
  @FXML
  public void handleClickListe3A(ActionEvent event) throws IOException {
	  Stage primaryStage = (Stage) liste3A.getScene().getWindow();
	  primaryStage.hide();
	  
	  Stage stage = new Stage();
	  new ListesElevesView(stage);
  }
  
  @FXML
  public void handleClickAll(ActionEvent event) throws IOException {
	  Stage primaryStage = (Stage) all.getScene().getWindow();
	  primaryStage.hide();
	  
	  Stage stage = new Stage();
	  new ListesElevesView(stage);
  }
  
  @FXML
  public void initialize() {
	  //idEleve.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getidString()));
}
  

}
