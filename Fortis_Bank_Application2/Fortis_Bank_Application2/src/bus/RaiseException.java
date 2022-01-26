package bus;

public class RaiseException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String msg = "Invalid input: General Exception form the developper";
	
	public RaiseException() {
		super(msg);
	}
	public RaiseException(String message) {
		super(message);
	}

}
