package sax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import slider.Diapo;

public class SAX extends DefaultHandler {
	private Arxiu arxiu;
	private String path;
	private ArrayList<Arxiu> diapo;
	private String text;
	private String rutaDelFitxer;
	private boolean capturarPath;
	
	/**
	 * Constructor de la classe SAX
	 */
	public SAX(String rutaDelFitxer) {
		this.diapo = new ArrayList<Arxiu>();
		this.text = "";
		this.rutaDelFitxer = rutaDelFitxer;
	}
	
	public ArrayList<Arxiu> getDiapo() {
		return diapo;
	}

	public void setDiapo(ArrayList<Arxiu> diapo) {
		this.diapo = diapo;
	}

	public void run() throws FileNotFoundException, IOException, SAXException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		reader.setContentHandler(this);
		reader.parse(new InputSource(new FileInputStream(this.rutaDelFitxer)));
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (localName) {
		case "path":
			this.capturarPath = true;
		case "arxiu":
			this.arxiu = new Arxiu(null, null);
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
		case "path":
			this.arxiu.setPath("src/slider/imgs/" + valor);
			break;
		case "descripcio":
			this.arxiu.setDescripcio(valor);
			break;
		case "arxiu":
			this.diapo.add(this.arxiu);
			break;
		}
	}
}
