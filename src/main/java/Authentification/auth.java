package Authentification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gitlab4j.api.GitLabApi;

public class auth{
	
	final static Logger log = LogManager.getLogger(auth.class);
	
	//Retrouve les identifiants des utilisateurs (en attente de comment reprendre les vrai input de l'interface)
		private String accessToken = "f1qQVdxzXF8Dn4RmNv3h";
		public GitLabApi auth ;
	// Créer une instance pour communiquer avec notre serveur Gitlab
	//GitLabApi gitLabApi = new GitLabApi("https://gitlab.telecomnancy.univ-lorraine.fr",identifiant) ;
	
	// Pour le test d'après
		public auth() {
			this.auth = new GitLabApi("https://gitlab.telecomnancy.univ-lorraine.fr", accessToken);
		}
	public GitLabApi getAuth() {
		return auth;
	}
}
