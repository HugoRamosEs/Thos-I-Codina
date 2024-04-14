package pregunta04;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

public class Pregunta04 {

	public static void main(String[] args) {
		Punt punt_1 = new Punt(new Color(0,0,0) , 10, 17);
		Punt punt_2 = new Punt(new Color(255,0,0) , 10, 18);
		Punt punt_3 = new Punt(new Color(0,255,0) , 10, 19);
		Punt punt_4 = new Punt(new Color(0,0,255) , 10, 20);
		Punt punt_5 = new Punt(new Color(255,255,0) , 10, 21);
		Punt punt_6 = new Punt(new Color(255,0,255) , 10, 22);
		Punt punt_7 = new Punt(new Color(255,255,255) , 10, 23);
		
		Queue<Punt> cola = new LinkedList<Punt>();
		cola.add(punt_1);
		cola.add(punt_2);
		cola.add(punt_3);
		cola.add(punt_4);
		cola.add(punt_5);
		cola.add(punt_6);
		cola.add(punt_7);
		
		// La diferencia entre offer y add, esque si la 
		// cola esta llena el add lanza una excepcion y 
		// y el offer devuleve false.
	} 

}
