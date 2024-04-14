package ong;

public class Administratiu extends Treballador {
	private String oficina;


	public Administratiu(String nom, String cognoms, String dni) {
		super(nom, cognoms, dni);
		// TODO Auto-generated constructor stub
	}

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	@Override
	public String toString() {
		return super.toString()+"Administratiu [oficina=" + oficina + "]";
	}
	
	

}
