package pregunta05;

import java.util.Iterator;
import java.util.Stack;

public class Pregunta {

	public static void main(String[] args) {
		String cadena = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras aliquet velit elit, nec consequat quam hendrerit ut. Aenean et imperdiet mi, vitae mattis nulla. Aenean ut aliquam mi. Vestibulum fringilla cursus mauris, vitae pulvinar orci ornare quis. Fusce sit amet mattis dolor, gravida euismod ex. Vivamus eget metus a diam facilisis tempus ac in augue. In finibus arcu et nulla lobortis, id tincidunt diam lobortis. Nulla erat orci, ultrices nec aliquam vel, tincidunt at nisl. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla pretium tempus ultrices.";
		
		Stack<String> pila = new Stack<String>();
		String[] array = cadena.split(" ");
		
		for(int i=0; i<array.length; i++) {
			pila.push(array[i]);
		}
		
		for(int i=pila.size() - 1; i>=0; i--) {
			System.out.println(pila.get(i));
		}
		
//		Iterator it = pila.iterator();
//		while (it.hasNext()) {
//			System.out.println(it.next());
//		}

	}

}
