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
	public UserApi users;
	public Matiere mat;
	private List<User> usersListe;
	
	public Devoir(auth lab) throws GitLabApiException{
		devs = lab.getGroupApi();
		users = lab.getUserApi();
		usersListe = users.getUsers();
		mat = new Matiere(lab);
		// TODO Auto-generated constructor stub
	}
	//création d'un nouveau devoir
	
	public void creerDevoir(String name, String desc, String nomMat,LocalDate debut,LocalDate fin,String liste) throws GitLabApiException{
			this.devs.addGroup(name, name, desc, Boolean.FALSE, Boolean.TRUE,Visibility.PRIVATE,Boolean.FALSE,Boolean.FALSE,mat.getMatiereId(nomMat),0);
			Date d = Date.valueOf(debut);
			Date f = Date.valueOf(fin);
			System.out.println(d.toString());
			createNewTabledev();
			  Insert app = new Insert();
			  app.insertdev(nomMat, name,d.toString(),f.toString(),liste);
	}

	public void creerDevoir(String name, String desc, String nomMat) throws GitLabApiException{
			this.devs.addGroup(name, name, desc, Boolean.FALSE, Boolean.TRUE,Visibility.PUBLIC,Boolean.FALSE,Boolean.FALSE,mat.getMatiereId(nomMat),0);

	}
	
	public void supprDevoir(String name) throws GitLabApiException {
		Group todel;
			todel = devs.getGroup(name);
			this.devs.deleteGroup(todel);
	}
	
	public Integer getDevoirId(String name) throws GitLabApiException {
		return devs.getGroup(name).getId();
	}
	
	public Group getDevoir(String name) throws GitLabApiException {
		return devs.getGroup(name);
	}
	
	public void ajouterMembre(String devoir,String nom,String prenom) throws GitLabApiException {

			Integer userId = users.getUser(prenom+"."+nom+"@telecomnancy.eu").getId();
			Integer accessLevel = 0;
			devs.addMember(devs.getGroup(devoir).getId(), userId, accessLevel);
	}
	
	public void modifiernomDevoir(String name, String newname) throws GitLabApiException{
		this.devs.updateGroup(devs.getGroup(name).getId(), newname, newname, devs.getGroup(name).getDescription(), Boolean.FALSE, Boolean.TRUE,Visibility.PRIVATE,Boolean.FALSE,Boolean.FALSE,devs.getGroup(name).getParentId(),0);
    }
	
	public void modifierdescDevoir(String name, String newdesc) throws GitLabApiException{
		this.devs.updateGroup(devs.getGroup(name).getId(), name, name, newdesc, Boolean.FALSE, Boolean.TRUE,Visibility.PRIVATE,Boolean.FALSE,Boolean.FALSE,devs.getGroup(name).getParentId(),0);
    }
	
	public void modifiermatiereDevoir(String name, String nomMat) throws GitLabApiException{
		this.devs.updateGroup(devs.getGroup(name).getId(), name, name, devs.getGroup(name).getDescription(), Boolean.FALSE, Boolean.TRUE,Visibility.PRIVATE,Boolean.FALSE,Boolean.FALSE,mat.getMatiereId(nomMat),0);
    }
	
}
