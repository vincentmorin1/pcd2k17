package devoir;

import java.util.List;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.ProjectApi;
import org.gitlab4j.api.UserApi;
import org.gitlab4j.api.models.AccessLevel;
import org.gitlab4j.api.models.Project;
import org.gitlab4j.api.models.User;

import Authentification.auth;

public class Projet {
	public ProjectApi proj;
	private Devoir devs;
	UserApi user;
	
	public Projet(auth lab) throws GitLabApiException{
		proj = lab.getProjectApi();
		user = lab.getUserApi();
		devs = new Devoir(lab);
		//devoirname = devs.getDevoirName(id))
		// TODO Auto-generated constructor stub
	}

	//Création nouveau projet
	public void creerProjet(String name) {
		try {
			this.proj.createProject(name);
		} catch (GitLabApiException e) {
			// TODO Auto-generated catch block
			System.out.println("Impossible de créer le projet "+name+".");
		}
	}
	
	public void creerProjet(String matName, String devoirName,String name) {
		try {
			this.proj.createProject(devs.getDevoirId(matName,devoirName),name);
		} catch (GitLabApiException e) {
			// TODO Auto-generated catch block
			System.out.println("Impossible de créer le projet "+name+".");
		}
	}
	
	public void creerProjetPrefixe(String matName, String devoirName,String name) {
		try {
			this.proj.createProject(devs.getDevoirId(matName, devoirName),devoirName+name);
		} catch (GitLabApiException e) {
			// TODO Auto-generated catch block
			System.out.println("Impossible de créer le projet "+devoirName+name+".");
		}
	}
	
	public void supprProjet(String matName, String devName, String projName) throws GitLabApiException {
		proj.deleteProject(proj.getProject(devs.getFullPath(matName,devName),projName));

	}
	
	public Integer getProjetId(String matName, String devName, String projName) throws GitLabApiException {
		return proj.getProject(devs.getFullPath(matName,devName),projName).getId();
	}
	
	public void ajouterMembre(String matName, String devName, String projName, String username, String niveau) throws GitLabApiException {
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
		proj.addMember(proj.getProject(devs.getFullPath(matName,devName),projName).getId(), user.getUser(username).getId(), var);
	}
	
	public void retirerMembre(String matName, String devName, String projName, String username) throws GitLabApiException {
		proj.removeMember(proj.getProject(devs.getFullPath(matName,devName),projName).getId(),user.getUser(username).getId());
	}
	/*public static void main(String args[]) throws GitLabApiException {
		auth lab = new auth();
		Projet proj = new Projet(lab);
		ProjectApi pro = lab.getProjectApi();
		UserApi user = lab.getUserApi();
		//proj.ajouterMembre("TOP","choco", "figue", "Victor.Schwien", "Master");
	}*/
	
}
