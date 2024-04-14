package arxius;

public abstract class Arxiu implements Reproduible, Cloneable {
	private String nom;
	private String ruta;
	
	public Arxiu(String nom, String ruta) {
		super();
		this.nom = nom;
		this.ruta = ruta;
	}
	
	public String getNom() {
		return nom;
	}

	public String getRuta() {
		return ruta;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	@Override
	public String toString() {
		return "Arxiu: " + this.nom + "\n"
				+ "Ruta: " + this.ruta + "\n";
	}

	@Override
	public void reproduir() {
		Arxiu.reproduirArxiu();
	}
	
	public static String reproduirArxiu() {
		return "Repoduint-se...";
		
	}

}
