
public class Multimedia extends Fichero {
	private String nombreGrupo;
	private String nombreCancion;
	
	
	public Multimedia(String nombre, String ruta, String nombreGrupo, String nombreCancion) {
		super(nombre, ruta);
		this.nombreGrupo = nombreGrupo;
		this.nombreCancion = nombreCancion;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + ", " + this.nombreGrupo + ", " + this.nombreCancion;
	}
}
