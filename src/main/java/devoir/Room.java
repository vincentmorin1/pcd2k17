package devoir;

import java.util.List;

import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.GroupApi;
import org.gitlab4j.api.UserApi;
import org.gitlab4j.api.models.AccessLevel;
import org.gitlab4j.api.models.Group;
import org.gitlab4j.api.models.User;

import Authentification.auth;

public class Room {
	public GroupApi room;
	public UserApi user;
	private String roomName = "PCDpotes";
	
	public Room(auth lab) throws GitLabApiException{
		room = lab.getGroupApi();
		user = lab.getUserApi();
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
	
	public Integer getRoomId() throws GitLabApiException {
		return room.getGroup(roomName).getId();
	}
	
	public Group getRoom() throws GitLabApiException {
		return room.getGroup(roomName);
	}
		
	public void ajouterMembre(String username, String niveau) throws GitLabApiException {
		AccessLevel var;
		switch(niveau) {
		case "Owner":
			var = AccessLevel.OWNER;
			break;
		case "Master":
			var = AccessLevel.MASTER;
			break;
		case "Developer":
			var = AccessLevel.DEVELOPER;
			break;
		case "Guest":
			var = AccessLevel.GUEST;
			break;
		default:
			var = AccessLevel.NONE;
		}
		room.addMember(room.getGroup(roomName).getId(), user.getUser(username).getId(), var);
	}
	
	public void retirerMembre(String username) throws GitLabApiException {
		room.removeMember(room.getGroup(roomName).getId(),user.getUser(username).getId());
	}
	
	public static void main(String args[]) throws GitLabApiException {
		Room room = new Room(new auth());
		room.ajouterMembre("Victor.Schwien","Developer");
	}
	
	public String getRoomName() {
		return this.roomName;
	}
}
