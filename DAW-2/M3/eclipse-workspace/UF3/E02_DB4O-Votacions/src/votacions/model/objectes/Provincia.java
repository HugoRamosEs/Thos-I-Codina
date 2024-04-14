package votacions.model.objectes;

import java.util.Objects;

public class Provincia {
	private String nom;
	
	public Provincia(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Provincia other = (Provincia) obj;
		return Objects.equals(this.nom, other.getNom());
	}

	@Override
	public String toString() {
		return this.nom;
	}
}
