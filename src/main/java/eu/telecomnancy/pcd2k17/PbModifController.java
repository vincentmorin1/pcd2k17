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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableView;
import javafx.scene.control.MenuItem;
import javafx.fxml.Initializable;

public class PbModifController implements Initializable{
	
  final static Logger log = LogManager.getLogger(PbModifController.class);
  
  ObservableList<RecupDevoir> Listedevoir = FXCollections.observableArrayList();

  
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
  private String titretableau = null;
  
  @FXML
  private String matieretableau = null;
  
  @FXML
  private String debuttableau = null;
  
  @FXML
  private String fintableau = null;
  
  @FXML
  private String listetableau = null;
  
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
	  Stage primaryStage = (Stage) modif.getScene().getWindow();
	  primaryStage.hide();
	  
	  Stage stage = new Stage();
	  new PbModifView(stage);
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

  
  @Override
  public void initialize(URL location, ResourceBundle resources) {
  	String sql = "SELECT * FROM devoir";
      
      try (Connection conn = connect();
           Statement stmt  = conn.createStatement();
           ResultSet rs    = stmt.executeQuery(sql)){
          
          // loop through the result set
          while (rs.next()) {
          		titretableau = rs.getString("title");
          		matieretableau = rs.getString("matier");
          		debuttableau = rs.getString("start");
          		fintableau = rs.getString("end");
          		listetableau = rs.getString("listee");
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
