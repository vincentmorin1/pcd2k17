package eleve;

import java.util.ArrayList;

public class Groupe {
	
	public Eleves eleves; 
	public Groupe groupe;
	public ArrayList<Eleve> listeEleves ;
	
	public Groupe(){
	}
	
	/*public Groupe(Eleves groupe){
		this.groupe=groupe;
	}*/
	
	
	/*public Eleves grouppromo(String promo,int nbeleves){
		Eleves liste = new Eleves();
		listeEleves.extractpromo(promo);
		for (Eleve eleve : this.listeEleves){
			if (nb eleves){
				
			}
		}
		return eleves;
	}*/

		
	public static void main(String args[]){
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
		Eleves groupe=new Eleves();
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
		
	}
	
}

