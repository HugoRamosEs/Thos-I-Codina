/**
 * La classe Cotxe representa un cotxe amb un atribut matricula, que es genera automaticament per la classe.
 * Aquesta matricula segueix el format 0000 BBB fins a 9999 ZZZ.
 * 
 * @author hugo ramos
 *
 */

public class Cotxe {
	/*
	 * Atribut que pren el cotxe per la seva matricula. Es de tipus cadena de text (String).
	 */
	private String matricula;
	
	/*
	 * Comptador que conforma el nombre de la matricula, es a dir, 0000 fins a 9999.
	 */
    private static int comptador = 0;
    
    /*
     * Posició de la primera lletra que conforma la matricula.
     */
    private static int lletra1 = 0;
    
    /*
     * Posició de la segona lletra que conforma la matricula.
     */
    private static int lletra2 = 0;
    
    /*
     * Posició de la tercera lletra que conforma la matricula.
     */
    private static int lletra3 = 0;
    
    /*
     * Array que conforma les lletres (consonants) que es poden asignar a la matricula.
     */
    private static char[] consonants = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};
    
    // CONSTRUCTORS
    
    /**
	 * Construeix un nou Coxte.
	 */
    public Cotxe() {
        this.matricula = generadorMatricula();
    }
    
    // MÉTODES PROPIS
    
    /**
     * Genera una matricula de cotxe fent servir un comptador i un conjunt de lletres. Les genera amb el format 0000 BBB fins a 9999 ZZZ.
     * 
     * @return Una cadena de text que representa la matricula generada.
     */
    public String generadorMatricula() {
        String comptadorFormatejat = String.format("%04d", comptador);
        int B = 0;
        int Z = consonants.length - 1;

        if (comptador == 9999 && lletra1 == Z && lletra2 == Z && lletra3 == Z) {
            System.out.println("No n'hi han més matrícules per generar.");
            
        } else if (comptador == 9999 && lletra3 == Z) {
            comptador = 0;
            lletra3 = B;
            if (lletra2 == Z) {
                lletra2 = B;
                if (lletra1 == Z) {
                    lletra1 = B;
                } else {
                    lletra1++;
                }
            } else {
                lletra2++;
            }
        } else if (comptador == 9999) {
            comptador = 0;
            lletra3++;
        } else {
            comptador++;
        }

        return "Matrícula: " + comptadorFormatejat + " " + consonants[lletra1] + consonants[lletra2] + consonants[lletra3];
    }
    
    // GETTERS I SETTERS
    
    public String getMatricula() {
        return matricula;
    }
    
	// OVERRIDES
    
	@Override
	public String toString() {
		return "Matricula: " + this.matricula;
	}
}