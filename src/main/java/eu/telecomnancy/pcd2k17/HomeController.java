package eu.telecomnancy.pcd2k17;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;

public class HomeController{
	
  final static Logger log = LogManager.getLogger(HomeController.class);

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
  public void handleClickDeco(ActionEvent event) throws IOException {
	  Stage primaryStage = (Stage) deco.getScene().getWindow();
	  primaryStage.hide();
	  
	  Stage stage = new Stage();
	  new ConnexionView(stage);
  }
  
  @FXML
  public void initialize() {
	  
}
  

}
