package eu.telecomnancy.pcd2k17;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import javafx.application.Application;
import javafx.stage.Stage;




public class Main extends Application {

  final static Logger log = LogManager.getLogger(Main.class);

  public static void main(String args[]){
	
	//System.out.println(dev.getDevoirId("zaaf") + "/" + proj.getProjetId("zaaf", "gra"));
    log.debug("executing main() method.");
    launch(args);

  }

  @Override
  public void start(Stage primaryStage) throws Exception {
	  new ConnexionView(primaryStage);
  }


}