package devoir;

import java.util.List;

import org.gitlab4j.api.*;
import org.gitlab4j.api.models.*;
import Authentification.auth;


public class Devoir{
	public GroupApi devs;
	private auth Auth;
	private List<Group> liste ;
	
	public Devoir() throws GitLabApiException{
		Auth = new auth();
		devs = new GroupApi(Auth.getAuth());
		liste = devs.getGroups();
		// TODO Auto-generated constructor stub
	}
	//création d'un nouveau devoir
	
	public void creerDevoir(String name, String desc){
		try {
			this.devs.addGroup(name, name);
			liste.add(devs.getGroup(name));
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
			liste = devs.getGroups();
		} catch (GitLabApiException e) {
			// TODO Auto-generated catch block
			System.out.println("Le devoir "+name+" n'existe pas !");
		}
		
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
}
