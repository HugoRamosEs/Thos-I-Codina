package chat.model.exceptions;

public class ChatInvalidArgumentException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ChatInvalidArgumentException() {
        super();
    }
	
	public ChatInvalidArgumentException(String message) {
        super(message);
    }
	
	public ChatInvalidArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
	
	 public ChatInvalidArgumentException(Throwable cause) {
	    super(cause);
	}
	 
	 protected ChatInvalidArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	 }
}
