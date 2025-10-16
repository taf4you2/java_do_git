/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module;


import java.util.*;

/**
 *
 * @author wojtek
 */
public class LottoGame {
    
    private String gameName;
    private int numbersCount;
    private int minRange;
    private int maxRange;
    private int[] generatedNumbers;
    
    public LottoGame(String gameName, int numbersCount, int minRange, int maxRange) {
        this.gameName = gameName;
        this.numbersCount = numbersCount;
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.generatedNumbers = new int[numbersCount];
    }
    
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
    
    private boolean contains(int[] array, int value, int length) {
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
    
    public String getGameName() {
        return gameName;
    }

    public int[] getGeneratedNumbers() {
        return generatedNumbers;
    }

    public int getNumbersCount() {
        return numbersCount;
    }

    public int getMinRange() {
        return minRange;
    }

    public int getMaxRange() {
        return maxRange;
    }
}