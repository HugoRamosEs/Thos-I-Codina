package saxEndTag;

import java.util.ArrayList;

public class Autor {
	private String nom;
	private String descripcio;
	private String url;
	private ArrayList<Frase> frases; 
	
	// constructor
	public Autor(String url) {
		this.url = url;
		this.frases = new ArrayList<Frase>();
	}

	// getters i setters
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nombre) {
		this.nom = nombre;
	}

	public String getDescripcio() {
		return this.descripcio;
	}

	public void setDescripcio(String desc) {
		this.descripcio = desc;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ArrayList<Frase> getFrases() {
		return frases;
	}

	public void setFrases(ArrayList frases) {
		this.frases = frases;
	}
	
	public void addFrase(Frase f) {
		this.frases.add(f);
	}

	@Override
	public String toString() {
		String cadena = "Autor [mombre=" + nom + ", desc=" + descripcio + ", url=" + url	+ "]\n";
		cadena += "Frases: \n";
		for (Frase f:this.frases) {
			cadena += "   - " + f.toString() + "\n";
		}
		cadena += "\n";
		return cadena;
	}

}
