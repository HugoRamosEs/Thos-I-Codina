
public class Ejercicios_Restantes_Arrays {

}

// E17_ELIMINA_VALORES
//Programa que trabaja con un array de 10 enteros ordenados en orden
//creciente inicializado en el código del programa.
// 
//El usuario entra un valor, el programa lo busca en el array y
//si lo encuentra lo elimina. No es necesario validar las entradas.
// 
//Esta búsqueda debe optimizarse teniendo en cuenta que se trata de un
//array ordenado.
// 
//Al eliminar un valor los que le siguen deben desplazarse para dejar
//el espacio libre al final
// 
//Repetir hasta que se hayan eliminado todos.
// 
// 
//Salida del programa
//-----------------------------
// 
//Códigos :  122 232 234 376 455 583 766 812 895 933
//Entra un código per eliminar: 232
//Código eliminado. Quedan 9
// 
//Códigos :  122 234 376 455 583 766 812 895 933
//Entra un código para eliminar: 333
//El código 333 no existe.
// 
//Códigos :  122 234 376 455 583 766 812 895 933
//Entra un codigo para eliminar: 1000
//El codigo 1000 no existe.
// 
//Códigos :  122 234 376 455 583 766 812 895 933
//Entra un código para eliminar: 455
//Código eliminado. Quedan 8
// 
//Códigos :  122 234 376 583 766 812 895 933
//Entra un código para eliminar:
// 
//....(continua)....
// 
//*/
// 
//import java.io.*;
// 
//public class E17_EliminaValores {
// 
//    public static void main(String[] args) throws Exception {
// 
//        BufferedReader entrada = new BufferedReader(
//            new InputStreamReader(System.in));
// 
//        int[] codigos = { 122, 232, 234, 376, 455, 583, 766, 812, 895, 933 };
// 
//        int cantidad = codigos.length; //códigos que tenemos en el array
// 
//        while (cantidad > 0) {
// 
//            //Mostrar los códigos
// 
//            System.out.print("\nCódigos : ");
//            for (int i=0; i<cantidad; i++) {
//                System.out.print(" " + codigos[i]);
//            }
// 
//            //Pedir un código
// 
//            System.out.print("\nEntra un código para eliminar: ");
//            int n = Integer.parseInt(entrada.readLine());
// 
//            //Buscar su posicion
// 
//            int pos = -1;  // pos == -1 indica que no se ha encontrado
//            int i=0;
//            while( i < cantidad && n >= codigos[i] ) {
//                if( n == codigos[i] ) pos = i;
//                i++;
//            }
// 
//            if (pos==-1) {
//                //Código no encontrado
//                System.out.printf("El código %d no existe.\n", n);
//            }else{
//                //Desplazamiento de los códigos posteriores
//                //   j-1  <---  j
//                for (int j=pos+1; j< cantidad; j++) {
//                    codigos[j-1] = codigos[j];
//                }
// 
//                //Actualización del contador
//                cantidad--;
//                System.out.printf("Código eliminado. Quedan %d\n", cantidad);
// 
//            }
//        }
// 
//        System.out.println("Se han eliminado todos los códigos.\n");
// 
//    }
//}



// E18_ELIGE_PRIMERO

//Programa que cuenta con un array de 6 nombres y se los muestra al
//usuario en forma de lista numerada. Este debe elegir uno introduciendo
//su número y el programa lo mueve a la primera posición conservando el
//orden relativo de los restantes.
// 
//Repetir esta operación hasta que el usuario introduzca un -1
// 
// 
//Salida del programa
//-----------------------------------
//1 - Mar
//2 - Isabel
//3 - Ivan
//4 - Pol
//5 - Eva
//6 - Ruth
// 
//Elige uno : 2
// 
//1 - Isabel
//2 - Mar
//3 - Ivan
//4 - Pol
//5 - Eva
//6 - Ruth
// 
//Elige uno : 4
// 
//1 - Pol
//2 - Isabel
//3 - Mar
//4 - Ivan
//5 - Eva
//6 - Ruth
// 
//Elige uno : -1
// 
// 
//*/
// 
//import java.io.*;
// 
//public class E18_EligePrimero {
// 
//    public static void main(String[] args) throws Exception {
// 
//        BufferedReader entrada = new BufferedReader(
//            new InputStreamReader(System.in));
// 
//        String[] nombres = {"Mar","Isabel","Ivan","Pol","Eva","Ruth"};
// 
//        boolean continuar = true;
//        while (continuar){
// 
//            //Mostrar nombres
//            for(int i=0; i<nombres.length; i++){
//                System.out.printf("%d - %s\n",i+1,nombres[i]);
//            }
// 
//            //Elegir
//            System.out.print("\nElige uno : ");
//            int n = Integer.parseInt(entrada.readLine());
//            if (n==-1){
//                continuar = false;
//            }else if(n<1 || n>nombres.length){
//                System.out.println("Error.");
//            }else{
// 
//                n--; //para empezar por 0
// 
//                //Guardamos el elegido
//                String tmp = nombres[n];
// 
//                //Desplazar los anteriores hacia abajo
//                for(int i=n; i>0; i--){
//                    nombres[i] = nombres[i-1];
//                }
// 
//                //Colocar en primera posición el que se había elegido
//                nombres[0] = tmp;
// 
//            }
//        }
//    }
//}



// E19_INSERTAR_POR_ORDEN

//Programa que permite entrar 5 números al usuario y guardarlos en un array.
//Los números deben guardarse por orden de menor a mayor.
//Para ello buscaremos la posición que le corresponde, desplazaremos todos los posteriores
//y guardaremos el número en esa posición.
//Cada vez que se introduce un número nuevo se debe mostrar el contenido del array.
// 
// 
// 
//Salida del programa
//-----------------------------------
//Entra un número: 4
//Números : 4
// 
//Entra un número: 9
//Números : 4 9
// 
//Entra un número: 5
//Números : 4 5 9
// 
//Entra un número: 0
//Números : 0 4 5 9
// 
//Entra un número: 13
//Números : 0 4 5 9 13
// 
//El array está completo.
// 
//*/
// 
//import java.io.*;
// 
//public class E19_InsertarPorOrden {
// 
//    public static void main(String[] args) throws Exception {
// 
//        BufferedReader entrada = new BufferedReader(
//            new InputStreamReader(System.in));
// 
//        //Declaración y creación del array
// 
//        int longitud = 5;
//        int[] numeros = new int[longitud];
// 
//        //Bucle para ir entrando datos en el array
// 
//        int count = 0;
//        while ( count<longitud ) {
// 
//            System.out.print("\nEntra un número: ");
//            int valor = Integer.parseInt(entrada.readLine());
// 
//            //Guardar en la posición que le corresponde
// 
// 
//            //Mostrar array
// 
//        }
// 
//        System.out.println("\nEl array está completo.");
// 
//    }
//}
