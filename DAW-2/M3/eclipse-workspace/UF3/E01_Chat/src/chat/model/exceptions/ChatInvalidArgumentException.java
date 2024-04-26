package chat.model.exceptions;

/**
 * Classe filla de Exception que gestiona els errors d'arguments invàlids en aquesta aplicació en concret.
 * 
 * @version 1.0
 * @author Hugo
 */
public class ChatInvalidArgumentException extends Exception {
	private static final long serialVersionUID = 1L;
	private String code;
	
	/**
	 * Constructor per crear una instancia de ChatInvalidArgumentException.
	 * 
	 * @param code Codi de l'error.
	 */
	public ChatInvalidArgumentException(String code) {
        super();
        this.code = code;
    }
	
	/**
	 * Constructor per crear una instancia de ChatInvalidArgumentException amb un missatge.
	 * 
	 * @param message Missatge de l'error.
	 * @param code Codi de l'error.
	 */
	public ChatInvalidArgumentException(String message, String code) {
        super(message);
        this.code = code;
    }
	
	/**
	 * Constructor per crear una instancia de ChatInvalidArgumentException amb un missatge i una causa.
	 * 
	 * @param message Missatge de l'error.
	 * @param cause Causa de l'error.
	 * @param code Codi de l'error.
	 */
	public ChatInvalidArgumentException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }
	
	/**
	 * Constructor per crear una instancia de ChatInvalidArgumentException amb una causa.
	 * 
	 * @param cause Causa de l'error.
	 * @param code Codi de l'error.
	 */
	 public ChatInvalidArgumentException(Throwable cause, String code) {
	    super(cause);
	    this.code = code;
	}
	 
	 /**
	  * Constructor per crear una instancia de ChatInvalidArgumentException amb un missatge, una causa, si es pot suprimir i si es pot escriure.
	  * 
	  * @param message Missatge de l'error.
	  * @param cause Causa de l'error. 
	  * @param enableSuppression Si es pot suprimir.
	  * @param writableStackTrace Si es pot escriure.
	  * @param code Codi de l'error.
	  */
	 protected ChatInvalidArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.code = code;
	 }
}
