package sax;

import java.util.HashMap;
import java.util.HashSet;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Main {
	public static void main(String[] args) {
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			spf.setNamespaceAware(true);
			SAXParser saxParser = spf.newSAXParser();
			SaxHandler handler = new SaxHandler();
			saxParser.parse("src/docs/frases.xml", handler);

			HashMap<String, Autor> autors = handler.getAutors();
			HashSet<Tema> temes = handler.getTemes();
			String nomAutor = "Alighieri, Dante";
			String urlAutor = "/autores/gustavo-adolfo-becquer";
			String nomTema = "Celos";
			
			// Cercar un autor amb NOM (No es la forma més optima)
			boolean autorTrobat = false;
			for (Autor autor : autors.values()) {
				if (autor.getNom().equals(nomAutor)){
					autorTrobat = true;
					System.out.println("Frases de " + autor.getNom() + ":");
					for (Frase frase : autor.getFrases()) {
						System.out.println("- " + frase.getText());
					}
				}
			}
			if (!autorTrobat) {
				System.out.println("Autor no trobat amb el nom: " + nomAutor);
			}

			// Cercar un autor amb URL (Es la forma més optima)
			Autor autorUrl = autors.get(urlAutor);
			if (autorUrl != null) {
				System.out.println("\nFrases de " + autorUrl.getNom() + ":");
				for (Frase frase : autorUrl.getFrases()) {
					System.out.println("- " + frase.getText());
				}
			}else {
				System.out.println("\nAutor no trobat amb l'url: " + urlAutor);
			}
			
			// Cercar un tema amb NOM
			boolean temaTrobat = false;
			for (Tema tema : temes) {
				if (tema.getNom().equals(nomTema)){
					temaTrobat = true;
					System.out.println("\nFrases de " + tema.getNom() + ":");
					for (Frase frase : tema.getFrases()) {
						System.out.println("- " + frase.getText());
					}
				}
			}
			if (!temaTrobat) {
				System.out.println("\nTema no trobat amb el nom: " + nomTema);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
