package cat.iesthosicodina.controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.xml.sax.SAXException;

import cat.iesthosicodina.model.Noticia;
import cat.iesthosicodina.model.SAX;

// HashMap: nos iteneresa mucho el poder tener el metodo clave / valor que proporciona Map, 
// ya que cada noticia tiene su propio id. Nos da igual que el orden y por no poder tener
// claves duplicadas.

public class CollectionManager {
	private HashMap<Integer, Noticia> collection;
	
	public CollectionManager() {
		this.collection = new HashMap<Integer, Noticia>();
	}
	
	public void getNews() throws SAXException, IOException {
		SAX reader = new SAX("src/dades/noticies.xml");
		reader.run();
		this.collection = reader.getNoticies();
	}

	public HashMap<Integer, Noticia> getCollection() {
		return collection;
	}

	@Override
	public String toString() {
		String result = "";
		
	    Iterator<Noticia> it= this.collection.values().iterator();
	    while(it.hasNext()) {	      
	      result += it.next().toString()+"\n";
	    }
		
		return result;
	}

	
	
}
