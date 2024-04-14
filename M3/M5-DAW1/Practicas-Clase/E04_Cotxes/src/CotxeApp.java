
public class CotxeApp {

	public static void main(String[] args) {
		int vegades = 100000000; // Es pot asignar el nombre de vegades que es vol repetir el bucle perque generi noves matricules.

		for (int i = 0; i < vegades; i++) {
			Cotxe cotxe = new Cotxe();
			System.out.println(cotxe.getMatricula());
		}
	}
}
