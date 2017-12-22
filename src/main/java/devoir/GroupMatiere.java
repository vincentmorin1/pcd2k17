package devoir;

import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.GroupApi;
import org.gitlab4j.api.models.Group;
import org.gitlab4j.api.models.Visibility;


public class GroupMatiere {
	private Group matiere;
	private Integer id;
	private String name;
	private String path;
	private String fullPath;
	private Integer parentId;
	private Visibility level;
	
	public GroupMatiere(GroupApi lab,GroupRoom room,String matPath) throws GitLabApiException {
		matiere = lab.getGroup(room.getPath()+"/"+matPath);
		id = matiere.getId();
		name = matiere.getName();
		path = matiere.getPath();
		fullPath = matiere.getFullPath();
		parentId = matiere.getParentId();
		level = matiere.getVisibility();
	}

	public Group getMatiere() {
		return matiere;
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

	public String getFullPath() {
		return fullPath;
	}
	
	public Integer getParentId() {
		return parentId;
	}

	public Visibility getLevel() {
		return level;
	}

}
