package operacions;

public class Naria extends Operacio {

	public Naria(int[] operandos) {
		super(operandos);
	}
	
	public Object clone() {
		Naria cp = new Naria(null);
		cp.setOperandos(this.getOperandos().clone());
		return cp;
	}
}
