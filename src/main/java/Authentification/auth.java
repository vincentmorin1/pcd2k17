package Authentification;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.GroupApi;
import org.gitlab4j.api.Pager;
import org.gitlab4j.api.ProjectApi;
import org.gitlab4j.api.UserApi;
import org.gitlab4j.api.models.Group;
import org.gitlab4j.api.models.Member;
import org.gitlab4j.api.models.Owner;
import org.gitlab4j.api.models.Project;
import org.gitlab4j.api.models.ProjectSharedGroup;
import org.gitlab4j.api.models.User;

import database.Insert;
import database.Update;
import database.maindatabase;

import eleve.Eleve;
import eleve.Eleves;
import devoir.Matiere;
import devoir.Room;


public class auth extends maindatabase{
	
	final static Logger log = LogManager.getLogger(auth.class);
	
	//Retrouve les identifiants des utilisateurs (en attente de comment reprendre les vrai input de l'interface)
		private String accessToken = Readfunction();
		public GitLabApi auth ;

	// Créer une instance pour communiquer avec notre serveur Gitlab
	//GitLabApi gitLabApi = new GitLabApi("https://gitlab.telecomnancy.univ-lorraine.fr",identifiant) ;
	
	// Pour le test d'après
		public auth() {
			this.auth = new GitLabApi("https://gitlab.telecomnancy.univ-lorraine.fr", accessToken);
			try {
				Eleves liste = new Eleves();
				liste.load("eleves.csv");
				String[] resparts = null;
				createNewDatabase("eleves2.db");
		        createNewTable();
				Pager<User> users = this.auth.getUserApi().getUsers(60);
				ArrayList<Eleve> listefinale = liste.getListeEleves();
				Update app2 = new Update();
				Insert app = new Insert();
				while(users.hasNext()){
					List<User> page = users.next();
					for(User user : page){
						String username = user.getUsername();
						String delims = "[.]";
						resparts = username.split(delims);
						String name;
						if(resparts.length > 1)
							name = resparts[1];
						else
							name = "test";
						Integer id = user.getId();
				        app.insert(id, username,"null","null", "null" ,"null"," null");
				       
				        for (Eleve eleve : listefinale){
				        	if (eleve.nom.toLowerCase().equals(name.toLowerCase())){
				        		app2.update(user.getId(),username,eleve.nom,eleve.prenom,eleve.email,eleve.classe,eleve.appro);
				        		}
				        }
					}							
				}	   
			} catch (GitLabApiException e) {
				System.out.println("erreur try auth");
			}
			try {
				System.out.println("on est la");
				Insert app = new Insert();
				int i = 0;
				int z= 0;
				GroupApi groups =this.auth.getGroupApi();
				Pager<Group> pagergroupe = groups.getGroups(60);				
				createNewTableProject();
				createNewTabledev();
				createNewTableMatiere();
				int id_room = groups.getGroup("PCDpotes").getId();
				while(pagergroupe.hasNext()){
					List<Group> listgroup = pagergroupe.next();
					List<Group> listmat = listgroup.subList(0, 0);
					for(Group group : listgroup){
						z=z+1;
						if (group.getParentId()==id_room){
							i=i+1;
							System.out.println("Condition1");//OK
							listmat.add(group);
							System.out.println(listmat);
							//appeler ce dont on a besoin
							for(Group group2 : listmat){
								//on recupere les matieres
								Integer id= group2.getId();
								System.out.println(id);
								String nommat = group2.getName();
								System.out.println(nommat);
								app.insertmat(id, nommat);
							}
							
							
				}
				
						/*System.out.println(listidmat);
						listnommat.add(group.getName());
						System.out.println(listnommat);
						for(Integer i : listidmat){
							Insert app2 = new Insert();
							System.out.println("i :"+i);
							app2.insertmat(i, listnommat.get(i));
							if (group.getId()==i){
								System.out.println("Condition2");
								String titre = group.getName();
								Integer id = group.getId();	
								Group matiere =groups.getGroup(group.getParentId());
								List<Project> pagerproject = groups.getProjects(60);				
								for (Project project : pagerproject){
									Integer idproject = project.getId();
									String name = project.getName();
									Owner owner = project.getOwner();
									Date datedeb = project.getCreatedAt();
									Insert app = new Insert();
									app.insertdev(id, matiere.toString(), titre, "unknown", "unknown", "unknown");//ajouter iddevoir
									app.insertproj(idproject,name, owner.toString(), datedeb.toString());
									
								}
							}
						}*/
					}System.out.println(i);
					System.out.println(z);
					
				}
				
			} catch (GitLabApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//coucouc vincent : en fait non c'est un prank. kdsn�fvkjz^nbjdtbvdfjslm
	private String Readfunction() {
		    try {
		       BufferedInputStream lecture = new BufferedInputStream(new FileInputStream("token.txt"));
		       StringWriter token = new StringWriter();
		       int b;
		       while ((b=lecture.read()) != -1)
		           token.write(b);
		       token.flush();
		       token.close();
		       lecture.close();
		       return token.toString();
		    }
		    catch (IOException ie)
		    {
		         ie.printStackTrace(); 
		    }
			return null;
		}
		
	public GitLabApi getAuth() {
		return auth;
	}
	

	public GroupApi getGroupApi() {
		return auth.getGroupApi();
	}
	
	public ProjectApi getProjectApi() {
		return auth.getProjectApi();
	}
	
	public UserApi getUserApi() {
		return auth.getUserApi();
	}
}
