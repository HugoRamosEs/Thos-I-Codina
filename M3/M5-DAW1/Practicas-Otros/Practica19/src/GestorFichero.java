
public class GestorFichero implements Cloneable {
	private Reproducible ficheros[]; // Para asegurar que sean objetos reproducibles, hay que poner la interface Reproduible
	// private static final int MAXIM = 10;
	private static final int MAXIM = 5;
	private int numElements;

	public GestorFichero() {
		this.ficheros = new Fichero[GestorFichero.MAXIM];
		this.numElements = 0;
	}
	
//	public void addFicheroSinLimite (Fichero e) { // Metodo para agregar sin limite
//		Fichero[] tmp = new Fichero[this.ficheros.length + 1];
//		for (int i=0; i<this.ficheros.length; i++) {
//			tmp[i] = this.ficheros[i];
//		}
//		tmp[this.ficheros.length] = e;
//		this.ficheros = tmp;
//	}
	
	public void addFicherosConLimite (Fichero e) throws Exception { // Metodo para agregar con limite
		if (this.numElements == GestorFichero.MAXIM) {
			throw new Exception("Numero máximo alcanzado.");
		}
		this.ficheros[this.numElements] = e; // this.ficheros[this.numElements++] = e;
		this.numElements++; // con lo de arriba comentado, esto no hace falta
	}
	
//	public void removeFicherosSinLimite() { // Este metodo sirve para eliminar el ultimo sin limite de elementos
//		Fichero[] tmp = new Fichero[this.ficheros.length - 1];
//		for (int i=0; i<this.ficheros.length - 1; i++) {
//			tmp[i] = this.ficheros[i];
//		}
//		this.ficheros = tmp;
//	}
	
	public void removeFicherosConLimite() throws Exception { // Este metodo sirve para eliminar el ultimo con un limite de elementos
		if (this.numElements < 0) {
			throw new Exception("No se puede eliminar el ultimo, porque no hay elementos.");
		}
		this.ficheros[this.ficheros.length - 1] = null; // this.ficheros[--this.numElements] = null;
		this.numElements--;
	}
	
	public Reproducible[] getFicheros() {
		return ficheros;
	}

	public static int getMaxim() {
		return MAXIM;
	}

	public int getNumElements() {
		return numElements;
	}

	public void setFicheros(Reproducible[] ficheros) {
		this.ficheros = ficheros;
	}

	public void setNumElements(int numElements) {
		this.numElements = numElements;
	}

	@Override
	public Object clone() { // Tambien se puede poner GestorFichero
		GestorFichero cp = new GestorFichero();
		cp.setFicheros(this.ficheros.clone());
		return cp;
	}
	
//	@Override
//	public Object clone() throws CloneNotSupportedException {
//		GestorFichero copia = (GestorFichero) super.clone();
//
//		copia.ficheros = new Fichero[this.ficheros.length];
//		for (int i = 0; i < this.num; i++) {
//			if (this.ficheros[i] != null) {
//				copia.ficheros[i] = this.ficheros[i].clone(); // Copia profunda de cada fichero
//			}
//		}
//		return copia;
//	}
}
