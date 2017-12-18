package Authentification;

import org.gitlab4j.api.GitLabApi;

public class auth{
	//Retrouve les identifiants des utilisateurs (en attente de comment reprendre les vrai input de l'interface)
		static String identifiant = "professeur";
		static String password = "PCDpotes" ;
		static String accessToken = "hwVACnEWhZMJ_Zeoz7NS";
	
	// Créer une instance pour communiquer avec notre serveur Gitlab
	//GitLabApi gitLabApi = new GitLabApi("https://gitlab.telecomnancy.univ-lorraine.fr",identifiant) ;
	
	// Pour le test d'après
	public static GitLabApi auth = new GitLabApi("https://gitlab.telecomnancy.univ-lorraine.fr", accessToken);	
}
