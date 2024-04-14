package ong;

import java.util.Arrays;

public class Persona {
	private String nom;
	private String cognoms;
	private String dni;
	private String pais;
	private String[] telefons;
	private Adreca[] adreces;
	private String[] mails;
	
	public Persona(String nom, String cognoms, String dni) {
		this.nom = nom;
		this.cognoms = cognoms;
		this.dni = dni;
	}

	public String getNom() {
		return nom;
	}

	public String getCognoms() {
		return cognoms;
	}

	public String getDni() {
		return dni;
	}

	public String getPais() {
		return pais;
	}

	public String[] getTelefons() {
		return telefons;
	}

	public Adreca[] getAdreces() {
		return adreces;
	}

	public String[] getMails() {
		return mails;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setTelefons(String[] telefons) {
		this.telefons = telefons;
	}

	public void setAdreces(Adreca[] adreces) {
		this.adreces = adreces;
	}

	public void setMails(String[] mails) {
		this.mails = mails;
	}

	@Override
	public String toString() {
		return "Persona [nom=" + nom + ", cognoms=" + cognoms + ", dni=" + dni + ", pais=" + pais + ", telefons="
				+ Arrays.toString(telefons) + ", adreces=" + Arrays.toString(adreces) + ", mails="
				+ Arrays.toString(mails) + "]";
	}
	
	
	
	
	
}

