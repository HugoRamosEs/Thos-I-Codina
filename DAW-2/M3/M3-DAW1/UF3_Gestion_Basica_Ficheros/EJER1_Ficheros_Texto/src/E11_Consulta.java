import java.util.Scanner;

/*
Crea un mètode amb identificador referendum que retorni la quantitat
de vots vàlids que conté un fitxer. El mètode tindrà un paràmetre de
tipus String amb el nom del fitxer. A cada línia hi haurà un vot que 
pot ser SI, NO o qualsevol altre cas que seria vot nul. 
Retornarà la quantitat de vots vàlids ( SI o NO).
 
Exemple: (Aquest fitxer conté 10 línies = 10 vots)
SI
NO
NOSÉ
ININDE
MAI
SI
 
NO
SI
NO
 
Resultat: 6
 
*/
import java.util.*;
import java.io.*;

public class E11_Consulta {

	public int referendum(String nomFitxer) {
		String filename = nomFitxer;
		Scanner fichero = null;
		int votsValids = 0;

		try {
			fichero = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.err.println("No existe el fichero: " + filename);
			System.exit(2);
		}

		

		while (fichero.hasNext()) {
			String linia = fichero.nextLine();
			if (linia.equals("SI") || linia.equals("NO")) {
				votsValids = votsValids + 1;
			}
		}
		return votsValids;
	}

	public static void main(String[] args) throws IOException {
		E11_Consulta programa = new E11_Consulta();
		
		System.out.println(programa.referendum("vots.txt"));
	}
}
