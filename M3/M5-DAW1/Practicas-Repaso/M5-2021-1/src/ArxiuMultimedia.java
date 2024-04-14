
public abstract class ArxiuMultimedia extends Arxiu {
	private String nomGrup;
	private String nomCanço;
	
	public ArxiuMultimedia(String nom, String ruta, String nomGrup, String nomCanço) {
		super(nom, ruta);
		this.nomGrup = nomGrup;
		this.nomCanço = nomCanço;
	}

	public String getNomGrup() {
		return nomGrup;
	}

	public void setNomGrup(String nomGrup) {
		this.nomGrup = nomGrup;
	}

	public String getNomCanço() {
		return nomCanço;
	}

	public void setNomCanço(String nomCanço) {
		this.nomCanço = nomCanço;
	}

	@Override
	public String toString() {
		return "ArxiuMultimedia [nom=" + super.getNom() + ", ruta=" + super.getRuta() + ", nomGrup=" + nomGrup + ", nomCanço=" + nomCanço + "]";
	}
}
