
public class Naria extends Operacio {
	protected int operandos[];
	
	public Naria(int numOperandos) {
		this.operandos = new int [numOperandos];
	}

	public int[] getOperandos() {
		return operandos;
	}

	public void setOperandos(int operandos[]) {
		this.operandos = operandos;
	}
	
	@Override
	public Naria clone() throws CloneNotSupportedException {
		Naria copia = (Naria) super.clone();
		return copia;
	}
}
