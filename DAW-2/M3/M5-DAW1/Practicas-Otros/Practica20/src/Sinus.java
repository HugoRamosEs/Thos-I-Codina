
public class Sinus extends Unaria {
	private double resultado;
	
	public Sinus(int e) {
		super(e);
		this.resultado = 0;
	}
	
	public static double opera(int e) {
		Math.toRadians(e);
		return Math.sin(e);
	}
	
	@Override
	public void opera() {
		this.resultado = Math.sin(this.operandos[0]);
		System.out.println(this.resultado);
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.resultado);
	}
	
	// No se puede redefinir el metodo getClass() porque es una clase que pertenece a Object.
}
