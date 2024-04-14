package arxius;

public class Main {

	public static void main(String[] args) {
		/*
		 * PREGUNTA 6
		 * No es pot definir un cast entre germans.
		 */
		
		GestorArxius gestor = new GestorArxius();
		Bmp bmp = new Bmp("hola.bmp", "/home/hramos/Imagenes/");
		Mp3 mp3 = new Mp3("Lumis.mp3", "/home/hramos/Musica/", "Lumis (Audio)", "hdarken, dummie");
		Mp4 mp4 = new Mp4("Videoclip.mp4", "/home/hramos/Videos/", "Lumis (Videoclip)", "hdarken, dummie");
		
		System.out.println(mp3.toString());
		
		gestor.add(mp4);
		gestor.add(bmp);
		gestor.add(mp3);
		gestor.remove();
		
		System.out.println(gestor.toString());
		
	}
}
