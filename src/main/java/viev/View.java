/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viev;

import module.LottoGame;

/**
 *
 * @author wojtek
 */

public class View {
    
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
    
    public void displayError(String message) {
        System.err.println("Blad: " + message);
    }
    
    public void promptForGameType() {
        System.out.println("Podaj rodzaj gry (lotto): ");
    }
}