package module;

/**
 * Custom exception thrown when invalid game parameters are provided.
 * This exception is thrown by the model when validation fails.
 * 
 * @author Wojciech Węglorz
 * @version 2.0
 */
public class InvalidGameParametersException extends Exception {
    
    /**
     * Constructor creates an exception with a descriptive message.
     * 
     * @param message the error message describing what went wrong
     */
    public InvalidGameParametersException(String message) {
        super(message);
    }
}