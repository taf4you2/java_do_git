package model;

/**
 * Custom exception thrown when an invalid or unsupported game type is specified.
 * This exception is part of the model package and is handled by the controller.
 * 
 * @author Wojciech Węglorz
 * @version 1.0
 */
public class InvalidGameTypeException extends Exception {
    
    /** The invalid game type that caused the exception */
    private String gameType;
    
    /**
     * Constructor creates an exception with a descriptive message.
     * 
     * @param gameType the invalid game type that was attempted
     */
    public InvalidGameTypeException(String gameType) {
        super("Unknown game type: " + gameType + ". Available types: lotto, multimulti, minilotto");
        this.gameType = gameType;
    }
    
    /**
     * Gets the invalid game type that caused the exception.
     * 
     * @return the game type string
     */
    public String getGameType() {
        return gameType;
    }
}