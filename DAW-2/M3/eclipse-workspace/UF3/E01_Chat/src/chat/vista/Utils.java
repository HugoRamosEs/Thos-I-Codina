package chat.vista;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class Utils {
	
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

	public static Font loadFont(String estil, int tamany) {
		try (InputStream is = Utils.class.getResourceAsStream("/chat/vista/resources/Helvetica-Now-Var.ttf")) {
			return Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Utils.styleFont(estil), tamany);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
			return new Font("Arial", Utils.styleFont(estil), tamany);
		}
	}
}
