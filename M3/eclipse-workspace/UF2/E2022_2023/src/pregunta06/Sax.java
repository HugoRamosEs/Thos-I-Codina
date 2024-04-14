package pregunta06;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Sax extends DefaultHandler {
	
	private ArrayList<ConfigDB> config;
	private String text;
	private ConfigDB tmpConfig;
	
	public Sax() {
		this.config = new ArrayList<ConfigDB>();
		this.text = "";
	}
	
	public ConfigDB run() {
		return null;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (localName) {
		case "persistencia":
			this.tmpConfig = new ConfigDB(null, null, null, null, null);
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
		case "dsn":
			this.tmpConfig.setDsn(this.text);
			break;
		case "host":
			this.tmpConfig.setHost(this.text);
			break;
		case "data_base":
			this.tmpConfig.setMyweb(this.text);
			break;
		case "usuari":
			this.tmpConfig.setAppuser(this.text);
			break;
		case "contrasenya":
			this.tmpConfig.setContrasenya(this.text);
			break;
		case "persistencia":
			this.config.add(tmpConfig);
			break;
		}
	}

	public ArrayList<ConfigDB> getConfig() {
		return config;
	}

}
