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
	private GroupApi roomApi;
	private UserApi user;
	private GroupRoom room;
	private String roomName = "PCDpotes"; 
	
	public Room(auth lab) throws GitLabApiException{
		roomApi = lab.getGroupApi();
		user = lab.getUserApi();
		try{
			roomApi.addGroup(roomName, roomName);
		} catch (GitLabApiException e) {}
		room = new GroupRoom(roomApi,roomName);
	}
	//création d'un nouveau devoir
	
	public void creerRoom(String name) throws GitLabApiException{
			this.roomApi.addGroup(name, name);
	}
	
	public void supprRoom() throws GitLabApiException {
			this.roomApi.deleteGroup(room.getRoom());
	}
	
	public void testCo() throws GitLabApiException {
		roomApi.addGroup("vfrvfrgtb","vfrvfrgtb");
		roomApi.deleteGroup(roomApi.getGroup("vfrvfrgtb"));
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
		roomApi.addMember(room.getId(), user.getUser(username).getId(), var);
	}
	
	public void retirerMembre(String username) throws GitLabApiException {
		roomApi.removeMember(room.getId(),user.getUser(username).getId());
	}
	
	public GroupRoom getRoom(){
		return room;
	}
}
