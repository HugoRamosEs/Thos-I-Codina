package slider;

public class MyException extends Exception {
	private String code;

	public MyException(String code) {
		super();
		// TODO Auto-generated constructor stub
		this.code = code;
	}

	public MyException(String code, String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
		this.code = code;
	}

	public MyException(String code, String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
		this.code = code;
	}

	public MyException(String code, String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		this.code = code;
	}

	public MyException(String code, Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		this.code = code;
	}
	

}
