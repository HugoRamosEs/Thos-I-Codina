package pregunta02;

public class Compte {
	private String numero;
	private Client propietari;
	private double balance;
	
	public Compte(String numero, Client propietari) throws IllegalArgumentException{
		if (numero==null || propietari==null) {
			throw new IllegalArgumentException("Paràmetre oblicatori no indicat");
		}
		this.numero = numero;
		this.propietari = propietari;
		this.balance=0.0;
	}

	public String getNumero() {
		return numero;
	}

	public Client getPropietari() {
		return this.propietari;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", propietari=" + propietari + ", balance=" + balance + "]";
	}
}
