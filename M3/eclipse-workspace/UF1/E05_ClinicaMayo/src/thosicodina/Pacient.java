package thosicodina;

public class Pacient {
	private String nom;
	private Sexe sexe;
	private int edat;
	
	public Pacient(String nom, Sexe sexe, int edat) {
		super();
		this.nom = nom;
		this.sexe = sexe;
		this.edat = edat;
	}
	
	public boolean esHome() {
		return this.sexe == Sexe.HOME;
	}

	public String getNom() {
		return nom;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public int getEdat() {
		return edat;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public void setEdat(int edat) {
		this.edat = edat;
	}

	@Override
	public String toString() {
		return "Pacient: " + this.nom
				+ "\nSexe: " + this.sexe  
				+ "\nEdat: " + this.edat + "\n";
	}
}
