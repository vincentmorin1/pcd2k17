package eleve;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

import org.gitlab4j.api.Pager;

public class Eleves extends Groupe{
	

	private ArrayList<Eleve> listeEleves ;
	
	
	public Eleves() {
		this.listeEleves=new ArrayList<Eleve>();
	}
	
	public ArrayList<Eleve> getListeEleves(){
		return this.listeEleves;
	}
	
	
	public void ajouter(Eleve eleve) {
		this.listeEleves.add(eleve);
	}
	
	
	public Eleves extract(String nom, int id){
			Eleves liste = new Eleves() ;
			
			for (Eleve eleve1 : this.listeEleves) {
				if (eleve1.id==id) {
					 liste.ajouter(eleve1) ;
				}
			}
			return liste;
	}
	
	public void enleve(String nom, int id){
		
		for(Eleve eleve2 : this.listeEleves){
			if(eleve2.id==id){
				this.listeEleves.remove(eleve2);
			}
		}
	}
	
	public int taille() {
		return this.listeEleves.size();
	}
	
	public String toString() {
		String chaine = "" ;
		
		for (Eleve eleve : this.listeEleves) {
			chaine += eleve.toString() + "\n" ;
		}
		
		return chaine ;
	}
	
	
	/*public void save(String nomFichier) {
		FileWriter flot ;
		PrintWriter flotFiltre ;
		String newLine = System.getProperty("line.separator");
		File monFichier = new File(nomFichier);
		
		try {
			
			if (!monFichier.exists()) { //Le fichier ne doit pas existï¿½ dï¿½jï¿½
				flot = new FileWriter(nomFichier) ;
				flotFiltre = new PrintWriter(flot) ;
				
				for (Eleve eleve : this.listeEleves) {
					flotFiltre.write(eleve.id+" "+eleve.nom+" "+eleve.prenom+" "+eleve.email+" "+eleve.age+" "+eleve.classe+" "+eleve.appro + newLine) ;
				}
				
				flotFiltre.close() ;
			} 
			
			else throw new IOException();
			
		} catch (IOException e) {
			System.out.println("Ouverture impossible ou fichier dejaï¿½ existant.") ;
		}
	}*/
	
	public Eleves extractpromo(String promo) {

			Eleves eleves = new Eleves() ;
			
			for (Eleve eleve2 : this.listeEleves) {
				if (eleve2.classe.equals(promo)) {
					eleves.ajouter(eleve2) ;
				}
			}
			return eleves ;
		}

	public Eleves extractappro(String promo,String appro){
		Eleves eleves = new Eleves();
		
		for (Eleve eleve : this.listeEleves){
			if (eleve.classe.equals(promo) && eleve.appro.equals(appro)){
				eleves.ajouter(eleve);
			}
		}
		return eleves ;
	}
	
	public static ArrayList<Integer> getids(String nomFichier){
		FileReader flot ;
		BufferedReader flotFiltre ;
		Scanner filtre = null ;
		ArrayList<Integer> listid = new ArrayList();
				
		try	{
					
			if (((nomFichier.split("\\."))[1]).equals("csv")) { //Si c'est le bon format...
					
				flot = new FileReader(nomFichier) ;
				flotFiltre = new BufferedReader(flot) ;
				String ligne = flotFiltre.readLine() ;
				
					
				while (ligne != null) {
							
					filtre = new Scanner(ligne) ;
					filtre.useDelimiter("\\s* \\s*") ;
					
					int id = Integer.parseInt(filtre.next());
					filtre.next(); 
					filtre.next(); 
					filtre.next();  
					filtre.next();
					filtre.next();
					filtre.next();
					listid.add(id);		
					ligne = flotFiltre.readLine() ;
				}
					
				flot.close() ;
				filtre.close() ;
				
			}
					
			else throw new IOException();

		} catch (IOException e) {
			System.out.println("Lecture impossible ou mauvais format.") ;
		}
		return listid ;
	}
	
	
	
	public void load(String nomFichier) {
		
		FileReader flot ;
		BufferedReader flotFiltre ;
		Scanner filtre = null ;
				
		try	{
					
			if (((nomFichier.split("\\."))[1]).equals("csv")) { //Si c'est le bon format...
					
				flot = new FileReader(nomFichier) ;
				flotFiltre = new BufferedReader(flot) ;
				String ligne = flotFiltre.readLine() ;

					
				while (ligne != null) {
							
					filtre = new Scanner(ligne) ;
					filtre.useDelimiter("\\s*;\\s*") ;
					String prenom = filtre.next();
					String nom = filtre.next() ;
					String email = filtre.next() ;  					
					String classe = filtre.next();
					String appro = filtre.next();
					this.ajouter(new Eleve("nik",prenom,nom,email,classe,appro)) ;
							
					ligne = flotFiltre.readLine() ;
				}
					
				flot.close() ;
				filtre.close() ;
			}
					
			else throw new IOException();

		} catch (IOException e) {
			System.out.println("Lecture impossible ou mauvais format.") ;
		}
	}
	
	
	
	
	public static void generategroupe(ArrayList<Eleve> eleves, int nbeleves){
		int c=0;
		ArrayList<Eleve> tmp = eleves;
		for(Eleve eleve : tmp){		
			ArrayList<Eleve> listegroupe = new ArrayList<Eleve>();
			}	
		}
	

	/* public Eleves grouppromo(Eleves eleves, String promo,int nbeleves){
		eleves.extractpromo(promo);
		
	}*/

	
	public static void main(String args[]){
		//entrées eleves pour test 
		//Eleve eleve1 = new Eleve ("Loembe","Alex-Kevin", "Alex-Kevin.Loembe@telecomnancy.eu", "3A","TRS");
		
		
		/*Eleves liste2 = new Eleves();
		liste2.load1A("testid.csv");
		System.out.println(liste2.toString());*/
		
		//System.out.println(eleve1.toString());
		//Eleve eleve2 = new Eleve (2,"Martin","Victoria", "Victoria.Martin@telecomnancy.eu", 22, "3A","SIE");
		//System.out.println(eleve2.toString());
		//Eleves liste = new Eleves();
		
		//test ajouter
		//liste.ajouter(eleve1);
		//liste.ajouter(eleve2);
		
		//test save : OK
		//System.out.println(liste.toString());
		//liste.save("test.csv");
		
		//test extract : OK
		//Eleves liste2 =liste.extract("Loembe", 1);
		//System.out.println(liste2.toString());
		
		//test enleve : OK
		//liste.enleve("loembe",1);
		//System.out.println(liste.toString());
		
		//test load : OK
		//liste.load("test.csv");
		//System.out.println(liste.toString());
		
		
		/*Eleve eleve1 = new Eleve (1,"Loembe","Alex-Kevin", "Alex-Kevin.Loembe@telecomnancy.eu",23,"3A","TRS");
		Eleve eleve2 = new Eleve (2,"Martin","Victoria", "Victoria.Martin@telecomnancy.eu",22,"3A","SIE");
		Eleve eleve3 = new Eleve (3,"Leroux","Paul", "Paul.Leroux@telecomnancy.eu",22,"2A","IAMD");
		Eleve eleve4 = new Eleve (4,"Roudaut","Tanguy", "Tanguy.Roudaut@telecomnancy.eu",21,"2A","IL");
		Eleve eleve5 = new Eleve (5,"Hynes","Jeremy", "Jeremy.Hynes@telecomnancy.eu",21,"2A","IL");
		Eleve eleve6 = new Eleve (6,"Tartary","Michelle", "Michelle.Tartary@telecomnancy.eu",21,"2A","SIE");
		Eleve eleve7 = new Eleve (7,"Chenet","Isabelle", "Isabelle.Chenet@telecomnancy.eu",21,"2A","LE");
		Eleve eleve8 = new Eleve (8,"Thomassin","Brigitte", "Brigitte.Thomassin@telecomnancy.eu",21,"2A","TRS");
		Eleve eleve9 = new Eleve (9,"Morin","Vincent", "Vincent.Morin@telecomnancy.eu",21,"2A","null");
		Eleve eleve10 = new Eleve (10,"Schwien","Victor", "Victor.Schwien@telecomnancy.eu",21,"1A","null");
		Eleve eleve11 = new Eleve (11,"Bortolus","Alan", "Alan.Bortolus@telecomnancy.eu",20,"1A","null");
		Eleve eleve12 = new Eleve (12,"Nakong","Dylan", "Dylan.Nakong@telecomnancy.eu",20,"1A","null");
		ArrayList<Eleve> groupe= new ArrayList<Eleve>();
		groupe.add(eleve1);
		groupe.add(eleve2);
		groupe.add(eleve3);
		groupe.add(eleve4);
		groupe.add(eleve5);
		groupe.add(eleve6);
		groupe.add(eleve7);
		groupe.add(eleve8);
		groupe.add(eleve9);
		groupe.add(eleve10);
		groupe.add(eleve11);
		groupe.add(eleve12);
		generategroupe(groupe, 2);*/
		//test génération aleatoire de groupe à partir d'une arraylist d'eleves
		
		
		
		/*test listid
		groupe.save("testid.csv");
		ArrayList<Integer> listid = new ArrayList<Integer>();
		listid = getids("testid.csv");
		System.out.println(listid);*/
		
		//test extractpromo
		//Eleves liste2 = groupe.extractpromo("2A");
		//System.out.println(liste2.toString());
		
		/*test extractappro
		Eleves liste =groupe.extractappro("2A", "SIE");
		System.out.println(liste.toString());*/
		
		//test base de données sql
		/*Eleves liste2 = new Eleves();
		liste2.load("eleves.bd");
		System.out.println(liste2.toString());*/
		
	}
}
