package pregunta01;

public class CustomCheckedException extends Exception {
	private static final long serialVersionUID = 1L;
	private String codi;
	
	public CustomCheckedException(String codi) {
        super();
        this.codi = codi;
    }
	
	public CustomCheckedException(String codi, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.codi = codi;
    }
	
	public CustomCheckedException(String codi, String message, Throwable cause) {
		super(message, cause);
		this.codi = codi;
	}
	
	public CustomCheckedException(String codi, String message) {
		super(message);
		this.codi = codi;
	}
	
	public CustomCheckedException(String codi, Throwable cause) {
		super(cause);
		this.codi = codi;
	}
}
