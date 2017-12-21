package eleve;

public class Eleve {
	protected int id;
	public String nom;
	public String prenom;
	public String email;
	public String classe;
	public String appro;
	public String username ;

	public Eleve(String username,String prenom,String nom, String email,String classe,String appro){
		this.username=username;
		this.nom=nom;
		this.prenom=prenom;
		this.classe = classe;
		this.appro=appro;
		this.email=email;
	}
	
	
	public String getappro(){
		return this.appro;
	}
	
	public String toString(){
		return "\nusername : "+this.username+"\nprenom : "+this.prenom+ "\nnom : "+this.nom+"\nemail : "+this.email+"\nclasse : "+this.classe+"\nappro :"+this.appro ; 
	}
	
	public static void main ( String args[]){
		/*Eleve eleve = new Eleve (1,"Loembe","Alex-Kevin", "Alex-Kevin.Loembe@telecomnancy.eu",23,"3A","TRS");
		System.out.println(eleve.toString());
		Eleve eleve2 = new Eleve (2,"Martin","Victoria", "Victoria.Martin@telecomnancy.eu");
		System.out.println(eleve2.toString());
		System.out.println(eleve.getappro());*/
	}
	
}
