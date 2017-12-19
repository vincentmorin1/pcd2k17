package eu.telecomnancy.pcd2k17;

import org.apache.logging.log4j.Logger;
import org.gitlab4j.api.GitLabApiException;
import org.apache.logging.log4j.LogManager;
import javafx.application.Application;
import javafx.stage.Stage;


import devoir.Devoir;

public class Main extends Application {

  final static Logger log = LogManager.getLogger(Main.class);

  public static void main(String args[]) throws GitLabApiException {
	//Devoir dev = new Devoir(); 
	//dev.creerDevoir("newProject");
    log.debug("executing main() method.");
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
	  new ConnexionView(primaryStage);
  }


}