/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package console;

import module.LottoGame;
import viev.View;
import java.util.Scanner;

/**
 *
 * @author wojtek
 */

public class Controler {
    private View view;
    private LottoGame game;

    public Controler() {
        this.view = new View();
    }
    
    public void run(String[] args) {
        
        //trzeba bedzie dorobic obsluge wielu arumentow i to ze jak program bez argumentow to jakies menu sie uruchamia
        
        String gameType;
        
        if (args.length > 0) {
            gameType = args[0].toLowerCase();
        } else {
            gameType = getUserInput();
        }
        
        if (createGame(gameType)) {
            game.generateNumbers();
            view.displayResults(game);
        } else {
            view.displayError("Nieznany rodzaj gry: " + gameType);
        }
    }
    
    private String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        view.promptForGameType();
        String input = scanner.nextLine().toLowerCase().trim(); // trim usuwa biale znaki
        scanner.close();
        return input;
    }
    
    private boolean createGame(String gameType) {
        switch (gameType) {
            case "lotto":
                game = new LottoGame("Lotto", 6, 1, 49);
                return true;
            case "multimulti":
                game = new LottoGame("MultiMulti", 10, 1, 80);
                return true;
            case "minilotto":
                game = new LottoGame("Mini Lotto", 5, 1, 42);
                return true;
            default:
                return false;
        }
    }
}