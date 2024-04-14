import java.io.*;
 
public class E12_Notas {
 
    public static void main(String args[]) throws IOException {
 
        BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
 
        int aprobados=0;
        int suspensos=0;
         
        System.out.print("Entra la nota del examen: ");
        double nota = Double.parseDouble(entrada.readLine());
        
        while(nota!=-1) {
        	if(nota>=0 && nota<5) suspensos++;
        	else if(nota>=5 && nota<=10) aprobados++;
        	else System.out.println("Nota invalida");
        	
        	System.out.print("Entra la nota del examen: ");
            nota = Double.parseDouble(entrada.readLine());
        }
        double persusp=(double)suspensos/(suspensos+aprobados)*100;
        double perapro=(double)aprobados/(suspensos+aprobados)*100;
        
        System.out.println("Hay " +suspensos+ " suspensos que son un " +persusp+ "%\n");
        System.out.printf("Hay %d aprobados que son un %.2f %%\n", aprobados, perapro);
    }
}