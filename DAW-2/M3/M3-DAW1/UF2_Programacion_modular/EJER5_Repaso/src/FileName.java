/*
 
Escribe los métodos que faltan 
 
*/

public class FileName {
	
	public static String getFileName(String ruta) {
		String archivo = "";
		int pos = ruta.lastIndexOf("/");
		archivo = ruta.substring(pos + 1);
		return archivo;
	}
	
	public static String getExtension(String ruta) {
		String extension = "";
		int pos = ruta.lastIndexOf(".");
		extension = ruta.substring(pos+1);
		return extension;
	}
	
	public static String getFileNameWithoutExtension(String ruta) {
		String archivoSinExtension = "";
		int pos = ruta.lastIndexOf("/");
		int punto = ruta.lastIndexOf(".");
		archivoSinExtension = ruta.substring(pos + 1 , punto);
		return archivoSinExtension;
	}
	
	public static void main(String[] args) {
		String file = "/home/usuario/foto.png";
        System.out.println( getFileName(file) );    //muestra foto.png
        System.out.println( getExtension(file) ); //muestra png
        System.out.println( getFileNameWithoutExtension(file) ); //muestra foto
	}
}
