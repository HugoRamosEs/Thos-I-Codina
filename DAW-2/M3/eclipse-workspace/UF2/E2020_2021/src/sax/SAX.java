package sax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;


/**
 * @author toni
 *
 */

//Justificació: En este caso solo puede haber elementos unicos con clave y valor, eso solo nos deja non los Map, dentro del los Map en este caso nos da igual que sea ordenado y necesitamos que puedas agregar valores y claves nulas, ja que en ningun caso nos dice que no pueda haver.
public class SAX extends DefaultHandler {
	private String text;
	private HashMap<String, String> parameter;
	String key;

	public SAX() {
		this.parameter = new HashMap<>();
	    this.key = "";
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
			reader.parse(new InputSource(new FileInputStream("src/config.xml")));
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
		case "param":
			this.key=this.text.trim();
			break;
		case "value":
			this.parameter.put(key, this.text.trim());
			break;
		}
	}
	
	 public HashMap<String, String> getParameters() {
	        return this.parameter;
	    }

	
}
