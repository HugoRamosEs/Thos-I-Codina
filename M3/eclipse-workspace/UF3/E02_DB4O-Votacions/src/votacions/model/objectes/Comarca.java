package votacions.model.objectes;

import java.util.Objects;

public class Comarca {
	private String nom;
	private Provincia provincia;
	
	public Comarca(String nom, Provincia provincia) {
		this.nom = nom;
		this.provincia = provincia;
	}

	public String getNom() {
		return nom;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.nom, this.provincia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comarca other = (Comarca) obj;
		return Objects.equals(this.nom, other.getNom()) && Objects.equals(this.provincia, other.getProvincia());
	}

	@Override
	public String toString() {
		return this.nom + " [Provincia: " + this.provincia + "]";
	}
}
