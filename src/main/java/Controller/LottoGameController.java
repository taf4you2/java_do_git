package controller;

import lombok.Getter;
import lombok.extern.java.Log;
import module.*;
import java.util.*;

/**
 * Controller class managing the interaction between View and Model.
 * Maintains history of all lottery draws using type-safe collections.
 * Uses Lombok annotations for automatic code generation.
 * 
 * @author Wojciech Węglorz
 * @version 4.0
 */
@Log     // Automatycznie tworzy logger: log
public class LottoGameController {
    
    /** Thread-safe collection storing history of all lottery draws */
    private final List<DrawResult> drawHistory;
    
    /** Predefined game configurations (type-safe, immutable) */
    private final Map<String, GameConfiguration> gameConfigurations;
    
    /**
     * Constructor initializes controller with empty history
     * and predefined game configurations.
     */
    public LottoGameController() {
        this.drawHistory = Collections.synchronizedList(new ArrayList<>());
        this.gameConfigurations = initializeGameConfigurations();
        log.info("LottoGameController initialized");
    }
    
    /**
     * Initializes predefined game configurations.
     * 
     * @return unmodifiable map of game configurations
     */
    private Map<String, GameConfiguration> initializeGameConfigurations() {
        Map<String, GameConfiguration> configs = new HashMap<>();
        configs.put("lotto", new GameConfiguration("Lotto", 6, 1, 49));
        configs.put("multimulti", new GameConfiguration("MultiMulti", 10, 1, 80));
        configs.put("minilotto", new GameConfiguration("MiniLotto", 5, 1, 42));
        return Collections.unmodifiableMap(configs);
    }
    
    /**
     * Creates a LottoGame instance based on the specified game type.
     * 
     * @param gameType the type of lottery game to create (case-insensitive)
     * @return configured LottoGame instance ready to generate numbers
     * @throws InvalidGameTypeException if the game type is not recognized
     * @throws InvalidGameParametersException if game parameters are invalid
     */
    public LottoGame createGame(String gameType) 
            throws InvalidGameTypeException, InvalidGameParametersException {
        
        if (gameType == null || gameType.trim().isEmpty()) {
            throw new InvalidGameTypeException("empty");
        }
        
        GameConfiguration config = gameConfigurations.get(gameType.toLowerCase());
        if (config == null) {
            throw new InvalidGameTypeException(gameType);
        }
        
        log.fine("Creating game: " + gameType);
        return new LottoGame(config);
    }
    
    /**
     * Generates lottery numbers and stores result in history.
     * 
     * @param game the LottoGame instance for which to generate numbers
     * @throws InvalidGameParametersException if generation fails
     */
    public void generateNumbers(LottoGame game) throws InvalidGameParametersException {
        if (game == null) {
            throw new InvalidGameParametersException("Game instance cannot be null");
        }
        game.generateNumbers();
        
        // Add to history
        DrawResult result = game.createDrawResult();
        drawHistory.add(result);
        log.info("Draw #" + drawHistory.size() + " completed: " + 
                result.configuration().gameName() + " -> " + result.numbers());
    }
    
    /**
     * Gets unmodifiable view of draw history.
     * 
     * @return unmodifiable list of all draw results
     */
    public List<DrawResult> getDrawHistory() {
        return Collections.unmodifiableList(new ArrayList<>(drawHistory));
    }
    
    /**
     * Clears the draw history.
     */
    public void clearHistory() {
        drawHistory.clear();
        log.info("Draw history cleared");
    }
    
    /**
     * Gets the number of draws in history.
     * 
     * @return count of stored draws
     */
    public int getDrawCount() {
        return drawHistory.size();
    }
    
    /**
     * Gets game information string for display purposes.
     * 
     * @param game the LottoGame instance to describe
     * @return formatted string describing the game parameters
     */
    public String getGameInfo(LottoGame game) {
        if (game == null) {
            return "No game selected";
        }
        return String.format("Draws %d numbers from %d to %d", 
            game.getNumbersCount(), 
            game.getMinRange(), 
            game.getMaxRange());
    }
    
    /**
     * Validates game type selection.
     * 
     * @param gameType the game type string to validate
     * @return true if game type is valid, false otherwise
     */
    public boolean isValidGameType(String gameType) {
        if (gameType == null || gameType.trim().isEmpty()) {
            return false;
        }
        return gameConfigurations.containsKey(gameType.toLowerCase());
    }
}