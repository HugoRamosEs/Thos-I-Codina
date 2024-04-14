package pregunta2;

import java.util.Objects;

public class DNI implements ElementOrdenable {
	private String numero;

	public DNI(String numero) {
		super();
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return "DNI [numero=" + numero + "]";
	}

	@Override
	public boolean menorQue(ElementOrdenable e) {
		return false;
	}
}
