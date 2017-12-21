package devoir;

import java.util.List;

import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.GroupApi;
import org.gitlab4j.api.UserApi;
import org.gitlab4j.api.models.AccessLevel;
import org.gitlab4j.api.models.Group;
import org.gitlab4j.api.models.User;
import org.gitlab4j.api.models.Visibility;

import Authentification.auth;

public class Matiere {
	public GroupApi matiere;
	public UserApi users;
	public Room room;
	private List<User> usersListe;
	
	public Matiere(auth lab) throws GitLabApiException{
		matiere = lab.getGroupApi();
		users = lab.getUserApi();
		usersListe = users.getUsers();
		room = new Room(lab);
	}
	//création d'un nouveau devoir
	
	public void creerMatiere(String name) throws GitLabApiException{
			this.matiere.addGroup(name, name, "", Boolean.FALSE, Boolean.TRUE,Visibility.PRIVATE,Boolean.FALSE,Boolean.FALSE,room.getRoomId("PCDpotes"),0);
	}
	
	public void supprMatiere(String name) throws GitLabApiException {
		Group todel;
			todel = matiere.getGroup("PCDpotes/"+name);
			this.matiere.deleteGroup(todel);
			System.out.println("Le devoir "+name+" n'existe pas !");
	}
	
	public Integer getMatiereId(String name) throws GitLabApiException {
		return matiere.getGroup("PCDpotes/"+name).getId();
	}
	
	public Group getMatiere(String name) throws GitLabApiException {
		return matiere.getGroup("PCDpotes/"+name);
	}
		
	public void ajouterMembre(String matiereName,String username) throws GitLabApiException {
			matiere.addMember(matiere.getGroup("PCDpotes/"+matiereName).getId(), 336, AccessLevel.OWNER);
	}
	
	
	

}
