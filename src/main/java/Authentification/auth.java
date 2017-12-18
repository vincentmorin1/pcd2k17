package Authentification;

import org.gitlab4j.api.GitLabApi;

public class auth {
	// Créer une instance pour communiquer avec notre serveur Gitlab
	GitLabApi gitLabApi = new GitLabApi("https://gitlab.telecomnancy.univ-lorraine.fr","paul.leroux@telecomnancy.eu");
}
