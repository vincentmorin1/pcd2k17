package devoir;

import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.GroupApi;
import org.gitlab4j.api.models.Group;
import org.gitlab4j.api.models.Visibility;

public class GroupDevoir {
	private Group devoir;
	private Integer id;
	private String name;
	private String path;
	private String fullPath;
	private Integer parentId;
	private Visibility level;
	
	public GroupDevoir(GroupApi lab, GroupMatiere mat,String devPath) throws GitLabApiException {
		devoir = lab.getGroup(mat.getFullPath()+"/"+devPath);
		id = devoir.getId();
		name = devoir.getName();
		path = devoir.getPath();
		fullPath = devoir.getFullPath();
		parentId = devoir.getParentId();
		level = devoir.getVisibility();
	}

	public Group getDevoir() {
		return devoir;
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
