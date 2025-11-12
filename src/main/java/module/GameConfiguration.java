package module;

/**
 * Record representing immutable lottery game configuration.
 * Contains all parameters defining a specific lottery game type.
 * Records provide automatic implementation of constructor, getters,
 * equals(), hashCode(), and toString() methods.
 * 
 * @param gameName the name of the lottery game
 * @param numbersCount the quantity of numbers to generate
 * @param minRange the minimum value in the number range (inclusive)
 * @param maxRange the maximum value in the number range (inclusive)
 * 
 * @author Wojciech Węglorz
 * @version 3.0
 */
public record GameConfiguration(
    String gameName,
    int numbersCount,
    int minRange,
    int maxRange
) {
    /**
     * Compact constructor with validation.
     * Ensures all parameters meet the requirements for a valid game.
     * 
     * @throws IllegalArgumentException if parameters are invalid
     */
    public GameConfiguration {
        if (gameName == null || gameName.trim().isEmpty()) {
            throw new IllegalArgumentException("Game name cannot be empty");
        }
        
        if (numbersCount <= 0) {
            throw new IllegalArgumentException(
                "Number count must be positive, got: " + numbersCount);
        }
        
        if (minRange >= maxRange) {
            throw new IllegalArgumentException(
                "Minimum range (" + minRange + ") must be less than maximum range (" + maxRange + ")");
        }
        
        int availableNumbers = maxRange - minRange + 1;
        if (numbersCount > availableNumbers) {
            throw new IllegalArgumentException(
                "Cannot draw " + numbersCount + " unique numbers from range with only " 
                + availableNumbers + " values");
        }
    }
}