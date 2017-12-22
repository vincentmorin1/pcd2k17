package devoir;

import java.util.HashMap;
import java.util.List;

import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.GroupApi;
import org.gitlab4j.api.models.Group;

public class GroupDevoirs {
	private HashMap<String,GroupDevoir> liste;
	
	public GroupDevoirs(){
		liste = new HashMap<String,GroupDevoir>();
	}
	
	public void addDevoir(GroupDevoir dev){
		liste.put(dev.getName(), dev);
	}
	
	public void deleteDevoir(GroupDevoir dev){
		liste.remove(dev.getName());
	}
	
	public GroupDevoir getDevoir(String nameDev){
		return liste.get(nameDev);
	}
	
	public void updateDevoir(GroupApi grpapi,GroupMatiere mat,List<Group> grps) throws GitLabApiException{
		for (Group g : grps){
			if (g.getParentId()!=null && g.getParentId()==mat.getId()) {
				
				GroupDevoir gr = new GroupDevoir(grpapi,mat,g.getPath());
				liste.put(gr.getName(), gr);
			}
		}
	}
	
	public HashMap<String,GroupDevoir> getListe(){
		return liste;
	}
}
