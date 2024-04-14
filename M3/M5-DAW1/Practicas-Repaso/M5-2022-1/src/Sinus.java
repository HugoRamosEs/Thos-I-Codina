
public class Sinus extends Unaria {

	public Sinus(int[] valor) throws Exception {
		super(valor);
		
	}
	
	public double opera() {
		return Sinus.opera(this.operandos[0]);
	}
	
	public static double opera(double valor) {
		return Math.sin(Math.toRadians(valor));
	}
}
