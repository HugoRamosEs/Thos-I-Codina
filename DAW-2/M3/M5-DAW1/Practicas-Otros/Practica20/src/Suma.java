import java.util.Objects;

public class Suma extends Binaria {
	private double resultado;
	
	public Suma(int e, int f) {
		super(e, f);
		this.resultado = 0;
	}

	public void opera() {
		this.resultado = this.operandos[0] + this.operandos[1];
	}
	
	public static int opera(int a, int b) {
		return a + b;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Suma other = (Suma) obj;
		return Double.doubleToLongBits(resultado) == Double.doubleToLongBits(other.resultado);
	}

	@Override
	public String toString() {
	    return String.valueOf(this.resultado);
	}
}
