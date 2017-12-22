package devoir;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

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
		//System.out.println(liste.toString());
		return liste.get(nameDev);
	}
	
	public void updateDevoir(GroupApi grpapi,GroupMatiere mat,List<Group> grps) throws GitLabApiException{
		for (Group g : grps){
			if (g.getParentId()!=null) {
			if (g.getParentId().equals(mat.getId())) {
				liste.put(g.getName(), new GroupDevoir(grpapi,mat,g.getPath()));
			}}
		}
	}
	
	public HashMap<String,GroupDevoir> getListe(){
		return liste;
	}
	
	public Set<String> getListDev(){
		return liste.keySet();
	}
}
