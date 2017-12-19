package eu.telecomnancy.pcd2k17;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.DatePicker;

public class CreationController{
	
  final static Logger log = LogManager.getLogger(CreationController.class);

  ObservableList<String> list = FXCollections.observableArrayList("1A","2A","3A");
  
  @FXML
  private TextField titre = new TextField();
  
  @FXML
  private TextField nb = new TextField();
  
  @FXML
  private TextArea desc = new TextArea();
  
  @FXML
  private DatePicker debut = new DatePicker();
  
  @FXML 
  private DatePicker fin= new DatePicker();
  
  @FXML 
  private ChoiceBox<String> liste;
  
  @FXML
  public void initialize() {
	  liste.setItems(list);
}
  
  @FXML
  public void handleClickCreer(ActionEvent event) throws IOException{
	  log.debug(liste.getValue());
	  log.debug(titre.getText());
	  log.debug(nb.getText());
	  log.debug(desc.getText());
	  log.debug(debut.getValue());
	  log.debug(fin.getValue());
  }
  

}
