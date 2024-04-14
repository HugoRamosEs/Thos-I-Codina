import java.util.Scanner;
 
public class E28_Fletxa {
 
    public static void main(String[] args) {
        Scanner teclat=new Scanner(System.in);
         
        System.out.print("Sentido: ");
        char sentido=teclat.nextLine().charAt(0);
        System.out.print("Longitud: ");
        int longitud=teclat.nextInt();
        
        if (sentido=='I') System.out.print('<');
        for (int i=1; i<=longitud-1; i++) {
            System.out.print('-');
        }
        
        if (sentido=='D') System.out.print('>');
        System.out.println();
    }
}