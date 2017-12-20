package Authentification;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.GroupApi;
import org.gitlab4j.api.Pager;
import org.gitlab4j.api.ProjectApi;
import org.gitlab4j.api.UserApi;
import org.gitlab4j.api.models.User;

import database.Insert;
import database.maindatabase;

public class auth extends maindatabase{
	
	final static Logger log = LogManager.getLogger(auth.class);
	
	//Retrouve les identifiants des utilisateurs (en attente de comment reprendre les vrai input de l'interface)
		private String accessToken = Readfunction();
		public GitLabApi auth ;

	// Créer une instance pour communiquer avec notre serveur Gitlab
	//GitLabApi gitLabApi = new GitLabApi("https://gitlab.telecomnancy.univ-lorraine.fr",identifiant) ;
	
	// Pour le test d'après
		public auth() {
			this.auth = new GitLabApi("https://gitlab.telecomnancy.univ-lorraine.fr", accessToken);		

			/*try {
				createNewDatabase("eleves2.db");
		        createNewTable();
				Pager<User> users = this.auth.getUserApi().getUsers(60);
				while(users.hasNext()){
					for(User user : users.next()){
						Integer id = user.getId();
						String nom = user.getName();
						Insert app = new Insert();
				        app.insert(id, nom, "null", 0 ,"null", "null");
					}
					
				}
				
		        
			} catch (GitLabApiException e) {
				System.out.println("zizi");
			}*/

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
	
	public UserApi getUserApi() {
		return auth.getUserApi();
	}
}
