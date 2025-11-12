package module;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.java.Log;
import java.util.*;

/**
 * Model class representing a lottery game.
 * Generates unique random numbers within a specified range.
 * Uses Lombok annotations to reduce boilerplate code.
 * 
 * @author Wojciech Węglorz
 * @version 4.0
 */
@Getter  // Automatycznie generuje gettery dla wszystkich pól
@Log     // Automatycznie tworzy logger: log
public class LottoGame {
    
    /** Configuration of the lottery game (immutable) */
    @NonNull
    private final GameConfiguration configuration;
    
    /** List containing the generated lottery numbers (type-safe collection) */
    private List<Integer> generatedNumbers;
    
    /**
     * Constructor creates a new lottery game with configuration.
     * 
     * @param configuration the game configuration (must not be null)
     * @throws InvalidGameParametersException if configuration is invalid
     */
    public LottoGame(@NonNull GameConfiguration configuration) 
            throws InvalidGameParametersException {
        this.configuration = configuration;
        this.generatedNumbers = new ArrayList<>();
        log.info("Created new game: " + configuration.gameName());
    }
    
    /**
     * Convenience constructor with individual parameters.
     * Creates GameConfiguration internally.
     * 
     * @param gameName the name of the lottery game
     * @param numbersCount the quantity of numbers to generate
     * @param minRange the minimum value in the number range
     * @param maxRange the maximum value in the number range
     * @throws InvalidGameParametersException if parameters are invalid
     */
    public LottoGame(String gameName, int numbersCount, int minRange, int maxRange) 
            throws InvalidGameParametersException {
        this(new GameConfiguration(gameName, numbersCount, minRange, maxRange));
    }
    
    /**
     * Generates unique random lottery numbers within the specified range.
     * The generated numbers are sorted in ascending order.
     */
    public void generateNumbers() {
        generatedNumbers.clear();
        Random random = new Random();
        
        while (generatedNumbers.size() < configuration.numbersCount()) {
            int number = random.nextInt(
                configuration.maxRange() - configuration.minRange() + 1
            ) + configuration.minRange();
            
            if (!generatedNumbers.contains(number)) {
                generatedNumbers.add(number);
            }
        }
        
        Collections.sort(generatedNumbers);
        log.fine("Generated numbers: " + generatedNumbers);
    }
    
    /**
     * Gets the list of generated lottery numbers.
     * Returns unmodifiable list to prevent external modifications.
     * 
     * @return unmodifiable list containing the generated numbers
     */
    public List<Integer> getGeneratedNumbers() {
        return Collections.unmodifiableList(generatedNumbers);
    }
    
    /**
     * Creates a DrawResult from current game state.
     * 
     * @return DrawResult record with configuration and generated numbers
     */
    public DrawResult createDrawResult() {
        return new DrawResult(configuration, generatedNumbers);
    }
    
    // Gettery dla kompatybilności wstecznej (View może ich używać)
    public String getGameName() {
        return configuration.gameName();
    }
    
    public int getNumbersCount() {
        return configuration.numbersCount();
    }
    
    public int getMinRange() {
        return configuration.minRange();
    }
    
    public int getMaxRange() {
        return configuration.maxRange();
    }
}