package excepcions;

public class SuicidaMovementException extends Exception {
	private static final long serialVersionUID = 1L;

	public SuicidaMovementException(String missatage) {
		super(missatage);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
