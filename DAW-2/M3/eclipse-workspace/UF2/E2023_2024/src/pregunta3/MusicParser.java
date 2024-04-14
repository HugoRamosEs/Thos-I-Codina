package pregunta3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class MusicParser extends DefaultHandler {
	private Stack<Canso> pila;
	private String text;
	private Canso canso;
	
	public MusicParser() {		
		this.pila = new Stack<Canso>();
		this.text = "";
	}
	
	public Stack<Canso> getPila() {
		return pila;
	}

	public void setPila(Stack<Canso> pila) {
		this.pila = pila;
	}

	public void run(String fitxer) throws FileNotFoundException, IOException, SAXException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		reader.setContentHandler(this);
		reader.parse(new InputSource(new FileInputStream(fitxer)));
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (localName) {
		case "canso":
			this.canso = new Canso(null, null, null, null, null, null, null, null);
			break;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		this.text = new String(ch, start, length);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		String valor = this.text.toString();
		switch (localName) {
		case "titol":
			this.canso.setTitol(valor);
			break;
		case "artista":
			this.canso.setArtista(valor);
			break;
		case "album":
			this.canso.setAlbum(valor);
			break;
		case "durada":
			this.canso.setDurada(valor);
			break;
		case "genere":
			this.canso.setGenere(valor);
			break;
		case "llansament":
			this.canso.setLlansament(valor);
			break;
		case "productor":
			this.canso.setProductor(valor);
			break;
		case "lletra":
			this.canso.setLletra(valor);
			break;
		case "canso":
			this.pila.push(this.canso);
			break;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=this.pila.size() - 1; i>=0; i--) {
			sb.append(this.pila.get(i) + "\n");
		}
		return sb.toString();
	}
}
