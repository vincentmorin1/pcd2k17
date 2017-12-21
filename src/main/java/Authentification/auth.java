package Authentification;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

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
import database.Update;
import database.maindatabase;
import eleve.Eleve;
import eleve.Eleves;

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

			try {
				Eleves liste = new Eleves();
				liste.load("eleves.csv");
				String[] resparts = null;
				createNewDatabase("eleves2.db");
		        createNewTable();
				Pager<User> users = this.auth.getUserApi().getUsers(60);
				Update app2 = new Update();
				Insert app = new Insert();
				while(users.hasNext()){
					for(User user : users.next()){
						String username =user.getUsername();
						String delims = "[.]";
						resparts = username.split(delims);
						System.out.println(resparts[1].toLowerCase());
						Integer id = user.getId();
				        app.insert(id, username,"null", "null" ,"null", "null");
				        for (Eleve eleve : liste.getListeEleves()){
				        	if (eleve.nom.toLowerCase().equals((CharSequence) resparts[1].toLowerCase())){
				        		System.out.println("match");
				        		System.out.println(user.getId());
				        		app2.update(user.getId(),eleve.nom,eleve.prenom,eleve.email,eleve.classe,eleve.appro);
				        		System.out.println("quelqu'un updated");
				        	}
					}
					}							
				}	   
			} catch (GitLabApiException e) {
				System.out.println("fake");
			}
		}
		//coucouc vincent : en fait non c'est un prank. kdsn�fvkjz^nbjdtbvdfjslm
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
