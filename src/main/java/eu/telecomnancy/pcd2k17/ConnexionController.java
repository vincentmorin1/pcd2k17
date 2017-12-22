package eu.telecomnancy.pcd2k17;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gitlab4j.api.GitLabApiException;

import Authentification.auth;
import database.Insert;
import database.maindatabase;
import devoir.Devoir;
import devoir.Matiere;
import devoir.Projet;
import devoir.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ConnexionController extends maindatabase{
  final static Logger log = LogManager.getLogger(ConnexionController.class);

  @FXML
  private TextField token = new TextField();
  @FXML
  private Button connexion = new Button();
  
  
@FXML
  public void handleClickConnexion(ActionEvent event) throws IOException {
    log.debug(token.getText());
	Stage primaryStage = (Stage) connexion.getScene().getWindow();
	primaryStage.close();
	
       final String fichier = "token.txt";
       try {
           // creation d'un writer (un �crivain)
           final FileWriter writer = new FileWriter(fichier);
           try {
               writer.write(token.getText());
           } finally {
               // quoiqu'il arrive, on ferme le fichier
               writer.close();
           }
       } catch (Exception e) {
           System.out.println("Ca marche pas");
       }
       
       //test token
       		auth lab = new auth();
    	   		try { 
   	   		Room room = new Room(lab);
   	   		room.testCo();
   	   	try {
   			room.creerRoom("PCDpotes");
   		} catch (GitLabApiException e) {}
   	   	
   	 try {
			System.out.println("on est la");
			Insert app = new Insert();
			Insert app2 = new Insert();
			Matiere mat = new Matiere(lab,room);
			Devoir dev = new Devoir(lab,mat);
			Set<String> matList = mat.getMats().getListeMat();	
			Set<String> devlist = dev.getDevoirs().getListDev();
			createNewTableProject();
			createNewTabledev();
			createNewTableMatiere();
			Integer id_room = room.getRoom().getId();
				for(String s : matList){
						//appeler ce dont on a besoin
							//on recupere les matieres
							Integer id= mat.getMats().getMatiere(s).getId();
							app.insertmat(id, s);
							for(String z : devlist){
								Integer id_dev = dev.getDevoirs().getDevoir(z).getId();
								app2.insertdev(1, "a", "b", "c","d","e");
								app2.insertdev(id_dev, s, z, "null", "null", "null");
							}
						
						
			}
			
					/*System.out.println(listidmat);
					listnommat.add(group.getName());
					System.out.println(listnommat);
					for(Integer i : listidmat){
						Insert app2 = new Insert();
						System.out.println("i :"+i);
						app2.insertmat(i, listnommat.get(i));
						if (group.getId()==i){
							System.out.println("Condition2");
							String titre = group.getName();
							Integer id = group.getId();	
							Group matiere =groups.getGroup(group.getParentId());
							List<Project> pagerproject = groups.getProjects(60);				
							for (Project project : pagerproject){
								Integer idproject = project.getId();
								String name = project.getName();
								Owner owner = project.getOwner();
								Date datedeb = project.getCreatedAt();
								Insert app = new Insert();
								app.insertdev(id, matiere.toString(), titre, "unknown", "unknown", "unknown");//ajouter iddevoir
								app.insertproj(idproject,name, owner.toString(), datedeb.toString());
								
							}
						}
					}*/
				
			
			
		} catch (GitLabApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   		
   	   	
   	   		Stage stage = new Stage();
   	   		new HomeView(stage);
    	} catch(GitLabApiException e) {
   	   		Stage stage = new Stage();
   	   		new PbConnexionView(stage);
    	}
       
  
	
  }

@FXML
public void enterKeyPressed(KeyEvent e) throws IOException {
	if(e.getCode().equals(KeyCode.ENTER)) {
		handleClickConnexion(null);
	}
}
  
  @FXML
  public void initialize() {
	  
  }
  

}