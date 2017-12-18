package devoir;

import org.gitlab4j.api.*;
import org.gitlab4j.api.models.*;
import Authentification.auth;


public class Devoir extends GroupApi{
	public GroupApi devs;
	
	public Devoir(GitLabApi gitLabApi) throws GitLabApiException {
		super(gitLabApi);
		devs = new GroupApi(auth.auth);
		// TODO Auto-generated constructor stub
	}
	
	
	//création d'un nouveau devoir
	
	public void creerDevoir(String name) throws GitLabApiException {
		devs.addGroup(name,name);
	}
	
	public void supprDevoir(String name) throws GitLabApiException {
		Group todel = devs.getGroup(name);
		this.devs.deleteGroup(todel);
	}
	
	public void ajouterMembre(Integer groupId, Integer userId, Integer accessLevel) throws GitLabApiException {
		this.devs.addMember(groupId, userId, accessLevel);
	}
	
	public void supprMembre(Integer groupId, Integer userId) throws GitLabApiException {
		this.devs.removeMember(groupId, userId);
	}
	
}
