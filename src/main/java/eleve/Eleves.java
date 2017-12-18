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

public class Eleves {
	

	private ArrayList<Eleve> listeEleves ;
	
	
	public Eleves() {
		this.listeEleves=new ArrayList<Eleve>(); ;
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
			
			if (!monFichier.exists()) { //Le fichier ne doit pas exist� d�j�
				flot = new FileWriter(nomFichier) ;
				flotFiltre = new PrintWriter(flot) ;
				
				for (Eleve eleve : this.listeEleves) {
					flotFiltre.write(eleve.id+" "+eleve.nom+" "+eleve.age+" "+eleve.classe+" "+eleve.appro + newLine) ;
				}
				
				flotFiltre.close() ;
			} 
			
			else throw new IOException();
			
		} catch (IOException e) {
			System.out.println("Ouverture impossible ou fichier deja� existant.") ;
		}
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
					int age = Integer.parseInt(filtre.next()); 
					String classe = filtre.next() ; 
					String appro = filtre.next() ; 
						
					this.ajouter(new Eleve(id,nom,age,classe,appro)) ;
							
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
	
	
	public static void main(String args[]){
		//entr�es eleves pour test 
		Eleve eleve1 = new Eleve (1,"Loembe", 23, "3A","TRS");
		//System.out.println(eleve1.toString());
		Eleve eleve2 = new Eleve (2,"Martin", 22, "3A","SIE");
		//System.out.println(eleve2.toString());
		Eleves liste = new Eleves();
		
		//test ajouter
		//liste.ajouter(eleve1);
		//liste.ajouter(eleve2);
		
		//test save : OK
		//System.out.println(liste.toString());
		//liste.save("test.csv");
		
		//test extract : OK
		//Eleves liste2 =liste.extract("loembe", 1);
		//System.out.println(liste2.toString());
		
		//test enleve
		//liste.enleve("loembe",1);
		//System.out.println(liste.toString());
		
		//test load
		liste.load("test.csv");
		System.out.println(liste.toString());
	}
}
