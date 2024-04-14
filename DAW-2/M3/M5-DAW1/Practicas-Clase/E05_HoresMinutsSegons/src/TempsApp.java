
public class TempsApp {

	public static void main(String[] args) throws Exception {
		Temps clase = new Temps();
		
		Temps tiempo1 = new Temps();
		Temps tiempo2 = new Temps(2,30,57);
		Temps tiempo3 = new Temps(1,15,34);
		Temps tiempo4 = new Temps(2,26,19);
		Temps tiempo5 = new Temps(300,120,400);
		Temps tiempo6 = new Temps(2,30,57);
		Temps tiempo7 = new Temps(3,17,32);
		Temps tiempo8 = new Temps(5,25,55);
		Temps tiempo9 = new Temps(1,15,34);
		Temps tiempo10 = new Temps(4,48,13);
		Temps tiempo11 = new Temps(1,11,4);
		Temps tiempo12 = new Temps(9,36,8);
		Temps tiempo13 = new Temps(0,10,7);
		
		System.out.println("Tiempo por defecto: " +tiempo1);
		System.out.println("SumaTiempo: " +clase.sumaTiempo(tiempo2,tiempo3));
		System.out.println("RestaTiempo: " +clase.restaTiempo(tiempo5,tiempo4));
		System.out.println("SumaTiempoEstatico: " +Temps.sumaTiempoEstatico(tiempo6, tiempo7));
		System.out.println("RestaTiempoEstatico: " +Temps.restaTiempoEstatico(tiempo8, tiempo9));
		System.out.println("RestaTiempo < 0: " +clase.restaTiempo(tiempo11,tiempo10)); 
		System.out.println("RestaTiempoEstatico < 0: " +Temps.restaTiempoEstatico(tiempo13,tiempo12));
	}
}
