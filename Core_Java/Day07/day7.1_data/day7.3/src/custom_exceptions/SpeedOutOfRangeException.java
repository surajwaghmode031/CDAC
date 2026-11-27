package custom_exceptions;

@SuppressWarnings("serial")  // tell to javac to suppress : serialization related warning
public class SpeedOutOfRangeException extends Exception {

	//SpeedOutOfRangeException() :Constructs a new exception with null as its detail message.
	//SpeedOutOfRangeException(String errM;qsg) : Constructs a new exception with the specified detail message.
	public SpeedOutOfRangeException(String errMsg) {
		super(errMsg);
	}
	
}
