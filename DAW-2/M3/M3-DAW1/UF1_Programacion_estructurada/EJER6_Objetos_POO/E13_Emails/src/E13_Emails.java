/*
 
Programa que gestiona una agenda de emails de contactos. Cada contacto
tiene un nombre y puede tener varios emails.
 
El programa trabaja con un array de objetos de tipo Contacto donde se
guarda esta información. Este array esta inicializado en el código.
 
El programa permite realizar estas dos acciones :
- leer un nombre de contacto y mostrar todos sus emails
- leer un email y mostrar el nombre de contacto al cual pertenece
 
Salida del programa
---------------------------
 
Agenda de emails.
 
1. Ver emails de un contacto.
2. Buscar el propietario de un email.
3. Salir.
 
Elige : 1
 
Entra un nombre : Joan
 
joan@gmail.com
joan@ya.es
 
Agenda de emails.
 
1. Ver emails de un contacto.
2. Buscar el propietario de un email.
3. Salir.
 
Elige : 2
 
Entra un email :anna@gmail.es
 
El propietario es Anna
 
Agenda de emails.
 
1. Ver emails de un contacto.
2. Buscar el propietario de un email.
3. Salir.
 
Elige : 3
 
 
*/


import java.io.*;

class Contacto{
	String nombre;
	String emails[];
	
	Contacto(){
		
	}
	
	Contacto(String n, String e[]){
		nombre = n;
		emails = e;
	}
}

class Contacto2{
	String nombre;
	String email;
	
	Contacto2(){
		
	}
	
	Contacto2(String n, String e){
		nombre = n;
		email = e;
	}
}

public class E13_Emails {

	 public static void main(String[] args) throws IOException {
		 
	        BufferedReader entrada = new BufferedReader(
	            new InputStreamReader(System.in));
	 
	        E13_Emails programa=new E13_Emails();
	         
	        //Inicialización de la agenda
	          
	        //Agenda de la definición 1
	        String mails[]={"joan@gmail.com","joan@ya.es"};
	        Contacto[] agenda = {
	                new Contacto("Joan",mails),
	                new Contacto("Anna",new String[]{"anna@terra.es",
	                        "anna@hotmail.com","anna@gmail.es"})
	                };
	         
	        //Agenda de la definición 2
	        Contacto2[] agenda2 = {
	                new Contacto2("Joan","joan@gmail.com"),
	                new Contacto2("Joan","joan@ya.es"),
	                new Contacto2("Anna","anna@terra.es"),
	                new Contacto2("Anna","anna@hotmail.com"),
	                new Contacto2("Anna","anna@gmail.es")
	                };
	 
	        boolean continuar = true;
	        while(continuar){
	 
	            //Menú de opciones
	 
	            System.out.println("\nAgenda de emails.\n");
	            System.out.println("1. Ver emails de un contacto.");
	            System.out.println("2. Buscar el propietario de un email.");
	            System.out.println("3. Salir.");
	            System.out.print("\nElige : ");
	            char op = entrada.readLine().charAt(0);
	 
	            switch (op){
	                case '1' :
	                    //Ver emails de un contacto
	                    System.out.print("\nEntra un nombre : ");
	                    String nombre = entrada.readLine();
	                    // Busca en la agenda versión 1
	                    programa.buscaMails(agenda, nombre);
	                    // Busca en la agenda versión 2
	                    programa.buscaMails(agenda2, nombre);
	                    break;
	 
	                case '2' :
	                    //Buscar el propietario de un email
	                    System.out.print("\nEntra un email :");
	                    String emailBuscar = entrada.readLine();
	                    // Busca en la agenda versión 1
	                    programa.buscaNombre(agenda, emailBuscar);
	                    // Busca en la agenda versión 2
	                    programa.buscaNombre(agenda2, emailBuscar);
	                    break;
	 
	                case '3':
	                    continuar = false;
	                    break;
	 
	                default:
	 
	                    System.out.println("Opción incorrecta");
	            }
	        }
	    }
	 
	    // Métodos de la versión 1
	    void buscaNombre(Contacto[] agenda, String emailBuscar) {
	        boolean encontrado = false;
	 
	        //Recorrido de los contactos
	        for(int i=0; i<agenda.length; i++) {
	            Contacto contacto=agenda[i];
	            // Recorrido de los emails
	            for (int j=0; j<contacto.emails.length; j++) {
	                if(contacto.emails[j].equalsIgnoreCase(emailBuscar)){
	                    encontrado = true;
	                    System.out.println("\nEl propietario es " + contacto.nombre);
	                }
	            }
	        }
	 
	        if(!encontrado){
	            System.out.println("Email desconocido");
	        }
	    }
	 
	    void buscaMails(Contacto[] agenda, String nombre) {
	        boolean encontrado = false;
	 
	        //Recorrido de los contactos
	        for(int i=0; i<agenda.length; i++) {
	            Contacto contacto=agenda[i];
	            if(contacto.nombre.equalsIgnoreCase(nombre)){
	                encontrado = true;
	                // Recorrido de los emails
	                for (int j=0; j<contacto.emails.length; j++) {
	                    System.out.println(contacto.emails[j]);
	                }
	            }
	        }
	 
	        if(!encontrado){
	            System.out.println("Nombre desconocido");
	        }
	    }
	 
	    // Métodos de la versión 2
	    void buscaNombre(Contacto2[] agenda, String emailBuscar) {
	        boolean encontrado = false;
	 
	        //Recorrido de los contactos
	        for(int i=0; i<agenda.length; i++) {
	            Contacto2 contacto=agenda[i];
	            if(contacto.email.equalsIgnoreCase(emailBuscar)){
	                encontrado = true;
	                System.out.println("\nEl propietario es " + contacto.nombre);
	                break;
	            }
	        }
	 
	        if(!encontrado){
	            System.out.println("Email desconocido");
	        }
	    }
	 
	    void buscaMails(Contacto2[] agenda, String nombre) {
	        boolean encontrado = false;
	 
	        //Recorrido de los contactos
	        for(int i=0; i<agenda.length; i++) {
	            Contacto2 contacto=agenda[i];
	            if(contacto.nombre.equalsIgnoreCase(nombre)){
	                encontrado = true;
	                System.out.println(contacto.email);
	            }
	        }
	 
	        if(!encontrado){
	            System.out.println("Nombre desconocido");
	        }
	    }
	}
