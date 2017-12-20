package devoir;

import java.util.List;

import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.GroupApi;
import org.gitlab4j.api.UserApi;
import org.gitlab4j.api.models.Group;
import org.gitlab4j.api.models.User;
import org.gitlab4j.api.models.Visibility;

import Authentification.auth;

public class Matiere {
	public GroupApi matiere;
	public UserApi users;
	private List<Group> liste ;
	private List<User> usersListe;
	
	public Matiere(auth lab) throws GitLabApiException{
		matiere = lab.getGroupApi();
		liste = matiere.getGroups();
		users = lab.getUserApi();
		usersListe = users.getUsers();
		// TODO Auto-generated constructor stub
	}
	//création d'un nouveau devoir
	
	public void creerMatiere(String name) throws GitLabApiException{
			this.matiere.addGroup(name, name);
			liste.add(matiere.getGroup(name));
	}
	
	public void supprMatiere(String name) throws GitLabApiException {
		Group todel;
			todel = matiere.getGroup(name);
			this.matiere.deleteGroup(todel);
			liste = matiere.getGroups();
			// TODO Auto-generated catch block
			System.out.println("Le devoir "+name+" n'existe pas !");
		
	}
	
	public Integer getMatiereId(String name) throws GitLabApiException {
		return matiere.getGroup(name).getId();
	}
	
	public Group getMatiere(String name) throws GitLabApiException {
		return matiere.getGroup(name);
	}
	
	public List<Group> getListe(){
		return liste;
	}
	
	public void ajouterMembre(String matiereName,String nom,String prenom) throws GitLabApiException {
			Integer userId = users.getUser(prenom+"."+nom+"@telecomnancy.eu").getId();
			Integer accessLevel = 0;
			matiere.addMember(matiere.getGroup(matiereName).getId(), userId, accessLevel);	
	}
}
