package Authentification;

import org.gitlab4j.api.GitLabApi;

import eu.telecomnancy.pcd2k17.MainController;

public class auth{
	//Retrouve les identifiants des utilisateurs (en attente de comment reprendre les vrai input de l'interface)
		private String identifiant = "";
		private String password = "PCDpotes" ;
		private String accessToken = "hwVACnEWhZMJ_Zeoz7NS";
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
