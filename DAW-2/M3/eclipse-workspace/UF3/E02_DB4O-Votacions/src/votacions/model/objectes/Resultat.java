package votacions.model.objectes;

import java.util.Objects;

public class Resultat {
	private int vots;
	private double percentatge;
	private Partit partit;
	private Municipi municipi;
	private Comarca comarca;
	private Provincia provincia;
	
	public Resultat(int vots, double percentatge, Partit partit, Municipi municipi, Comarca comarca, Provincia provincia) {
		this.vots = vots;
		this.percentatge = percentatge;
		this.partit = partit;
		this.municipi = municipi;
		this.comarca = comarca;
		this.provincia = provincia;
	}
	
	public int getVots() {
		return vots;
	}
	public double getPercentatge() {
		return percentatge;
	}
	public Partit getPartit() {
		return partit;
	}
	public Municipi getMunicipi() {
		return municipi;
	}
	public Comarca getComarca() {
		return comarca;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setVots(int vots) {
		this.vots = vots;
	}
	public void setPercentatge(double percentatge) {
		this.percentatge = percentatge;
	}
	public void setPartit(Partit partit) {
		this.partit = partit;
	}
	public void setMunicipi(Municipi municipi) {
		this.municipi = municipi;
	}
	public void setComarca(Comarca comarca) {
		this.comarca = comarca;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.comarca, this.municipi, this.partit, this.percentatge, this.provincia, this.vots);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resultat other = (Resultat) obj;
		return Objects.equals(this.comarca, other.getComarca()) && Objects.equals(this.municipi, other.getMunicipi())
				&& Objects.equals(this.partit, other.getPartit())
				&& Double.doubleToLongBits(this.percentatge) == Double.doubleToLongBits(other.getPercentatge())
				&& Objects.equals(this.provincia, other.getProvincia()) && this.vots == other.getVots();
	}

	@Override
	public String toString() {
		return this.vots + " [" + this.percentatge + "], [Partit: " + this.partit + ", Municipi: "
				+ this.municipi.getNom() + ", Comarca: " + this.comarca.getNom() + ", Provincia: " + this.provincia.getNom() + "]";
	}
}
