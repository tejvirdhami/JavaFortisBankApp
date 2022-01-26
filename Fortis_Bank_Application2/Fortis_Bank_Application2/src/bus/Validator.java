package bus;

public class Validator {

	public static void isPositive(int value) throws RaiseException{
		if( value <= 0) {
			throw new RaiseException("invalid input, must be positive...[From Thao]");
		}
		
	}
	public static void isPositive(double value) throws RaiseException{
		if( value <= 0) {
			throw new RaiseException("invalid input, must be positive...[From Thao]");
		}
		
	}
	
	public static void IsInRange(long value) throws RaiseException {
		if(value < 1111 || value > 9999) {
			throw new RaiseException("invalid input, value must be between 1111 and 9999... [From Thao]");
			
		}
	}
	
//	public static void IsNumeric (String value) throws RaiseException{
//		for (int i = 0; i != value.length() ; ++i) {
//			if(!Character.isDigit(value.charAt(i))){ // Using the character class
//				throw new RaiseException("invalid input, value must be digit only... [From Thao]");
//			}
//		}
//	}
	
	public static void isAplphabetic (String value) throws RaiseException{
		for (int i =0; i != value.length(); ++i) {
			if(!Character.isAlphabetic(value.charAt(i))) {
				throw new RaiseException("invalid input, value must be alphabet letter");
			}
		}
	}
}
