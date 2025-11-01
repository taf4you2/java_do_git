package view;

import module.LottoGame;

/**
 * View class responsible for displaying information to the user.
 * Implements the View component of the MVC pattern.
 * 
 * @author Wojciech Węglorz
 * @version 1.0
 */
public class View {
    
    /**
     * Default constructor for View class.
     */
    public View() {
        // Default constructor
    }
    
    /**
     * Displays the lottery game results (game name and generated numbers).
     * Numbers are displayed in a single line separated by spaces.
     * 
     * @param game the lottery game whose results should be displayed
     */
    public void displayResults(LottoGame game) {
        System.out.println(game.getGameName());
        
        int[] numbers = game.getGeneratedNumbers();
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    
    /**
     * Displays an error message to the standard error stream.
     * 
     * @param message the error message to display
     */
    public void displayError(String message) {
        System.err.println("Error: " + message);
    }
    
    /**
     * Prompts the user to enter the game type.
     * Displays available game options.
     */
    public void promptForGameType() {
        System.out.println("Enter game type (lotto, multimulti, minilotto): ");
    }
}