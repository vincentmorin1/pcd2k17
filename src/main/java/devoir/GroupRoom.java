package devoir;

import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.GroupApi;
import org.gitlab4j.api.models.Group;
import org.gitlab4j.api.models.Visibility;

public class GroupRoom {
	private Group room;
	private Integer id;
	private String name;
	private String path;
	private Visibility visi;
	
	public GroupRoom(GroupApi lab,String roomPath) throws GitLabApiException{
		room = lab.getGroup(roomPath);
		id = room.getId();
		name = room.getName();
		path = room.getPath();
		visi = room.getVisibility();
	}
	
	public Group getRoom() {
		return room;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPath() {
		return path;
	}
	public Visibility getVisi() {
		return visi;
	}
	
	
	
	
}
