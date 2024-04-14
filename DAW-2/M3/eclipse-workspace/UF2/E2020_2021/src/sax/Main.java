package sax;

import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		try {
			SAX saxHandler = new SAX();
			saxHandler.run();
			HashMap<String, String> parameters = saxHandler.getParameters();

			// Aquí pots fer el que vulguis amb els paràmetres (imprimir, accedir, etc.)
			System.out.println(parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
