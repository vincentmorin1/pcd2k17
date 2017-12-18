package devoir;
import java.util.ArrayList;
import java.util.HashMap;
import org.gitlab4j.api.*;
import org.gitlab4j.api.models.*;

public class Devoir {

	GitLabApi auth = new GitLabApi("","","");
	GroupApi listeDevoirs = new GroupApi(auth);
	
	//création d'un nouveau devoir
	
	public void creerDevoir(String name, String desc, Boolean membershipLock, Boolean shareWithGroupLock, Visibility visi, Boolean lfsEnabled, Boolean requestAccessEnabled, Integer parentId, Integer sharedRunnersMinutesLimit) throws GitLabApiException {
		listeDevoirs.addGroup(name,"https://gitlab.telecomnancy.univ-lorraine.fr/"+name,desc,membershipLock,shareWithGroupLock,visi,lfsEnabled,requestAccessEnabled,parentId,sharedRunnersMinutesLimit);
	}
	
	public void supprDevoir(String name) throws GitLabApiException {
		Group todel = listeDevoirs.getGroup("https://gitlab.telecomnancy.univ-lorraine.fr/"+name);
		listeDevoirs.deleteGroup(todel);
	}
	
	public void ajouterMembre(Integer groupId, Integer userId, Integer accessLevel) throws GitLabApiException {
		listeDevoirs.addMember(groupId, userId, accessLevel);
	}
	
	public void supprMembre(Integer groupId, Integer userId) throws GitLabApiException {
		listeDevoirs.removeMember(groupId, userId);
	}
	
}
