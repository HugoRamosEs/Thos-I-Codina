package excepcions;

public class TornIncorrecteException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public TornIncorrecteException(String missatage) {
        super(missatage);
    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
