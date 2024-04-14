import java.util.Scanner;

public class AR153_RelojATravesDelEspejo {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.err.println("Introduce el numero de horas: ");
        int num = entrada.nextInt();
        entrada.nextLine();

        for (int i = 0; i < num; i++) {
            System.err.println("Introduce una hora y minutos (HH:MM): ");
            String relojE = entrada.nextLine();

            String[] partes = relojE.split(":");
            int horaE = Integer.parseInt(partes[0]);
            int minutosE = Integer.parseInt(partes[1]);
            
            int horaR = 12 - horaE;
            int minutosR = 60 - minutosE;
            if (minutosR == 60) {
            	minutosR = 0;
            }
            
            if(horaR == 0) {
            	horaR = 12;
            }
            
            if (minutosE !=0) {
            	horaR--;
            	minutosR = 60 - minutosE;
            	if(horaR == 0) {
                	horaR = 12;
                }
            }
            
            String relojR = String.format("%02d:%02d", horaR, minutosR);
            System.out.println(relojR);
        }
    }
}
