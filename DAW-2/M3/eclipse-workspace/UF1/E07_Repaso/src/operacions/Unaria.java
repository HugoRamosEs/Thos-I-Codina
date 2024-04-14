package operacions;

public class Unaria extends Naria {

	public Unaria(int[] operandos) throws Exception {
		super(operandos);
		if (operandos.length != 1) {
			throw new Exception("Error");
		}
	}

}
