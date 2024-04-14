import java.io.*;

public class E13_Temperaturas {

	public static void main(String args[]) throws IOException{
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		double valor, maximo, minimo;
		int dia = 0;
		double media = 0;
		maximo = Double.MIN_VALUE;
		minimo = Double.MAX_VALUE;
		String linia;
		
		do {
			++dia;
			System.out.println("Introduce un valor para el dia " +dia +": ");
			linia = entrada.readLine();
			if (!linia.equals("FIN")) {
				valor = Double.parseDouble(linia);
				if(valor>=0) {
					if(valor>maximo) {
						maximo = valor;
					}
					if(valor<minimo) {
						minimo = valor;
					}
					media = media + valor;
			     }
		      }
		}while (!linia.equals("FIN"));
		media = media / (dia -1);
		
		System.out.println("Se ha indicado la temperatura de" +dia + " dias");
		System.out.println("La media de temperaturas es: " +media);
		System.out.println("El maximo es " +maximo +"º, y el minimo es " +minimo +"º");
	}
}
