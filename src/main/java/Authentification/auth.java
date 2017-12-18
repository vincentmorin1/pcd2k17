package Authentification;

import org.gitlab4j.api.GitLabApi;

public class auth {
	//Retrouve les identifiants des utilisateurs (en attente de comment reprendre les vrai input de l'interface)
		String identifiant = "professeur";
		String password = "PCDpotes" ;
	
	// Créer une instance pour communiquer avec notre serveur Gitlab
	//GitLabApi gitLabApi = new GitLabApi("https://gitlab.telecomnancy.univ-lorraine.fr",identifiant) ;
	
	// Pour le test d'après
	GitLabApi gitLabApi = new GitLabApi("https://gitlab.telecomnancy.univ-lorraine.fr", identifiant, password);	
}
