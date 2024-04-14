package sax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;


/**
 * @author toni
 *
 */
public class SAX implements ContentHandler {
	private String text;
	private List<String> fileNames;
	private String path;
	
	public SAX() {
        fileNames = new ArrayList<>();
    }
	
	public List<String> getFileNames() {
	    return fileNames;
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
		reader.parse(new InputSource(new FileInputStream("src/slider/config.xml")));
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
        case "path":
            this.path = attributes.getValue("file"); // Obtener el valor del path
            break;
        case "arxiu":
            String fileName = attributes.getValue("file"); // Obtener el nombre del archivo
            if (fileName != null && !fileName.isEmpty()) {
                if (this.path != null && !this.path.isEmpty()) { // Asegurarse de que hay un path definido
                	this.fileNames.add(this.path + fileName); // Formar la ruta completa del archivo y agregarlo a la lista
                } else {
                	this.fileNames.add(fileName); // Si no hay un path definido, agregar solo el nombre del archivo
                }
            }
            break;
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
	}

	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub
		
	}
	
}
