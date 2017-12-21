package devoir;

import java.util.List;

import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.GroupApi;
import org.gitlab4j.api.UserApi;
import org.gitlab4j.api.models.Group;
import org.gitlab4j.api.models.User;

import Authentification.auth;

public class Room {
	public GroupApi room;
	
	public Room(auth lab) throws GitLabApiException{
		room = lab.getGroupApi();
	}
	//création d'un nouveau devoir
	
	public void creerRoom(String name) throws GitLabApiException{
			this.room.addGroup(name, name);
	}
	
	public void supprRoom(String name) throws GitLabApiException {
		Group todel;
			todel = room.getGroup(name);
			this.room.deleteGroup(todel);
			System.out.println("Le devoir "+name+" n'existe pas !");
	}
	
	public Integer getRoomId(String name) throws GitLabApiException {
		return room.getGroup(name).getId();
	}
	
	public Group getRoom(String name) throws GitLabApiException {
		return room.getGroup(name);
	}
		
	public void ajouterMembre(String roomName,String username) throws GitLabApiException {
			
	}
}
