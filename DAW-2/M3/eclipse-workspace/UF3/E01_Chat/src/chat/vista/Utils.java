package chat.vista;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Classe d'utilitats per a la vista.
 * 
 * @version 1.0
 * @author Hugo
 */
public class Utils {
	
	/**
	 * Mètode que permet escollir l'estil de la font amb el valor numèric representatiu.
	 * 
	 * @param estil Estil de la font.
	 * @return Valor numèric de l'estil de la font.
	 */
	public static int styleFont(String estil) {
		switch (estil.toLowerCase()) {
		case "plain":
			return Font.PLAIN;
		case "bold":
			return Font.BOLD;
		case "italic":
			return Font.ITALIC;
		case "bolditalic":
			return Font.BOLD | Font.ITALIC;
		default:
			return Font.PLAIN;
		}
	}

	/**
	 * Mètode que carrega una font personalitzada.
	 * 
	 * @param estil Estil de la font.
	 * @param tamany Tamany de la font.
	 * @return Font Tipus de lletra personalitzat.
	 */
	public static Font loadFont(String estil, int tamany) {
		try (InputStream is = Utils.class.getResourceAsStream("/chat/vista/resources/Helvetica-Now-Var.ttf")) {
			return Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Utils.styleFont(estil), tamany);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
			return new Font("Arial", Utils.styleFont(estil), tamany);
		}
	}
}
