package Authentification;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

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

import devoir.Room;


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
				ArrayList<Eleve> listefinale = liste.getListeEleves();
				Update app2 = new Update();
				Insert app = new Insert();
				while(users.hasNext()){
					List<User> page = users.next();
					for(User user : page){
						String username = user.getUsername();
						String delims = "[.]";
						resparts = username.split(delims);
						String name;
						if(resparts.length > 1)
							name = resparts[1];
						else
							name = "test";
						Integer id = user.getId();
						System.out.println(id);
				        app.insert(id, username,"null","null", "null" ,"null"," null");
				       
				        for (Eleve eleve : listefinale){
				        	if (eleve.nom.toLowerCase().equals(name.toLowerCase())){
				        		app2.update(user.getId(),username,eleve.nom,eleve.prenom,eleve.email,eleve.classe,eleve.appro);
				        		System.out.println("on est la");
				        	}
				        }
					}							
				}	   
			} catch (GitLabApiException e) {
				System.out.println("erreur try auth");
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
