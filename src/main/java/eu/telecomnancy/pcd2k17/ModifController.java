package eu.telecomnancy.pcd2k17;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gitlab4j.api.GitLabApiException;

import Authentification.auth;
import devoir.Devoir;
import devoir.Matiere;
import devoir.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuItem;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class ModifController implements Initializable{
	
  final static Logger log = LogManager.getLogger(ModifController.class);
  
  ObservableList<RecupDevoir> Listedevoir = FXCollections.observableArrayList();

  
  Devoir dev;
	Matiere mat;
  @FXML
  private TableView<RecupDevoir> table;
  
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
  private TextField titre = new TextField();
  
  @FXML
  private Button modif = new Button();
  
  @FXML
  private ArrayList<String> title;
  
  @FXML
  private ArrayList<String> matier;
  
  @FXML
  private ArrayList<String> start;
  
  @FXML
  private ArrayList<String> end;
 
  @FXML
  private ArrayList<String> listee;
  
  @FXML
  private ChoiceBox<String> matiere;
  
  @FXML
  public static String titretableau;
  
  @FXML
  public static String matieretableau;
  
  @FXML
  public static String debuttableau;
  
  @FXML
  public static String fintableau;
  
  @FXML
  public static String listetableau;
  
  
  public static void ModifControl (String titretableau, String matieretableau, String debuttableau, String fintableau, String listetableau) {
	  ModifController.titretableau = titretableau;
	  ModifController.matieretableau = matieretableau;
	  ModifController.debuttableau = debuttableau;
	  ModifController.fintableau = fintableau;
	  ModifController.listetableau = listetableau;
  }
  
  @FXML
  public void handleClickAccueil(ActionEvent event) throws IOException{
	  Stage primaryStage = (Stage) accueil.getScene().getWindow();
		primaryStage.close();
		
		Stage stage = new Stage();
		new HomeView(stage);
  }
  
  @FXML
  public void handleClickListesEleves(ActionEvent event) throws IOException{
	  Stage primaryStage = (Stage) modif.getScene().getWindow();
		primaryStage.close();
		
		Stage stage = new Stage();
		new ListesElevesView(stage);
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
	  
	  RecupDevoir e = table.getSelectionModel().getSelectedItem();
	  
	  titretableau = e.getTabTitle();
	  matieretableau = e.getTabMatier();
	  debuttableau = e.getTabStart();
	  fintableau = e.getTabEnd();
	  listetableau = e.getTabListee();
	  
	  
	  
	  
	  Stage primaryStage = (Stage) modif.getScene().getWindow();
	  primaryStage.hide();
	  
	  Stage stage = new Stage();
	  new NewModifView(stage);
  }
  
  private Connection connect() {
      // SQLite connection string
      String url = "jdbc:sqlite:src/main/java/database/eleves2.db";
      Connection conn = null;
      try {
          conn = DriverManager.getConnection(url);
          System.out.println("Connecté");
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
      return conn;
  }
  
  @FXML
  public void handleClickSupprimer(ActionEvent event) throws IOException {
	  auth lab = new auth();
	  Room room;
	try {
		room = new Room(lab);
		  
		  dev.supprDevoir(table.getSelectionModel().getSelectedItem().getTabTitle());
		  
		  Stage stage = new Stage();
		  new ModifView(stage);
	} catch (GitLabApiException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  
  @Override
  public void initialize(URL location, ResourceBundle resources) {
  	String sql = "SELECT * FROM devoir";
      
      try (Connection conn = connect();
           Statement stmt  = conn.createStatement();
           ResultSet rs    = stmt.executeQuery(sql)){
          
          // loop through the result set
          while (rs.next()) {
          		titretableau = rs.getString("titre");
          		matieretableau = rs.getString("matiere");
          		debuttableau = rs.getString("datedeb");
          		fintableau = rs.getString("datefin");
          		listetableau = rs.getString("liste");
          		Listedevoir.add(new RecupDevoir(titretableau,matieretableau,debuttableau,fintableau,listetableau)); 
          }
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
      
  	  table.getItems().addAll(Listedevoir);
  	
  }

public ArrayList<String> getTitle() {
	return title;
}

public void setTitle(ArrayList<String> title) {
	this.title = title;
}

public ArrayList<String> getMatier() {
	return matier;
}

public void setMatier(ArrayList<String> matier) {
	this.matier = matier;
}

public ArrayList<String> getStart() {
	return start;
}

public void setStart(ArrayList<String> start) {
	this.start = start;
}

public ArrayList<String> getEnd() {
	return end;
}

public void setEnd(ArrayList<String> end) {
	this.end = end;
}

public ArrayList<String> getListee() {
	return listee;
}

public void setListee(ArrayList<String> listee) {
	this.listee = listee;
}
 

}
