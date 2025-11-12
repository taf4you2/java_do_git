package module;

import lombok.Getter;

/**
 * Custom exception thrown when an invalid or unsupported game type is specified.
 * Uses Lombok @Getter to auto-generate getter method.
 * 
 * @author Wojciech Węglorz
 * @version 2.0
 */
@Getter  // Automatycznie generuje getGameType()
public class InvalidGameTypeException extends Exception {
    
    /** The invalid game type that caused the exception */
    private final String gameType;
    
    /**
     * Constructor creates an exception with a descriptive message.
     * 
     * @param gameType the invalid game type that was attempted
     */
    public InvalidGameTypeException(String gameType) {
        super("Unknown game type: " + gameType + ". Available types: lotto, multimulti, minilotto");
        this.gameType = gameType;
    }
}