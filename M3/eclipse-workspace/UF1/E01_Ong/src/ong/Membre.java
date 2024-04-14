package ong;

public class Membre extends Voluntari {

	public Membre(String nom, String cognoms, String dni) {
		super(nom, cognoms, dni);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString() + "[Membre]";
	}



}
