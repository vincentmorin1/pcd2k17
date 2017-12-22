package devoir;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.GroupApi;
import org.gitlab4j.api.models.Group;

public class GroupMatieres {
	private HashMap<String,GroupMatiere> liste;
	
	public GroupMatieres(){
		liste = new HashMap<String,GroupMatiere>();
	}
	
	public void addMatiere(GroupMatiere mat){
		liste.put(mat.getName(), mat);
	}
	
	public void deleteMatiere(GroupMatiere mat){
		liste.remove(mat.getName());
	}
	
	public GroupMatiere getMatiere(String nameMat){
		//System.out.println(liste.toString());
		return liste.get(nameMat);
	}
	
	public void updateMatiere(GroupApi grpapi,GroupRoom room,List<Group> grps) throws GitLabApiException{
		for (Group g : grps){
			if (g.getName() != room.getName() && g.getParentId() !=null){
			if (g.getParentId().equals(room.getId())){
				GroupMatiere temp = new GroupMatiere(grpapi,room,g.getPath());
				liste.put(g.getName(),temp);
			}}

		}
		System.out.println(liste.toString());
	}
	
	public HashMap<String,GroupMatiere> getListe(){
		return liste;
	}
	public Set<String> getListeMat(){
		return liste.keySet();
	}
}
