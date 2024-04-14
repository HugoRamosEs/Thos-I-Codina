package votacions.model.objectes;

import java.util.Objects;

public class Partit {
	private String nom;
	private String sigles;
	
	public Partit(String nom, String sigles) {
		this.nom = nom;
		this.sigles = sigles;
	}

	public String getNom() {
		return nom;
	}
	public String getSigles() {
		return sigles;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setSigles(String sigles) {
		this.sigles = sigles;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.nom, this.sigles);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partit other = (Partit) obj;
		return Objects.equals(this.nom, other.getNom()) && Objects.equals(this.sigles, other.getSigles());
	}

	@Override
	public String toString() {
		return this.nom + " [" + this.sigles + "]";
	}
}
