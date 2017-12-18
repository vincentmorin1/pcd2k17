package eleve;

public class Eleve {
	protected int id;
	protected String nom;
	protected String prenom;
	protected String email;
	protected int age;
	protected String classe;
	protected String appro;

	public Eleve(int id,String nom,String prenom, String email){
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
		if(email.equals(this.prenom +"."+this.nom+"@telecomnancy.eu")){
			this.email=email;
		}else{
			this.email="problème de syntaxe";
		}
	}
	
	public Eleve(int id,String nom,String prenom,String email, int age, String classe,String appro){
		this(id,nom,prenom,email);
		this.age=age;
		this.classe=classe;
		this.appro=appro;

	}
	
	
	public String toString(){
		return "id : "+this.id+ "\nnom : "+this.nom+"\nprenom : "+this.prenom+"\nemail : "+this.email+"\nage : "+this.age+"\nclasse : "+this.classe+"\nappro :"+this.appro ; 
	}
	
	public static void main ( String args[]){
		Eleve eleve = new Eleve (1,"Loembe","Alex-Kevin", "Alex-Kevin.Loembe@telecomnancy.eu",23,"3A","TRS");
		System.out.println(eleve.toString());
		Eleve eleve2 = new Eleve (2,"Martin","Victoria", "Victoria.Martin@telecomnancy.eu");
		System.out.println(eleve2.toString());
	}
	
}
