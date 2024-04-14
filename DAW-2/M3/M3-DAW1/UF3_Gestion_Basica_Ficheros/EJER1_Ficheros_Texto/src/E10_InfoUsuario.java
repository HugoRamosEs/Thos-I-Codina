/*
E10_InfoUsuario
 
Programa que pide un nombre de usuario y muestra información sobre su cuenta. Por ejemplo :
 
Nombre de usuario : mariano
UID : 1000
GID : 1000
Información : mariano,,,
Directorio personal : /home/mariano
Shell : /bin/bash
Grupos : mariano,adm,cdrom,sudo,dip,plugdev,lpadmin,sambashare
 
Esta información debe obtenerse leyendo el archivo /etc/passwd y el fichero /etc/group
 
 */

import java.util.*;
import java.io.*;

public class E10_InfoUsuario {

	public static void main(String[] args) throws IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		Scanner file = null;
		Scanner file2 = null;
		String filename = ("/etc/passwd");
		String filename2 = ("/etc/group");
		String uid = "";
		String gid = "";
		String nombre = "";
		String home = "";
		String shell = "";
		String grupoPrincipal = "";
		String gruposSec = "";
		boolean encontrado = false;

		System.out.print("Entra el nombre del usuario : ");
		String usuario = entrada.readLine();

		try {
			file = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.err.println("No existeix el fitxer " + filename);
		}

		try {
			file2 = new Scanner(new File(filename2));
		} catch (FileNotFoundException e) {
			System.err.println("No existeix el fitxer " + filename2);
		}

		while (file.hasNext()) {
			String linea = file.nextLine();
			if (linea.startsWith(usuario + ":")) {
				String[] partes = linea.split(":");
				uid = partes[2];
				gid = partes[3];
				nombre = partes[4];
				home = partes[5];
				shell = partes[6];
				encontrado = true;
				break;
			}
		}
		file.close();
		
		System.out.println("UID: " + uid);
        System.out.println("GID: " + gid);
        System.out.println("Nombre: " + nombre);
        System.out.println("Home: " + home);
        System.out.println("Shell: " + shell);
	}
}
