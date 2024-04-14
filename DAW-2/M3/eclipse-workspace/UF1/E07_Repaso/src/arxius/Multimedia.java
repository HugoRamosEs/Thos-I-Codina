package arxius;

public abstract class Multimedia extends Arxiu {
	private String nomGrup;
	private String nomCanço;
	
	public Multimedia(String nom, String ruta, String nomGrup, String nomCanço) {
		super(nom, ruta);
		this.nomGrup = nomGrup;
		this.nomCanço = nomCanço;
	}
	
	public String getNomGrup() {
		return nomGrup;
	}

	public String getNomCanço() {
		return nomCanço;
	}

	public void setNomGrup(String nomGrup) {
		this.nomGrup = nomGrup;
	}

	public void setNomCanço(String nomCanço) {
		this.nomCanço = nomCanço;
	}

	@Override
	public String toString() {
		return super.toString()
				+ "Nom Grup: " + nomGrup + "\n"
				+ "Nom Canço: " + nomCanço + "\n";
	}
}
