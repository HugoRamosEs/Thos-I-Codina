package cat.iesthosicodina;

import java.util.Arrays;

public abstract class Element {
	protected String tag;
	protected Atribut[] atributs;
	protected Element[] contingut;
	
	public String getTag() {
		return tag;
	}

	public Atribut[] getAtributs() {
		return atributs;
	}

	public Element[] getContingut() {
		return contingut;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setAtributs(Atribut[] atributs) {
		this.atributs = atributs;
	}

	public void setContingut(Element[] contingut) {
		this.contingut = contingut;
	}

	@Override
	public String toString() {
		String resultat="";
		// Definim l'etiqueta d'inici, si n'hi ha.
		if (this.tag != null) {
			resultat = "<" + this.tag;
			// afegim atributs, si n´hi ha
			if (this.atributs != null) {
				for (Atribut at : this.atributs) {
					resultat += " " + at.toString();
				}
			}
			// Si no hi ha contingut, afegin una etiqueta
			// auto-ancada
			resultat += (this.contingut == null) ? "/>" : ">";
		}
		
		// Si hi ha contingut, afegim el contingut i tamquem l'etiqueta
		if (this.contingut != null) {
			for (Element el : this.contingut) {
				resultat += el.toString();
			}
			resultat += "</" + this.tag + ">";
		}

		return resultat;
	}

}
