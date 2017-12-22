package devoir;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.gitlab4j.api.*;
import org.gitlab4j.api.models.*;
import Authentification.auth;
import database.Insert;
import database.Update;
import database.maindatabase;


public class Devoir extends maindatabase{
	private GroupApi devApi;
	private UserApi user;
	private GroupMatieres mats;
	private GroupDevoirs devs;
	private Set<String> ma;
	private ProjectApi projectapi;
	
	
	public Devoir(auth lab, Matiere mat) throws GitLabApiException{
		devApi = lab.getGroupApi();
		user = lab.getUserApi();
		mats = mat.getMats();
		devs = new GroupDevoirs();
		ma = mats.getListeMat();
		for (String m : ma){
			devs.updateDevoir(devApi, mats.getMatiere(m), devApi.getGroups());
		}
	}
	//création d'un nouveau devoir
	
	public void creerDevoir(String name, String desc, String nomMat,boolean visi,LocalDate debut,LocalDate fin,String liste) throws GitLabApiException{
		Visibility var;
		if(visi) {
			var = Visibility.PRIVATE;
		} else {
			var = Visibility.PUBLIC;
		}	
		this.devApi.addGroup(name, name, desc, Boolean.FALSE, Boolean.TRUE,var,Boolean.FALSE,Boolean.FALSE,mats.getMatiere(nomMat).getId(),0);
		devs.addDevoir(new GroupDevoir(devApi,mats.getMatiere(nomMat),name) );
			Date d = Date.valueOf(debut);
			Date f = Date.valueOf(fin);
			//System.out.println(d.toString());
			createNewTabledev();
			  Insert app = new Insert();
			  app.insertdev(devs.getDevoir(name).getId(), name,nomMat,d.toString(),f.toString(),liste);
			  
	}
	
	public void modifierDevoir(String name, String desc, String nomMat,boolean visi,LocalDate debut,LocalDate fin,String liste) throws GitLabApiException {
		Visibility var;
		if(visi) {
			var = Visibility.PRIVATE;
		} else {
			var = Visibility.PUBLIC;
		}
		devs.deleteDevoir(devs.getDevoir(name));
		this.devApi.updateGroup(devs.getDevoir(name).getId(),name, name, desc, Boolean.FALSE, Boolean.TRUE,var,Boolean.FALSE,Boolean.FALSE,mats.getMatiere(nomMat).getId(),0);
		devs.updateDevoir(devApi, mats.getMatiere(nomMat), devApi.getGroups());
			Date d = Date.valueOf(debut);
			Date f = Date.valueOf(fin);
			//System.out.println(d.toString());
			createNewTabledev();
			  Update app = new Update();
			  app.updatedev(devs.getDevoir(name).getId(), name,nomMat,d.toString(),f.toString(),liste);
			  
	}
	
	public void creerDevoir(String name, String desc, String nomMat, boolean visi) throws GitLabApiException{
		Visibility var;
		if(visi) {
			var = Visibility.PRIVATE;
		} else {
			var = Visibility.PUBLIC;
		}
			this.devApi.addGroup(name, name, desc, Boolean.FALSE, Boolean.TRUE,var,Boolean.FALSE,Boolean.FALSE,mats.getMatiere(nomMat).getId(),0);
			devs.addDevoir(new GroupDevoir(devApi,mats.getMatiere(nomMat),name) );
	}
	
	public void creerDevoirAlea(String name, String desc, String nomMat, boolean visi,LocalDate debut,LocalDate fin,String liste) throws GitLabApiException{
		Visibility var;
		if(visi) {
			var = Visibility.PRIVATE;
		} else {
			var = Visibility.PUBLIC;
		}
			this.devApi.addGroup(name, name, desc, Boolean.FALSE, Boolean.TRUE,var,Boolean.FALSE,Boolean.FALSE,mats.getMatiere(nomMat).getId(),0);
			devs.addDevoir(new GroupDevoir(devApi,mats.getMatiere(nomMat),name) );
			
	}
	
	public void supprDevoir(String name) throws GitLabApiException {
			GroupDevoir todel = devs.getDevoir(name);
			this.devApi.deleteGroup(todel.getDevoir());
			devs.deleteDevoir(todel);
	}
	
	public void ajouterMembre(String devName, String username, String niveau) throws GitLabApiException {
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
		devApi.addMember(devs.getDevoir(devName).getId(), user.getUser(username).getId(), var);
	}
	
	public void retirerMembre(String devName, String username) throws GitLabApiException {
		devApi.removeMember(devs.getDevoir(devName).getId(),user.getUser(username).getId());
	}
	
	public Set<String> getLiteMat(){
		return ma;
	}
	
	public GroupDevoirs getDevoirs() {
		return devs;
	}
	
	
	public List<Project> getProjects(String name) throws GitLabApiException{
		List<Project> projs = devs.getDevoir(name).getDevoir().getProjects();
		return projs;
	}
	
	/*public static void main(String args[]){
		auth lab = new auth();
		Room room;
		try {
			room = new Room(lab);
			Matiere mat = new Matiere(lab,room);
			Devoir dev = new Devoir(lab,mat);
			System.out.println("3");
			dev.creerDevoir("Projet", "C'est notre projet", "MOCI", true);
			System.out.println("4");
		} catch (GitLabApiException e) {
			System.out.println("zgeg");
		}
		//dev.ajouterMembre("MOCI","okapi","Victor.Schwien","Developer");
	}*/
	
}
