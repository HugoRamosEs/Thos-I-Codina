package cat.iesthosicodina.model;

import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

//  		textField.setAlignmentY(Component.CENTER_ALIGNMENT);


public class SAX extends DefaultHandler {
	private HashMap<Integer, Noticia> news;
	private String text;
	
	private Noticia tmpNews;

	public SAX(String rutaDelFitxer) throws FileNotFoundException {
		this.news = new HashMap<Integer, Noticia>();
		this.text = "";
	}

	public void run() throws SAXException, IOException {	
		XMLReader reader = XMLReaderFactory.createXMLReader();
		reader.setContentHandler(this);
		reader.parse(new InputSource(new FileInputStream("src/dades/noticies.xml")));
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (localName) {
		case "Noticies":
			this.tmpNews = new Noticia();
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		this.text = new String(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (localName) {
		case "id":
			this.tmpNews.setId(Integer.parseInt(this.text));
			break;
		case "Titol":
			this.tmpNews.setTitol(this.text);
			break;
		case "Data":
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
				Date date = dateFormat.parse(this.text);
				this.tmpNews.setData(date);
			} catch (ParseException e) {
				throw new SAXException("Error en hacer el parser.", e);
			}
			break;
		case "Text":
			this.tmpNews.setText(this.text);
			break;
		case "Enllac":
			this.tmpNews.setEnllac(this.text);
			break;
		case "Clau":
			this.tmpNews.setClau(this.text);
			break;
		case "Ambitgeografic":
			this.tmpNews.setAmbit(this.text);
			break;
		case "Entitat":
			this.tmpNews.setEntitat(this.text);
			break;
		case "Paraules":
			this.tmpNews.setParaules(this.text);
			break;
		case "Noticies":
			this.news.put(this.tmpNews.getId(), tmpNews);
			break;
		}
	}
	
	public HashMap<Integer, Noticia> getNoticies() {
		return this.news;
	}
	
}
