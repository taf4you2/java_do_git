package com.mycompany.wojciechweglorzex1;

import console.Controler;

/**
 * Main application class for lottery number generator.
 * 
 * @author Wojciech Węglorz
 * @version 1.0
 */

public class WojciechWeglorzEx1 {
    
    /**
     * Main method - entry point of the application.
     * 
     * Command line parameters order:
     * args[0] - game type: lotto, multimulti, minilotto
     * 
     * If no parameters are provided, the application will prompt the user
     * to enter the game type interactively.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Controler controler = new Controler();
        controler.run(args);
    }
}