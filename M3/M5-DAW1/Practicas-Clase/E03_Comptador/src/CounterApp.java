
public class CounterApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Counter counter1 = new Counter();
		Counter counter2 = new Counter(500);
		Counter counter3 = new Counter(counter2);
		Counter counter4 = new Counter(25);
		Counter counter5 = new Counter(1200);
		Counter counter6 = new Counter(400);
		Counter counter7 = new Counter(400);
		Counter counter8 = new Counter(900);
		Counter counter9 = new Counter(100);
		
		
		counter6.incrementar();
		counter7.decrementar();
		counter8.incrementar();
		counter9.decrementar();
		
		
		System.out.println("Valor Defecte: " +counter1.getValor());
		System.out.println("Valor Afegit: " +counter2.getValor());
		System.out.println("Valor Copiat: " +counter3.getValor());
		System.out.println("Valor < MIN: " +counter4.getValor());
		System.out.println("Valor > MAX: " +counter5.getValor());
		System.out.println("Valor Incrementat: " +counter6.getValor());
		System.out.println("Valor Decrementat: " +counter7.getValor());
		System.out.println("Valor Incrementat > MAX: " +counter8.getValor());
		System.out.println("Valor Decrementat < MIN: " +counter9.getValor());

		
	}

}
