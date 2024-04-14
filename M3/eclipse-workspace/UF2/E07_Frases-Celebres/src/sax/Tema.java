package sax;

import java.util.ArrayList;

public class Tema {
	private String nom;
	private ArrayList<Frase> frases;
	
	public Tema() {
		this.frases = new ArrayList<Frase>();
	}
	
	public String getNom() {
		return nom;
	}
	public ArrayList<Frase> getFrases() {
		return frases;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setFrases(ArrayList<Frase> frases) {
		this.frases = frases;
	}
}
