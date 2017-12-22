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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.fxml.Initializable;

public class ListesElevesController implements Initializable{
	
  final static Logger log = LogManager.getLogger(ListesElevesController.class);
  
  ObservableList<RecupEleve> Listeeleve = FXCollections.observableArrayList();
  
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
  private TableView<RecupEleve> tableview;
  @FXML
  private Button liste1A = new Button();
  
  @FXML
  private Button liste2A = new Button();
  
  @FXML
  private Button liste3A = new Button();
  
  @FXML
  private Button all = new Button();
  
  @FXML
  private ArrayList<String> tabid;
  
  @FXML
  private ArrayList<String> tabnom;
  
  @FXML
  private ArrayList<String> tabemail;
  
  @FXML
  private ArrayList<String> tabclasse;
 
  @FXML
  private ArrayList<String> tabappro;
  
  @FXML
  private String idtableau = null;
  
  @FXML
  private String classetableau = null;
  
  @FXML
  private String approtableau = null;
  
  @FXML
  private String nomtableau = null;
  
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

	public ArrayList<String> getTabid() {
		return tabid;
	}

	public void setTabid(ArrayList<String> tabid) {
		this.tabid = tabid;
	}

	public ArrayList<String> getTabnom() {
		return tabnom;
	}

	public void setTabnom(ArrayList<String> tabnom) {
		this.tabnom = tabnom;
	}

	public ArrayList<String> getTabemail() {
		return tabemail;
	}

	public void setTabemail(ArrayList<String> tabemail) {
		this.tabemail = tabemail;
	}

	public ArrayList<String> getTabclasse() {
		return tabclasse;
	}

	public void setTabclasse(ArrayList<String> tabclasse) {
		this.tabclasse = tabclasse;
	}

	public ArrayList<String> getTabappro() {
		return tabappro;
	}

	public void setTabappro(ArrayList<String> tabappro) {
		this.tabappro = tabappro;
	}

@Override
public void initialize(URL location, ResourceBundle resources) {
	String sql = "SELECT * FROM eleves2";
    
    try (Connection conn = connect();
         Statement stmt  = conn.createStatement();
         ResultSet rs    = stmt.executeQuery(sql)){
        
        // loop through the result set
        while (rs.next()) {
        		idtableau = rs.getString("id");
        		nomtableau = rs.getString("nom");
        		classetableau = rs.getString("classe");
        		approtableau = rs.getString("appro");
        		Listeeleve.add(new RecupEleve(idtableau,classetableau,nomtableau,approtableau)); 
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
	  tableview.getItems().addAll(Listeeleve);
	
}

}
