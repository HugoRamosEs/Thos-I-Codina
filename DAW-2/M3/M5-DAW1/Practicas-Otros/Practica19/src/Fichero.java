
public class Fichero implements Reproducible, Cloneable {
	private String nombre;
	private String ruta;
	
	public Fichero(String nombre, String ruta) {
		this.nombre = nombre;
		this.ruta = ruta;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getRuta() {
		return ruta;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String toString() {
		return "Fichero: " + this.nombre + "," + this.ruta;
	}
	
	@Override
	public void reproducir() { // Llama al estatico
		// TODO Auto-generated method stub
		Fichero.reproduir(this);
	}
	
	public static void reproduir(Reproducible e) { // Metodo estatico de una clase
		System.out.println("Reproduciendo...");
	}

	@Override
    public Fichero clone() throws CloneNotSupportedException {
        return (Fichero) super.clone();
    }
	
}
