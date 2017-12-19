package devoir;

import java.util.List;

import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.ProjectApi;
import org.gitlab4j.api.models.Project;

import Authentification.auth;

public class Projet {
	public ProjectApi proj;
	private auth Auth;
	
	public Projet(){
		Auth = new auth();
		proj = new ProjectApi(Auth.getAuth());
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
	

}
