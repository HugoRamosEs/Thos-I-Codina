package pregunta02;

public class Client {
	private String id;
	private String nif;
	private String nom;
	private String cognom_1;
	private String cognom_2;
	
	public Client() { }
	public Client(String nif, String nom, String cognom_1, String cognom_2) throws IllegalArgumentException{
		if (nif==null || nom==null || cognom_1==null) {
			throw new IllegalArgumentException("Paràmetre oblicatori no indicat");
		}
		this.nif = nif;
		this.nom = nom;
		this.cognom_1 = cognom_1;
		this.cognom_2 = cognom_2;
	}

	public String getNif() {
		return nif;
	}

	public String getNom() {
		return nom;
	}

	public String getCognom_1() {
		return cognom_1;
	}

	public String getCognom_2() {
		return cognom_2;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setCognom_1(String cognom_1) {
		this.cognom_1 = cognom_1;
	}

	public void setCognom_2(String cognom_2) {
		this.cognom_2 = cognom_2;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nif=" + nif + ", nom=" + nom + ", cognom_1=" + cognom_1 + ", cognom_2="
				+ cognom_2 + "]";
	}
	
	
	
	
}
