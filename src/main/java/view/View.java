package view;

import model.LottoGame;

/**
 * View class responsible for displaying information to the user.
 * 
 * @author Wojciech Węglorz
 * @version 1.0
 */

public class View {
    
    /**
     * Displays the lottery game results (game name and wining numbers).
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
     * Displays an error message.
     * 
     * @param message the error message to display
     */
    public void displayError(String message) {
        System.err.println("Blad: " + message);
    }
    
    /**
     * Prompts the user to enter the game type.
     * Displays available game options.
     */
    public void promptForGameType() {
        System.out.println("Podaj rodzaj gry (lotto): ");
    }
}