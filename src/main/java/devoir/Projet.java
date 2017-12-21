package devoir;

import java.util.List;

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
	UserApi useapi;
	
	public Projet(auth lab) throws GitLabApiException{
		proj = lab.getProjectApi();
		useapi = lab.getUserApi();
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
	
	public void creerProjet(String devoirName,String name) {
		try {
			this.proj.createProject(devs.getDevoirId(devoirName),name);
		} catch (GitLabApiException e) {
			// TODO Auto-generated catch block
			System.out.println("Impossible de créer le projet "+name+".");
		}
	}
	
	public void creerProjetPrefixe(String devoirName,String name) {
		try {
			this.proj.createProject(devs.getDevoirId(devoirName),devoirName+name);
		} catch (GitLabApiException e) {
			// TODO Auto-generated catch block
			System.out.println("Impossible de créer le projet "+devoirName+name+".");
		}
	}
	
public void testCo() throws GitLabApiException{
	List<Project> current;
	String name = "ahgdznbksvkxz";
	this.proj.createProject(name);
	current = proj.getProjects(name);
	proj.deleteProject(current.get(0));
}
	
	public void supprProjet(String name) {
		List<Project> current;
		try {
			current = proj.getProjects(name);
			if (current.isEmpty()) {
				System.out.println("Le projet "+name+" n'éxiste pas !");
			} else {
				proj.deleteProject(current.get(0));
			}
		} catch (GitLabApiException e1) {}
	}
	
	public Integer getProjetId(String devoirName, String name) throws GitLabApiException {
		return proj.getProject(devoirName,name).getId();
	}
	
	public void ajouterMembre(String devoirName,String projName) throws GitLabApiException {
		proj.addMember(proj.getProject(devoirName,projName).getId(), 336, AccessLevel.MASTER);
}
	public static void main(String args[]) throws GitLabApiException {
		Projet proj = new Projet(new auth());
		//proj.ajouterMembre("okapi", "juin");
	}
	
}
