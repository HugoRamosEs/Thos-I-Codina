import java.io.*;
import java.util.Scanner;

public class Senzills_09 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        BufferedReader tec_buffer=new BufferedReader(new InputStreamReader(System.in));
        Scanner tec_scan=new Scanner(System.in);
        char vocals[]={'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        char lletra;
        boolean esvocal=false;
         
        System.out.println("Entra un caràcter:");
        //  3 mètodes per a llegir un caràcter del teclat
        //lletra=(char)tec_buffer.read();
        lletra=(char)tec_buffer.readLine().charAt(0);
        //lletra=(char)tec_scan.nextLine().charAt(0);
         
        for (int i=0; i<vocals.length; i++) {
            if (vocals[i]==lletra) {
                esvocal=true;
            }
        }
        if (esvocal) {
        	System.out.println("El caràcter '"+lletra+"' SI és una vocal");
        }
        else {
        	System.out.println("El caràcter '"+lletra+"' NO és una vocal");
        }
	}
}
