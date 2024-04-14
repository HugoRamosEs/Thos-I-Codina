package cat.iesthosicodina.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class SAX extends DefaultHandler {
	private Noticia news;
	private String text;
	private HashMap<Integer, Noticia> noticies;
	private String rutaDelFitxer;

	public SAX(String rutaDelFitxer) throws FileNotFoundException {
		this.noticies = new HashMap<Integer, Noticia>();
		this.text = "";
		this.rutaDelFitxer = rutaDelFitxer;
	}
	
	public HashMap<Integer, Noticia> getNoticies() {
		return noticies;
	}

	public void setNoticies(HashMap<Integer, Noticia> noticies) {
		this.noticies = noticies;
	}

	public void run() throws SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		reader.setContentHandler(this);
		reader.parse(new InputSource(new FileInputStream(this.rutaDelFitxer)));
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (localName) {
		case "Noticies":
			this.news = new Noticia(null, null, null, null, null, null, null, null, null);
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
		case "id":
			this.news.setId(Integer.parseInt(valor));
			break;
		case "Titol":
			this.news.setTitol(valor);
			break;
		case "Data":
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
				Date date = dateFormat.parse(this.text);
				this.news.setData(date);
			} catch (ParseException e) {
				throw new SAXException("Error en hacer el parser.", e);
			}
			break;
		case "Text":
			this.news.setText(valor);
			break;
		case "Enllac":
			this.news.setEnllac(valor);
			break;
		case "Clau1":
			this.news.setClau(valor);
			break;
		case "Ambitgeografic":
			this.news.setAmbit(valor);
			break;
		case "Entitat1":
			this.news.setEntitat(valor);
			break;
		case "Paraules":
			this.news.setEntitat(valor);
			break;
		case "Noticies":
			this.noticies.put(this.news.getId(), this.news);
			break;
		}
	}
}
