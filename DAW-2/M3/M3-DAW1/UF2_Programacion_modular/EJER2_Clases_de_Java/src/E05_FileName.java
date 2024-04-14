/*
 
Escribe los métodos que faltan 
 
*/
 
public class E05_FileName {
	
	
	public static String getFileName(String arxiu) {
		String fileName="";
		int posicio = arxiu.lastIndexOf('/');
		if (posicio>=0) {
			fileName = arxiu.substring(posicio+1);
		}else {
			fileName = arxiu;
		}
		return fileName;
	}
	
	public static String getExtension(String arxiu) {
		String fileName = getFileName(arxiu);
		String extensio = "";
		int posicio = fileName.lastIndexOf('.');
		if (posicio>=0) {
			extensio = fileName.substring(posicio+1);
		}else {
			extensio="";
		}
		return extensio;
	}
	
	public static String getFileNameWithoutExtension(String arxiu) {
		String fileName = getFileName(arxiu);
		int posicio = fileName.lastIndexOf('.');
		if (posicio>=0) {
			fileName = fileName.substring(0, posicio);
		}
		return fileName;
	}
	
    public static void main(String[] args) {
 
        String file = "/home/usuario/foto.png";
        System.out.println(getFileName(file));    //muestra foto.png
        System.out.println(getExtension(file)); //muestra png
        System.out.println(getFileNameWithoutExtension(file)); //muestra foto
 
    }
 
}
