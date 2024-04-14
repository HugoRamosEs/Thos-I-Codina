package operacions;

public class Suma extends Binaria {

	public Suma(int[] operandos) throws Exception {
		super(operandos);
	}
	
	public double opera() {
		return super.getOperandos()[0] + super.getOperandos()[1];
	}
	
	public static double opera(double valor, double valor2) {
		return valor + valor2;
	}
}
