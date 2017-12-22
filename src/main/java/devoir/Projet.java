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
	private ProjectApi proj;
	private Devoir devs;
	private UserApi user;
	
	public Projet(auth lab, Devoir dev) throws GitLabApiException{
		proj = lab.getProjectApi();
		user = lab.getUserApi();
		devs = dev;
	}

	//Création nouveau projet
	public void creerProjet(String name) {
		try {
			this.proj.createProject(name);
		} catch (GitLabApiException e) {
			// TODO Auto-generated catch block
			//System.out.println("Impossible de créer le projet "+name+".");
		}
	}
	
	public void creerProjet(String devoirName,String name) {
		try {
			this.proj.createProject(devs.getDevoirs().getDevoir(devoirName).getId(),name);
		} catch (GitLabApiException e) {
			// TODO Auto-generated catch block
			//System.out.println("Impossible de créer le projet "+name+".");
		}
	}
	
	public void creerProjetPrefixe(String devoirName,String name) {
		try {
			this.proj.createProject(devs.getDevoirs().getDevoir(devoirName).getId(),devoirName+name);
		} catch (GitLabApiException e) {
			// TODO Auto-generated catch block
			//System.out.println("Impossible de créer le projet "+name+".");
		}
	}
	
	public void supprProjet(String devName, String projName) throws GitLabApiException {
		proj.deleteProject(proj.getProject(devs.getDevoirs().getDevoir(devName).getFullPath(),projName));

	}
	
	public Integer getProjetId(String devName, String projName) throws GitLabApiException {
		return proj.getProject(devs.getDevoirs().getDevoir(devName).getFullPath(),projName).getId();
	}
	
	public void ajouterMembre(String devName, String projName, String username, String niveau) throws GitLabApiException {
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
		proj.addMember(proj.getProject(devs.getDevoirs().getDevoir(devName).getFullPath(),projName).getId(), user.getUser(username).getId(), var);
	}
	
	public void retirerMembre(String matName, String devName, String projName, String username) throws GitLabApiException {
		proj.removeMember(proj.getProject(devs.getDevoirs().getDevoir(devName).getFullPath(),projName).getId(),user.getUser(username).getId());
	}
	
}
