
public class Binaria extends Naria {

	public Binaria(int[] operandos) throws Exception {
		super(operandos);
		if (operandos.length != 2) {
			throw new Exception("Error");
		}
	}
}
