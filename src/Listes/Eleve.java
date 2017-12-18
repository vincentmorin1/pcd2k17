package Listes;

public class Eleve {
	protected int id;
	protected String nom;
	protected int age;
	protected String classe;
	protected String appro;

	
	
	public Eleve(int id,String nom, int age, String classe,String appro){
		this.id=id;
		this.classe=classe;
		this.age=age;
		this.nom=nom;
		this.appro=appro;
	}
	
	
	public String toString(){
		return "id : "+this.id+ "\nnom : "+this.nom+"\nage : "+this.age+"\nclasse : "+this.classe+"\nappro :"+this.appro ; 
	}
	
	public static void main ( String args[]){
		Eleve eleve = new Eleve (1,"Loembe", 23, "3A","TRS");
		System.out.println(eleve.toString());
	}
	
}
