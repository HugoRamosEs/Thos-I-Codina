import java.util.Arrays;

public class Operacio implements Operable, Cloneable {
	protected int operandos [];
	
	public Operacio(int[] operandos) {
		super();
		this.setOperandos(operandos);
	}
	
	public int[] getOperandos() {
		return operandos;
	}

	public void setOperandos(int operandos[]) {
		this.operandos = operandos;
	}

	@Override
	public double opera() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operacio other = (Operacio) obj;
		return Arrays.equals(operandos, other.operandos);
	}
	
}
