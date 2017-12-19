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

public class Eleves extends Groupe{
	

	private ArrayList<Eleve> listeEleves ;
	
	
	public Eleves() {
		this.listeEleves=new ArrayList<Eleve>();
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
	
	
	public void save(String nomFichier) {
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
	}
	
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
					filtre.useDelimiter("\\s* \\s*") ;
					
					int id = Integer.parseInt(filtre.next());
					String nom = filtre.next() ; 
					String prenom = filtre.next(); 
					String email = filtre.next() ;  
					int age =Integer.parseInt(filtre.next());
					String classe = filtre.next();
					String appro = filtre.next();
					this.ajouter(new Eleve(id,nom,prenom,email,age,classe,appro)) ;
							
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
	
	
	
	/*ça marche pas
	 * public Eleves grouppromo(Eleves eleves, String promo,int nbeleves){
		eleves.extractpromo(promo);
		for (Eleve eleve : this.listeEleves){
			for(int i=1;i<eleves.taille();i++){
				Eleves eleves_i = new Eleves();
				int nb =(int)(Math.random());
			
				if (nb==1){
					eleves2.ajouter(eleve);
				}	
			}	
		return eleves;}
	}*/

	
	public static void main(String args[]){
		//entrées eleves pour test 
		//Eleve eleve1 = new Eleve (1,"Loembe","Alex-Kevin", "Alex-Kevin.Loembe@telecomnancy.eu", 23, "3A","TRS");

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
		
		
		Eleve eleve1 = new Eleve (1,"Loembe","Alex-Kevin", "Alex-Kevin.Loembe@telecomnancy.eu",23,"3A","TRS");
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
		Eleves groupe= new Eleves();
		groupe.ajouter(eleve1);
		groupe.ajouter(eleve2);
		groupe.ajouter(eleve3);
		groupe.ajouter(eleve4);
		groupe.ajouter(eleve5);
		groupe.ajouter(eleve6);
		groupe.ajouter(eleve7);
		groupe.ajouter(eleve8);
		groupe.ajouter(eleve9);
		groupe.ajouter(eleve10);
		groupe.ajouter(eleve11);
		groupe.ajouter(eleve12);
		//test extractpromo
		//Eleves liste2 = groupe.extractpromo("2A");
		//System.out.println(liste2.toString());
		
		//test extractappro
		Eleves liste =groupe.extractappro("2A", "SIE");
		System.out.println(liste.toString());
	}
}
