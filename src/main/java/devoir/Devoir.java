package devoir;

import org.gitlab4j.api.*;
import org.gitlab4j.api.models.*;
import Authentification.auth;


public class Devoir{
	public GroupApi devs;
	private auth Auth;
	
	public Devoir(){
		Auth = new auth();
		devs = new GroupApi(Auth.getAuth());
		// TODO Auto-generated constructor stub
	}
	//création d'un nouveau devoir
	
	public void creerDevoir(String name, String desc){
		try {
			this.devs.addGroup(name, name);
		} catch (GitLabApiException e) {
			// TODO Auto-generated catch block
			System.out.println("Impossible de créer le devoir "+name+ ".");
		}
	}
	
	public void supprDevoir(String name) {
		Group todel;
		try {
			todel = devs.getGroup(name);
			this.devs.deleteGroup(todel);
		} catch (GitLabApiException e) {
			// TODO Auto-generated catch block
			System.out.println("Le devoir "+name+" n'existe pas !");
		}
		
	}
	
	public void ajouterMembre(Integer groupId, Integer userId, Integer accessLevel) throws GitLabApiException {
		this.devs.addMember(groupId, userId, accessLevel);
	}
	
	public void supprMembre(Integer groupId, Integer userId) throws GitLabApiException {
		this.devs.removeMember(groupId, userId);
	}
	
}
