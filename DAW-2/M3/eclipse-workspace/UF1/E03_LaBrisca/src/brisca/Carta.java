package brisca;

public abstract class Carta implements Comparable {
	private static final String[] NOMS = {"As", "Dos", "Tres", "Quatre", "Cinc", "Sis", "Set", "Vuit", "Nou", "Sota", "Cavall", "Rei"};
	private static final int[] VALORS = {11, 0, 10, 0, 0, 0, 0, 0, 0, 4, 3, 2}; 
	private Integer numero;

	public Carta(int numero) {
		this.numero = numero;
	}
	
	public int valor() {	
		return Carta.VALORS[this.numero];
	}
				
	public Integer getNumero() {
		return numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public int compareTo(Object obj) {
		if (this == obj)
			return 0;
		if (obj == null)
			throw new NullPointerException ("No es pot comparar amb NULL");
		if (getClass() != obj.getClass())
			throw new ClassCastException ("No es poden comparar objectes de diferents classes");
		Carta other = (Carta) obj;
		return this.numero.compareTo(other.getNumero());
	}

	@Override
	public String toString() {
		return Carta.NOMS[this.numero] + " de ";
	}
}
