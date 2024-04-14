package saxEndTag;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

//import frases.Autor;
//import frases.Frase;
//import frases.Tema;

/**
 * @author toni
 *
 */
public class SAX extends DefaultHandler {

	//Camps per compartir valors entre tots els mètodes
	private ArrayList<Autor> autors;		//Col.lecció per emmagatzemar els autors que vagi creant.
	private ArrayList<Frase> frases;		//Col.lecció per emmagatzemar les frases que vagi creant.
	private ArrayList<Tema> temes;			//Col.lecció pen enmagatzemar els temes que vagi creant.
	
	private String text;

	private String tmpNom;
	private String tmpDescripcio;
	private String tmpUrl;
	private ArrayList<Frase> tmpFrases;
	
	private String tmpTexto;
	private ArrayList<Tema> tmpTemes;

	/**
	 * Mètode principal des d'on es carrega el fitxer xml.
	 * Sel.lecciona la font des d'on es llegeix el fitxer i activa els events per realitzar la
	 * lectura. 
	 * @return no retorna res.
	 * 
	 * @throws SAXException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void run() throws SAXException, FileNotFoundException, IOException {
		this.autors = 	new ArrayList<Autor>();
		this.frases = 	new ArrayList<Frase>();
		this.temes = 	new ArrayList<Tema>();

		XMLReader reader = XMLReaderFactory.createXMLReader();
		reader.setContentHandler(this);
		reader.parse(new InputSource(new FileInputStream("src/frases/frases.xml")));
	}
	
	/**
	 * @param uri 			- The Namespace URI, or the empty string if the element has no Namespace URI or if Namespace processing is not being performed.
	 * @param localName 	- The local name (without prefix), or the empty string if Namespace processing is not being performed.
	 * @param qName 		- The qualified name (with prefix), or the empty string if qualified names are not available.
	 * @param attributes	- The attributes attached to the element. If there are no attributes, it shall be an empty Attributes object.
	 * @throws SAXException
	 */
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (localName == "autor") {
			this.tmpUrl = attributes.getValue("url");
			this.tmpNom = "";
			this.tmpDescripcio = "";
			this.tmpFrases = null;
			this.tmpTemes = null;
		} else if (localName == "frase") {
			this.tmpTemes=new ArrayList<Tema>();
		} else if (localName == "frases") {
			this.tmpFrases=new ArrayList<Frase>();
		}
	}

	/**
	 * @param ch			- The characters.
	 * @param start			- The start position in the character array.
	 * @param length		- The number of characters to use from the character array. 
	 * @throws SAXException
	 */

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		this.text = new String(ch, start, length);
	}

	/**
	 * @param uri 			- The Namespace URI, or the empty string if the element has no Namespace URI or if Namespace processing is not being performed.
	 * @param localName 	- The local name (without prefix), or the empty string if Namespace processing is not being performed.
	 * @param qName 		- The qualified name (with prefix), or the empty string if qualified names are not available.
	 * @throws SAXException
	 */

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (localName) {
		case "nombre":
			this.tmpNom=this.text;
			break;
		case "descripcion":
			this.tmpDescripcio=this.text;
			break;
		case "texto":
			this.tmpTexto=this.text;
			break;
		case "autor":
			Autor oAutor = new Autor(this.tmpUrl);
			oAutor.setDescripcio(this.tmpDescripcio);
			oAutor.setNom(this.tmpNom);
			oAutor.setFrases(this.tmpFrases);
			if (!this.autors.contains(oAutor)) {
				this.autors.add(oAutor);
			}
			break;
		case "tema":
			Tema oTema = new Tema(this.text);
			if (this.temes.contains(oTema)) {
				oTema = this.temes.get(this.temes.indexOf(oTema));
			} else {
				this.temes.add(oTema);
			}
			this.tmpTemes.add(oTema);
			
			break;
		case "frase":
			Frase oFrase = new Frase(this.tmpTexto);
			oFrase.setTemes(this.tmpTemes);
			if (this.tmpTemes.size()>1) {
				System.out.println(oFrase.toString());
			}
			if (this.frases.contains(oFrase)) {
				oFrase = this.frases.get(this.frases.indexOf(oFrase));
			}
			this.tmpFrases.add(oFrase);
			this.frases.add(oFrase);
			break;
		}
	}
	
	public ArrayList<Autor> getAutors() {
		return this.autors;
	}

	public ArrayList<Frase> getFrases() {
		return this.frases;
	}

	public ArrayList<Tema> getTemes() {
		return this.temes;
	}
}
