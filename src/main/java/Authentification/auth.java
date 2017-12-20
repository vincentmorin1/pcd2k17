package Authentification;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GroupApi;
import org.gitlab4j.api.ProjectApi;

public class auth{
	
	final static Logger log = LogManager.getLogger(auth.class);
	
	//Retrouve les identifiants des utilisateurs (en attente de comment reprendre les vrai input de l'interface)
		private String accessToken = Readfunction();
		public GitLabApi auth ;
	// Créer une instance pour communiquer avec notre serveur Gitlab
	//GitLabApi gitLabApi = new GitLabApi("https://gitlab.telecomnancy.univ-lorraine.fr",identifiant) ;
	
	// Pour le test d'après
		public auth() {
			this.auth = new GitLabApi("https://gitlab.telecomnancy.univ-lorraine.fr", accessToken);
		}
	private String Readfunction() {
		    try {
		       BufferedInputStream lecture = new BufferedInputStream(new FileInputStream("token.txt"));
		       StringWriter token = new StringWriter();
		       int b;
		       while ((b=lecture.read()) != -1)
		           token.write(b);
		       token.flush();
		       token.close();
		       lecture.close();
		       return token.toString();
		    }
		    catch (IOException ie)
		    {
		         ie.printStackTrace(); 
		    }
			return null;
		}
		
	public GitLabApi getAuth() {
		return auth;
	}
	
	public GroupApi getGroupApi() {
		return auth.getGroupApi();
	}
	
	public ProjectApi getProjectApi() {
		return auth.getProjectApi();
	}
}
