package sax;

import java.util.HashMap;
import java.util.HashSet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {
	private Autor autor;
	private Frase frase;
	private Tema tema;
	private StringBuilder contingut;
	private HashSet<Tema> temes;
	private HashMap<String, Autor> autors;
	
	/**
	 * He escollit HashMap per emmagatzemar els autors per l'eficiència de la cerca que ofereix aquesta estructura. Cada autor té associada una URL única que pot utilitzar-se 
	 * com a clau en el mapa. La avantatge d'aquesta elecció respecte a altres coleccions resideix en la capacitat de realitzar cerques extremadament ràpides d'elements mitjançant 
	 * la seva URL, ja que l'accés a un element en un HashMap té una complexitat de temps constant en mitjana (O(1)).  A més, l'ús de HashMap no compromet la velocitat d'inserció o 
	 * eliminació d'elements, ja que aquestes operacions, en aquesta colecció, també tenen un temps constant en mitjana.
	 * 
	 * En resum, HashMap proporciona un equilibri òptim entre rapidesa en les cerques (aprofitant l'url) i eficiència en la gestió dinàmica de dades, fent que sigui una elecció adequada 
	 * en aquest cas.
	 */

	public SaxHandler() {
		this.temes = new HashSet<Tema>();
		this.autors = new HashMap<String, Autor>();
	}

	public HashSet<Tema> getTemes() {
		return temes;
	}
	public HashMap<String, Autor> getAutors() {
		return autors;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		this.contingut = new StringBuilder();
		
		if ("autor".equals(qName)) {
			this.autor = new Autor();
			this.autor.setUrl(attributes.getValue("url"));
		}else if ("frase".equals(qName)) {
			this.frase = new Frase();
		}else if ("tema".equals(qName)) {
			this.tema = new Tema();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		this.contingut.append(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		String valor = this.contingut.toString();
		switch (qName) {
		case "nombre":
			if (this.autor != null) {
				this.autor.setNom(valor);
			}
			break;
		case "descripcion":
			if (this.autor != null) {
				this.autor.setDescripcio(valor);
			}
			break;
		case "texto":
			if (this.frase != null) {
				this.frase.setText(valor);
			}
			break;
		case "tema":
			if (this.tema != null) {
				this.tema.setNom(null);
				for (Tema tema : temes) {
					if (this.tema.getNom() == null && tema.getNom().equals(valor)) {
						this.tema = tema;
					}
				}
				if (this.tema.getNom() == null) {
					this.tema.setNom(valor);
					this.temes.add(this.tema);
				}
			}
			break;
		case "frase":
			if (this.autor != null) {
				if (this.tema != null) {
					this.frase.setTema(this.tema);
					this.tema.getFrases().add(this.frase);
				}
				this.autor.getFrases().add(this.frase);
			}
			break;
		case "autor":
			if (this.autor != null) {
				this.autors.put(this.autor.getUrl(), this.autor);
				this.autor = null;
			}
			break;
		}
	}
}
