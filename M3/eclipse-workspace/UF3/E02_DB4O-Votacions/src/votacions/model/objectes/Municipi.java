package votacions.model.objectes;

import java.util.Objects;

public class Municipi {
	private String nom;
	private Comarca comarca;
	private Provincia provincia;
	
	public Municipi(String nom, Comarca comarca, Provincia provincia) {
		this.nom = nom;
		this.comarca = comarca;
		this.provincia = provincia;
	}
	
	public String getNom() {
		return nom;
	}
	public Comarca getComarca() {
		return comarca;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setComarca(Comarca comarca) {
		this.comarca = comarca;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.comarca, this.nom, this.provincia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Municipi other = (Municipi) obj;
		return Objects.equals(this.comarca, other.getComarca()) && Objects.equals(this.nom, other.getNom())
				&& Objects.equals(this.provincia, other.getProvincia());
	}

	@Override
	public String toString() {
		return this.nom + " [Comarca: " + this.comarca.getNom() + ", Provincia: " + this.provincia.getNom() + "]";
	}
}
