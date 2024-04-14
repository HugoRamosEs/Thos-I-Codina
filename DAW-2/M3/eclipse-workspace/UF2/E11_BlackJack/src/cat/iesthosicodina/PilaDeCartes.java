package cat.iesthosicodina;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;
import java.util.stream.Stream;

public class PilaDeCartes extends Stack<Carta> {
	
	public int numeroDAses() {
		int numeroDAses = 0;
		Iterator<Carta> itr = this.iterator();
		while (itr.hasNext()) {
			if ((itr.next().getNumero()==1)) numeroDAses++;
		}
		return numeroDAses;
	}
	
	public int valor() {
		int valor = 0;
		Iterator<Carta> itr = this.iterator();
		while (itr.hasNext()) {
			valor += itr.next().valor();
		}
		if (this.numeroDAses()==1) {
			if (valor+10<=21) {
				valor += 10;
			}
		}
		return valor;
	}

	//Possibles formes de recòrrer una Pila:
	// 1.- Fent servir un iterador:
	public boolean totesVistes() {
		Iterator<Carta> itr = this.iterator();
		while (itr.hasNext()) {
			if (!(itr.next().getVista())) return false;
		}
		return true;
	}
		
	// 2.- Fent servir el for millorat (internament és un iterador)
	public boolean totesVistes01() {
		for (Carta item: this) {
			if (!(item.getVista())) {
				return false;
			}
		}
		return true;
	}

/*
	// Java 8 o superior **************************
		
	// 3. Java 8 – get the stream and use a lambda expression
	public boolean totesVistes02() {
		boolean result=true;
		this.stream().forEach(S -> {if (!(S.getVista())) result = false; });
		
		return result;
	}
	
	// 4. Java 8 – get the stream and provide a method reference
	public boolean totesVistes03() {
		this.stream().forEach(System.out::println);
		return true;
	}
	
	// 5. Java 8 – Stream.of() + toArray() + forEach()
	public boolean totesVistes04() {
		Stream.of(this.toArray()).forEach(System.out::println);
	}
	
	// 6. Java 8 – stack inherits `forEach()` from the `Iterable` interface
	public boolean totesVistes05() {
		this.forEach(System.out::println);
	}
	
	// 7. Java 8 – `iterator()` is inherited from the `Collection` interface
	public boolean totesVistes06() {
		this.iterator().forEachRemaining(System.out::println);
	}
*/	
	/* using Enumeration */
/*	 
    // 8. Convert the stack into a vector and use the `Enumeration` interface
    @Deprecated
    public boolean totesVistes07() {
    	Enumeration<Carta> enumeration = new Vector(this).elements();
	    while (enumeration.hasMoreElements()) {
	    	if (!(enumeration.nextElement().getVista())) {
				return false;
			}
	    }
    }
    
    // 9. Collections.enumeration() returns an enumeration
    public boolean totesVistes08() {
	    Enumeration<Carta> enumeration = Collections.enumeration(this);
	    while (enumeration.hasMoreElements()) {
	    	if (!(enumeration.nextElement().getVista())) {
				return false;
			}
	    }
    }
*/    
 
	
}
