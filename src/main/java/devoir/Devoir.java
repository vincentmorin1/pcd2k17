package devoir;

import java.util.List;

import org.gitlab4j.api.*;
import org.gitlab4j.api.models.*;
import Authentification.auth;
import database.Insert;
import database.maindatabase;


public class Devoir extends maindatabase{
	public GroupApi devs;
	public UserApi users;
	public Matiere mat;
	private List<Group> liste ;
	private List<User> usersListe;
	
	public Devoir(auth lab) throws GitLabApiException{
		devs = lab.getGroupApi();
		liste = devs.getGroups();
		users = lab.getUserApi();
		usersListe = users.getUsers();
		mat = new Matiere(lab);
		// TODO Auto-generated constructor stub
	}
	//création d'un nouveau devoir
	
	public void creerDevoir(String name, String desc, String nomMat,String debut,String fin,String liste) throws GitLabApiException{
			this.devs.addGroup(name, name, desc, Boolean.FALSE, Boolean.TRUE,Visibility.PRIVATE,Boolean.FALSE,Boolean.FALSE,mat.getMatiereId(nomMat),0);
			createNewTabledev();
			  Insert app = new Insert();
			  app.insertdev(nomMat, name,debut,fin,liste);
	}
	
	public void supprDevoir(String name) throws GitLabApiException {
		Group todel;
			todel = devs.getGroup(name);
			this.devs.deleteGroup(todel);
			liste = devs.getGroups();

	}
	
	public Integer getDevoirId(String name) throws GitLabApiException {
		return devs.getGroup(name).getId();
	}
	
	public Group getDevoir(String name) throws GitLabApiException {
		return devs.getGroup(name);
	}
	
	public List<Group> getListe(){
		return liste;
	}
	
	public void ajouterMembre(String devoir,String nom,String prenom) throws GitLabApiException {

			Integer userId = users.getUser(prenom+"."+nom+"@telecomnancy.eu").getId();
			Integer accessLevel = 0;
			devs.addMember(devs.getGroup(devoir).getId(), userId, accessLevel);
	}
}
