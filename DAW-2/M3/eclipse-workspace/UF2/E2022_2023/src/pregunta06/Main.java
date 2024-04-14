package pregunta06;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) {
		try {
            Sax lector = new Sax();
            ConfigDB configuracion = lector.run();

            String xmlFilePath = "src/pregunta06/config.xml";
            Sax handler = new Sax();
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
//            saxParser.parse(new File(xmlFilePath), handler);
            ArrayList<ConfigDB> configList = handler.getConfig();

            for (ConfigDB config : configList) {
                System.out.println("ConfigDB:");
                System.out.println("  DSN: " + config.getDsn());
                System.out.println("  Host: " + config.getHost());
                System.out.println("  Myweb: " + config.getMyweb());
                System.out.println("  Appuser: " + config.getAppuser());
                System.out.println("  Contraseña: " + config.getContrasenya());
            }
        } catch (ParserConfigurationException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error ParserConfigurationException", JOptionPane.ERROR_MESSAGE);
        } catch (SAXException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error SAXException", JOptionPane.ERROR_MESSAGE);
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Error IOException", JOptionPane.ERROR_MESSAGE);
       }
	}

}
