package devoir;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.gitlab4j.api.*;
import org.gitlab4j.api.models.*;
import Authentification.auth;
import database.Insert;
import database.maindatabase;


public class Devoir extends maindatabase{
	public GroupApi devs;
	public UserApi user;
	public Matiere mat;
	public ProjectApi projs;
	public GitLabApi auth ;
	
	public Devoir(auth lab) throws GitLabApiException{
		devs = lab.getGroupApi();
		user = lab.getUserApi();
		mat = new Matiere(lab);
		
		// TODO Auto-generated constructor stub
	}
	//création d'un nouveau devoir
	
	public void creerDevoir(String name, String desc, String nomMat,boolean visi,LocalDate debut,LocalDate fin,String liste) throws GitLabApiException{
		Visibility var;
		if(visi) {
			var = Visibility.PRIVATE;
		} else {
			var = Visibility.PUBLIC;
		}	
		this.devs.addGroup(name, name, desc, Boolean.FALSE, Boolean.TRUE,var,Boolean.FALSE,Boolean.FALSE,mat.getMatiereId(nomMat),0);
			Date d = Date.valueOf(debut);
			Date f = Date.valueOf(fin);
			System.out.println(d.toString());
			Integer id = this.devs.getGroup(name).getId();
			createNewTabledev();
			  Insert app = new Insert();
			  app.insertdev(id,nomMat, name,d.toString(),f.toString(),liste);
	}

	public void creerDevoir(String name, String desc, String nomMat, boolean visi) throws GitLabApiException{
		Visibility var;
		if(visi) {
			var = Visibility.PRIVATE;
		} else {
			var = Visibility.PUBLIC;
		}
			this.devs.addGroup(name, name, desc, Boolean.FALSE, Boolean.TRUE,var,Boolean.FALSE,Boolean.FALSE,mat.getMatiereId(nomMat),0);

	}
	
	public void supprDevoir(String matName, String name) throws GitLabApiException {
		Group todel;
			todel = devs.getGroup(mat.getFullPath(matName)+"/"+name);
			this.devs.deleteGroup(todel);
	}
	
	public Integer getDevoirId(String matName, String name) throws GitLabApiException {
		return devs.getGroup(mat.getFullPath(matName)+"/"+name).getId();
	}
	
	public String getDevoirName(Integer id) throws GitLabApiException {
		return devs.getGroup(id).getName();
	}
	
	public Group getDevoir(String matName,String name) throws GitLabApiException {
		return devs.getGroup(mat.getFullPath(matName)+"/"+name);
	}
	
	public void modifiernomDevoir(String matName, String name, String newname) throws GitLabApiException{
		this.devs.updateGroup(devs.getGroup(mat.getFullPath(matName)+"/"+name).getId(), newname, newname, devs.getGroup(name).getDescription(), Boolean.FALSE, Boolean.TRUE,Visibility.PRIVATE,Boolean.FALSE,Boolean.FALSE,devs.getGroup(name).getParentId(),0);
    }
	
	public void modifierdescDevoir(String matName, String name, String newdesc) throws GitLabApiException{
		this.devs.updateGroup(devs.getGroup(mat.getFullPath(matName)+"/"+name).getId(), name, name, newdesc, Boolean.FALSE, Boolean.TRUE,Visibility.PRIVATE,Boolean.FALSE,Boolean.FALSE,devs.getGroup(name).getParentId(),0);
    }
	
	public void modifiermatiereDevoir(String matName, String name, String nomMat) throws GitLabApiException{
		this.devs.updateGroup(devs.getGroup(mat.getFullPath(matName)+"/"+name).getId(), name, name, devs.getGroup(name).getDescription(), Boolean.FALSE, Boolean.TRUE,Visibility.PRIVATE,Boolean.FALSE,Boolean.FALSE,mat.getMatiereId(nomMat),0);
    }
	
	public void ajouterMembre(String matName, String devName, String username, String niveau) throws GitLabApiException {
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
		devs.addMember(devs.getGroup(mat.getMatiere(matName).getFullPath()+"/"+devName).getId(), user.getUser(username).getId(), var);
	}
	
	public void retirerMembre(String devName, String username) throws GitLabApiException {
		devs.removeMember(devs.getGroup(devName).getId(),user.getUser(username).getId());
	}
	
	public String getFullPath(String matName, String devName) throws GitLabApiException {
		return mat.getFullPath(matName)+"/"+devName;
	}
	
	public void delAllGroups() throws GitLabApiException {
		List<Group> liste = devs.getGroups();
		for (Group gr : liste) {
			devs.deleteGroup(devs.getGroup(gr.getFullPath()));
		}
	}

	/*public static void main(String args[]) throws GitLabApiException{
		Devoir dev = new Devoir(new auth());
		//dev.ajouterMembre("MOCI","okapi","Victor.Schwien","Developer");
	}*/
	
}
