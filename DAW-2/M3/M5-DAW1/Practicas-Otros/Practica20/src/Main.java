
public class Main {
	public static void main(String[] args) throws CloneNotSupportedException {
		Suma suma = new Suma(10,20);
		Sinus sinus = new Sinus(10);
		
		// SUMA
		System.out.println("---------------SUMA----------------");
		
		System.out.println(Suma.opera(20, 30));
		suma.opera();
		System.out.println(suma.clone()); // NO FUNCIONA...
		
		// SINUS
		System.out.println("---------------SINUS----------------");
		
		System.out.println(Sinus.opera(90));
		sinus.opera();
		System.out.println(sinus.clone());
		
	}
}
