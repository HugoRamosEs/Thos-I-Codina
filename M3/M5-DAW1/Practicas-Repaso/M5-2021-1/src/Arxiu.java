
public class Arxiu implements Reproduible, Cloneable {
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

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	@Override
	public String toString() {
		return "Arxiu [nom=" + nom + ", ruta=" + ruta + "]";
	}

	@Override
	public void reproduir() {
		Arxiu.reproduir(this);
	}
	
	public static void reproduir(Arxiu a) {
		System.out.println("Reproduint-se...");
	}
}
