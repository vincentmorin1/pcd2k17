package eu.telecomnancy.pcd2k17;

import org.apache.logging.log4j.Logger;
import org.gitlab4j.api.GitLabApiException;
import org.apache.logging.log4j.LogManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import devoir.Devoir;

public class Main extends Application {

  final static Logger log = LogManager.getLogger(Main.class);

  public static void main(String args[]) throws GitLabApiException {
	Devoir dev = new Devoir(); 
    log.debug("executing main() method.");
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("JFX Sample Application");

    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("main.fxml"));
    Parent root = loader.load();

    primaryStage.setOnCloseRequest(event -> {
      log.debug("terminating application.");
      Platform.exit();
    });
    primaryStage.setScene(new Scene(root, 600, 400));
    primaryStage.setResizable(false);
    primaryStage.show();
  }

}