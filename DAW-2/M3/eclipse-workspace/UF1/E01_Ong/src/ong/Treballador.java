package ong;

public class Treballador extends Persona {
	private String nass;
	private float souBrut;
	
	public Treballador(String nom, String cognoms, String dni) {
		super(nom, cognoms, dni);
		// TODO Auto-generated constructor stub
	}

	public String getNass() {
		return nass;
	}

	public float getSouBrut() {
		return souBrut;
	}

	public void setNass(String nass) {
		this.nass = nass;
	}

	public void setSouBrut(float souBrut) {
		this.souBrut = souBrut;
	}

	@Override
	public String toString() {
		return super.toString() + "Treballador [nass=" + nass + ", souBrut=" + souBrut + "]";
	}

	
}
