package saxStartTag;

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
	
	private Autor tmpAutor;
	private Frase tmpFrase;
	private Tema  tmpTema;
	private String text;

	public SAX() {
		this.autors = 	new ArrayList<Autor>();
		this.frases = 	new ArrayList<Frase>();
		this.temes = 	new ArrayList<Tema>();
	}
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
		switch (localName) {
		case "autor":
			this.tmpAutor = new Autor(attributes.getValue("url"));
			tmpFrase = null;
			tmpTema = null;
			text = "";
			break;
		case "frase":
			this.tmpFrase = new Frase();
			break;
		case "tema":
			this.tmpTema = new Tema();
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
			this.tmpAutor.setNom(this.text);
			break;
		case "descripcion":
			this.tmpAutor.setDescripcio(this.text);
			break;
		case "texto":
			this.tmpFrase.setTexto(this.text);
			break;
		case "autor":
			if (!this.autors.contains(this.tmpAutor)) {
				this.autors.add(this.tmpAutor);
			}
			break;
		case "tema":
			this.tmpTema.setText(this.text);
			if (this.temes.contains(this.tmpTema)) {
				this.tmpTema = this.temes.get(this.temes.indexOf(this.tmpTema));
			} else {
				this.temes.add(this.tmpTema);
			}
			this.tmpFrase.addTema(this.tmpTema);
			
			break;
		case "frase":
			if (this.frases.contains(this.tmpFrase)) {
				this.tmpFrase = this.frases.get(this.frases.indexOf(this.tmpFrase));
			}
			this.tmpAutor.addFrase(this.tmpFrase);
			this.frases.add(this.tmpFrase);
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
