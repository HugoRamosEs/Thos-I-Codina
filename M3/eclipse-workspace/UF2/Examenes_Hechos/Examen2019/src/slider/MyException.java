package slider;

public class MyException extends Exception {
    private String codi;

    public MyException(String pCodi, String message) {
        super(message);
        this.codi = pCodi;
    }

    public String getCode() {
        return codi;
    }
}
