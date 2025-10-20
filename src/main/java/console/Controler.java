package console;

import model.LottoGame;
import view.View;
import model.InvalidGameTypeException;
import java.util.Scanner;

/**
 * Controller class that manages the application flow and user interaction.
 * 
 * @author Wojciech Węglorz
 * @version 1.0
 */

public class Controler {
    
    /** View component for displaying information to the user */
    private View view;
    
    /** Current lottery game instance */
    private LottoGame game;

    /**
     * Controler constructor.
     */
    public Controler() {
        this.view = new View();
    }
    
    /**
     * Main application flow method.
     * Processes command line arguments or gets user input,
     * creates the appropriate game, generates numbers and displays results.
     * 
     * @param args command line arguments
     */
    public void run(String[] args) {
        String gameType;
        
        if (args.length > 0) {
            gameType = args[0].toLowerCase();
        }
        else {
            gameType = getUserInput();
        }
        
        try {
            createGame(gameType);
            game.generateNumbers();
            view.displayResults(game);
        }
        catch (InvalidGameTypeException e) {
            view.displayError(e.getMessage());
        }
    }

    /**
     * Gets game type input from the user via console.
     * 
     * @return the game type entered by the user
     */
    private String getUserInput() {
        String input;
        try (Scanner scanner = new Scanner(System.in)) {
            view.promptForGameType();
            input = scanner.nextLine().toLowerCase().trim(); // trim usuwa biale znaki przed i za
        }//tego try zaproponowal netbeans
        return input;
    }
    
    /**
     * Creates a lottery game instance based on the specified game type.
     * 
     * @param gameType the type of lottery game to create
     * @throws InvalidGameTypeException if the game type is not recognized
     */
    private void createGame(String gameType) throws InvalidGameTypeException {
        switch (gameType) {
            case "lotto" -> 
                game = new LottoGame("Lotto", 6, 1, 49);
            case "multimulti" -> 
                game = new LottoGame("MultiMulti", 10, 1, 80);
            case "minilotto" -> 
                game = new LottoGame("Mini Lotto", 5, 1, 42);
            default -> 
                throw new InvalidGameTypeException(gameType);
        }
    }
}