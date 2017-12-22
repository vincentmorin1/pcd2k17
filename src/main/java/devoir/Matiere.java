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
	private GroupApi matiere;
	private UserApi user;
	private GroupRoom room;
	private GroupMatieres mats;
	
	public Matiere(auth lab, Room r) throws GitLabApiException{
		matiere = lab.getGroupApi();
		user = lab.getUserApi();
		room = r.getRoom();
		mats = new GroupMatieres();
		mats.updateMatiere(matiere, room, matiere.getGroups());
	}
	//création d'un nouveau devoir
	
	public void creerMatiere(String name) throws GitLabApiException{
			matiere.addGroup(name, name, "", Boolean.FALSE, Boolean.TRUE,Visibility.PUBLIC,Boolean.FALSE,Boolean.FALSE,room.getId(),0);
			mats.addMatiere(new GroupMatiere(matiere,room,name));
	}
	
	public void supprMatiere(String name) throws GitLabApiException {
			GroupMatiere todel = mats.getMatiere(name);
			this.matiere.deleteGroup(todel.getMatiere());
			mats.deleteMatiere(todel);
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
		matiere.addMember(mats.getMatiere(matName).getId(), user.getUser(username).getId(), var);
	}
	
	public void retirerMembre(String matName, String username) throws GitLabApiException {
		matiere.removeMember(mats.getMatiere(matName).getId(),user.getUser(username).getId());
	}
	
	public GroupMatieres getMats(){
		return mats;
	}
	
	/*public static void main(String args[]) throws GitLabApiException {
	Matiere mat= new Matiere(new auth());
	mat.ajouterMembre("MOCI","Victor.Schwien","Developer");

	}*/
	
	

}
