package cat.iesthosicodina;

public class Atribut {
	private String nom;
	private String valor;
	
	public Atribut(String nom, String valor) {
		this.nom = nom;
		this.valor = valor;
	}
	public String getNom() {
		return nom;
	}
	public String getValor() {
		return valor;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return this.nom + "=\"" + this.valor + "\"";
	}
	
	

}
