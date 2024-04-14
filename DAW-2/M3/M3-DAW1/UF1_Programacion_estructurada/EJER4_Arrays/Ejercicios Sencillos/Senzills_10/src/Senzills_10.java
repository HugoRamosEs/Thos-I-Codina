import java.io.*;
 
public class Senzills_10 {
   public static void main(String[] args) throws IOException {
        BufferedReader tec_buffer=new BufferedReader(new InputStreamReader(System.in));
        String alumnes[]={"Martina","Neus","Angelica","Lluís","Clara","Eloy" };
        String dnis[]={ "74868484H", "90393939T", "70048899T" ,"74488323U", "75444887J", "75833432F" };
        String dni_teclat;
        int trobat=-1;
         
        System.out.println("Quin és el DNI ?");
        dni_teclat=tec_buffer.readLine();
         
        for (int i=0; i<dnis.length; i++) {
            if (dni_teclat.equalsIgnoreCase(dnis[i])) {
                trobat=i;
            }
        }
        if (trobat>=0) System.out.println("Correspon a l'alumne: "+alumnes[trobat]);
        else System.out.println("No hi ha cap alumne amb aquest dni");
   }
}