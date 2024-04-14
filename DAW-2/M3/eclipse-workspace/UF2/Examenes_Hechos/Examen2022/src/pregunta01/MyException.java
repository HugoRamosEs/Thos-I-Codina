package pregunta01;

public class MyException extends Exception {
	private String codi;

	public MyException(String pCodi) {
		super();
		this.codi = pCodi;
	}

	public MyException(String pCodi, String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.codi = pCodi;
	}

	public MyException(String pCodi, String message, Throwable cause) {
		super(message, cause);
		this.codi = pCodi;
	}

	public MyException(String pCodi, String message) {
		super(message);
		this.codi = pCodi;
	}

	public MyException(String pCodi, Throwable cause) {
		super(cause);
		this.codi = pCodi;
	}

    public String getCode() {
        return codi;
    }
}
