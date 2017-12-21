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
	public UserApi user;
	public Room room;
	
	public Matiere(auth lab) throws GitLabApiException{
		matiere = lab.getGroupApi();
		user = lab.getUserApi();
		room = new Room(lab);
	}
	//création d'un nouveau devoir
	
	public void creerMatiere(String name) throws GitLabApiException{
			this.matiere.addGroup(name, name, "", Boolean.FALSE, Boolean.TRUE,Visibility.PRIVATE,Boolean.FALSE,Boolean.FALSE,room.getRoomId(),0);
	}
	
	public void supprMatiere(String name) throws GitLabApiException {
		Group todel;
			todel = matiere.getGroup("PCDpotes/"+name);
			this.matiere.deleteGroup(todel);
			System.out.println("Le devoir "+name+" n'existe pas !");
	}
	
	public Integer getMatiereId(String name) throws GitLabApiException {
		return matiere.getGroup(room.getRoomName()+"/"+name).getId();
	}
	
	public String getFullPath(String matName) {
		return room.getRoomName()+"/"+matName;
	}
	
	public Group getMatiere(String name) throws GitLabApiException {
		return matiere.getGroup(room.getRoomName()+"/"+name);
	}
		
	public void ajouterMembre(String matName,String username, String niveau) throws GitLabApiException {
		AccessLevel var;
		switch(niveau) {
		case "Owner":
			var = AccessLevel.OWNER;
			break;
		case "Master":
			var = AccessLevel.MASTER;
			break;
		case "Developer":
			var = AccessLevel.DEVELOPER;
			break;
		case "Guest":
			var = AccessLevel.GUEST;
			break;
		default:
			var = AccessLevel.NONE;
		}
		matiere.addMember(matiere.getGroup(room.getRoomName()+"/"+matName).getId(), user.getUser(username).getId(), var);
	}
	
	public void retirerMembre(String matName, String username) throws GitLabApiException {
		matiere.removeMember(matiere.getGroup(room.getRoomName()+"/"+matName).getId(),user.getUser(username).getId());
	}
	
	/*public static void main(String args[]) throws GitLabApiException {
	Matiere mat= new Matiere(new auth());
	mat.ajouterMembre("MOCI","Victor.Schwien","Developer");

	}*/
	
	

}
