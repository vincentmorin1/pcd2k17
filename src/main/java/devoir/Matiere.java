package devoir;

import java.util.List;

import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.GroupApi;
import org.gitlab4j.api.UserApi;
import org.gitlab4j.api.models.Group;
import org.gitlab4j.api.models.User;


import Authentification.auth;

public class Matiere {
	public GroupApi matiere;
	public UserApi users;
	private List<User> usersListe;
	
	public Matiere(auth lab) throws GitLabApiException{
		matiere = lab.getGroupApi();
		users = lab.getUserApi();
		usersListe = users.getUsers();
	}
	//création d'un nouveau devoir
	
	public void creerMatiere(String name) throws GitLabApiException{
			this.matiere.addGroup(name, name);
	}
	
	public void supprMatiere(String name) throws GitLabApiException {
		Group todel;
			todel = matiere.getGroup(name);
			this.matiere.deleteGroup(todel);
			System.out.println("Le devoir "+name+" n'existe pas !");
	}
	
	public Integer getMatiereId(String name) throws GitLabApiException {
		return matiere.getGroup(name).getId();
	}
	
	public Group getMatiere(String name) throws GitLabApiException {
		return matiere.getGroup(name);
	}
		
	public void ajouterMembre(String matiereName,String username) throws GitLabApiException {
			
	}
	

}
