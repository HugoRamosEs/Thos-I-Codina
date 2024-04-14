/*
 
Programa que dispone de un array de 4 objetos del tipo Usuario.
Cada usuario dispone de un login, un password y puede estar habilitado o no.
El array se inicializa en el c�digo y el programa se limita a realizar una validaci�n
del usuario pidiendo login y password y mostrando uno de estos mensajes :
"Login incorrecto", "Password incorrecto", "Usuario deshabilitado" o "Usuario validado".
 
 
Salida delprograma
-------------------------------------------
Nombre de usuario: paquito
Password: qwerty
El nombre de usuario no existe
 
Nombre de usuario: pitufo
Password: 123456
Password incorrecto
 
Nombre de usuario: pitufo
Password: 112233
Usuario validado.
 
El programa podria continuar ....
 
*/

import java.util.Scanner;

class Usuario{
	String login;
	String password;
	boolean habilitado;
	
	Usuario(){
		
	}
	
	Usuario (String l, String p, boolean h){
		login = l;
		password = p;
		habilitado = h;
	}
	
	public String toString() {
		return ("Login: " +login+ " / Contraseña: " +password+ " / Estado: " +habilitado);
	}
}

public class E08_Logins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		
		Usuario[] usuarios = new Usuario [4];
			usuarios[0] = new Usuario();
			usuarios[0].login = "hugo";
			usuarios[0].password = "1234";
			usuarios[0].habilitado = true;
			
			usuarios[1] = new Usuario();
			usuarios[1].login = "antonio";
			usuarios[1].password = "4321";
			usuarios[1].habilitado = false;
			
			usuarios[2] = new Usuario();
			usuarios[2].login = "hector";
			usuarios[2].password = "1243";
			usuarios[2].habilitado = false;
			
			usuarios[3] = new Usuario();
			usuarios[3].login = "alex";
			usuarios[3].password = "2134";
			usuarios[3].habilitado = true;
		
		boolean valido = false;
		int intentos = 0;
		boolean continuar = true;
		
		while(continuar && intentos<5) {
			System.out.println("Nombre de usuario: ");
			String login = entrada.next();
			
			System.out.println("Contraseña: ");
			String password = entrada.next();
			
			int i=0;
			while (i<usuarios.length && !login.equals(usuarios[i].login)) {
				i++;
			}
			
			if (i==usuarios.length) {
                System.out.println("Nombre incorrecto");
            } else if (!password.equals(usuarios[i].password)) {
                System.out.println("Contraseña incorrecta");
            } else if (!usuarios[i].habilitado) {
                System.out.println("Usuario deshabilitado.");
                continuar = false;
            } else {
                System.out.println("Usuario validado.");
                valido = true;
                continuar = false;
            }
			
			intentos++;
		}
		
		if(valido) {
			System.out.println("El programa continua...");
		}else {
			System.out.println("Demasiados intentos.");
		}
	}

}
