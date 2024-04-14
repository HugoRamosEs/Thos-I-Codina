package slider;

public class MyException extends Exception {
	private static final long serialVersionUID = 1L;
	private String codi;
	
	public MyException(String codi) {
        super();
        this.codi = codi;
    }
	
	public MyException(String codi, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.codi = codi;
    }
	
	public MyException(String codi, String message, Throwable cause) {
		super(message, cause);
		this.codi = codi;
	}
	
	public MyException(String codi, String message) {
		super(message);
		this.codi = codi;
	}
	
	public MyException(String codi, Throwable cause) {
		super(cause);
		this.codi = codi;
	}
}
