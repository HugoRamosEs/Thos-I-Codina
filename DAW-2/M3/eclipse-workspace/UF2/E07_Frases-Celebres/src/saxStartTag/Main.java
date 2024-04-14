package saxStartTag;

/*
import java.io.FileInputStream;
import java.io.IOException;


import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Iterator;

import javax.swing.JOptionPane;

//import frases.Autor;
//import frases.Frase;
//import frases.Tema;

/**
 * @author toni
 *
 */
public class Main {


	public static void main(String[] args) {
	
		try {
			SAX test = new SAX();		//Creació d'un bojecte SAX
			test.run();					//Càrrega des de fitxer a llistes
			
			System.out.println("Autors: " + test.getAutors().size());
			System.out.println("Frases: " + test.getFrases().size());
			System.out.println("Temes: " + test.getTemes().size());
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en el procés", "Caption", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}
	
}

