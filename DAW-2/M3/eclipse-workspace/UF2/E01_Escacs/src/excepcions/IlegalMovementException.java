package excepcions;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.JOptionPane;

public class IlegalMovementException extends Exception {
	private static final long serialVersionUID = 1L;
	private String codi;

    public IlegalMovementException(String missatage, String codi) {
        super(missatage);
        this.codi = codi;
    }
    
    public void mostrarError() {
    	StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();
    	String error = "Codi: " + this.codi + "\nError: " + this.getMessage() + "\nPila: " + stackTrace;
        JOptionPane.showMessageDialog(null, error, "Error de moviment", JOptionPane.ERROR_MESSAGE);
    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCodi() {
		return codi;
	}
}
