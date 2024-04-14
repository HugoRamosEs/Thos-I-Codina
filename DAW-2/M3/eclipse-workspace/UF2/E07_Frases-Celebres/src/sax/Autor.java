package sax;

import java.util.ArrayList;

public class Autor {
	private String url;
	private String nom;
	private String descripcio;
	private ArrayList<Frase> frases;
	
	public Autor() {
		this.frases = new ArrayList<Frase>();
	}

	public String getUrl() {
		return url;
	}
	public String getNom() {
		return nom;
	}
	public String getDescripcio() {
		return descripcio;
	}
	public ArrayList<Frase> getFrases() {
		return frases;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	public void setFrases(ArrayList<Frase> frases) {
		this.frases = frases;
	}
}
