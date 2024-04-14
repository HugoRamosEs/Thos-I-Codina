package operacions;

public class Sinus extends Unaria {

	public Sinus(int[] operandos) throws Exception {
		super(operandos);
	}
	
	public double opera() {
		return Math.sin(super.getOperandos()[0]);
	}
	
	public static double opera(double valor) {
		return Math.sin(valor);
	}
}
