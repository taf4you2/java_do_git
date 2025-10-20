package model;

import java.util.*;

/**
 * Model class representing a lottery game.
 * Generates unique random numbers within a specified range.
 * 
 * @author Wojciech Węglorz
 * @version 1.0
 */
public class LottoGame {
    
    /** Name of the lottery game */
    private String gameName;
    
    /** Number of lottery numbers to generate */
    private int numbersCount;
    
    /** Minimum value in the lottery number range (inclusive) */
    private int minRange;
    
    /** Maximum value in the lottery number range (inclusive) */
    private int maxRange;
    
    /** Array containing the generated lottery numbers */
    private int[] generatedNumbers;
    
    /**
     * Constructor creates a new lottery game with parameters.
     * 
     * @param gameName the name of the lottery game
     * @param numbersCount the quantity of numbers to generate
     * @param minRange the minimum value in the number range (inclusive)
     * @param maxRange the maximum value in the number range (inclusive)
     */
    public LottoGame(String gameName, int numbersCount, int minRange, int maxRange) {
        this.gameName = gameName;
        this.numbersCount = numbersCount;
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.generatedNumbers = new int[numbersCount];
    }
    
    /**
     * Generates unique random lottery numbers within the specified range.
     * The generated numbers are sorted in ascending order.
     */
    public void generateNumbers() {
        Random random = new Random();
        int count = 0;
        
        while (count < numbersCount) {
            int number = random.nextInt(maxRange - minRange + 1) + minRange;
            
            if (!contains(generatedNumbers, number, count)) {
                generatedNumbers[count] = number;
                count++;
            }
        }
        
        Arrays.sort(generatedNumbers);
    }
    
    /**
     * Helper method for ensuring uniqueness of generated numbers.
     * 
     * @param array the array to search
     * @param value the value to find
     * @param length the number of elements to check from the start
     * @return true if the value is found, false otherwise
     */
    private boolean contains(int[] array, int value, int length) {
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Gets the name of the lottery game.
     * 
     * @return the game name
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * Gets the array of generated lottery numbers.
     * 
     * @return array containing the generated numbers
     */
    public int[] getGeneratedNumbers() {
        return generatedNumbers;
    }

    /**
     * Gets the count of numbers to be generated.
     * 
     * @return the quantity of lottery numbers
     */
    public int getNumbersCount() {
        return numbersCount;
    }

    /**
     * Gets the minimum value in the lottery number range.
     * 
     * @return the minimum range value (inclusive)
     */
    public int getMinRange() {
        return minRange;
    }

    /**
     * Gets the maximum value in the lottery number range.
     * 
     * @return the maximum range value (inclusive)
     */
    public int getMaxRange() {
        return maxRange;
    }
}