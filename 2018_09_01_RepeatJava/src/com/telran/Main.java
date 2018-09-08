package com.telran;

public class Main {
    public static void main(String[] args) {
        String s = "aabbbcdeeeee";
        int result = checkLongest(s);
        System.out.println(result);

        String result1 = checkLongestAndReturnString(s);
        System.out.println(result1);
    }

    public static int checkLongest(String s) {
        String currentLetter = null;
        int amountOfLettersInRow = 0;
        int maxAmountOfLettersInRow = 0;
        String[] letters = s.split("");
        currentLetter = letters[0];
        for (int i = 0; i<letters.length; i++) {
            String c = letters[i];
            if(c.equals(currentLetter)) {
                amountOfLettersInRow++;
                if(maxAmountOfLettersInRow < amountOfLettersInRow) {
                    maxAmountOfLettersInRow = amountOfLettersInRow;
                }
            }
            if(!c.equals(currentLetter)) {
                amountOfLettersInRow = 1;
                currentLetter = c;
            }
        }
        return maxAmountOfLettersInRow;
    }

    public static String checkLongestAndReturnString(String s) {
        StringBuilder builder = new StringBuilder();
        String longestString = "";
        String currentLetter = null;
        String[] letters = s.split("");
        currentLetter = letters[0];
        for (int i = 0; i<letters.length; i++) {
            String c = letters[i];
            if(c.equals(currentLetter)) {
                builder.append(c);
                if(longestString.length() < builder.toString().length()) {
                    longestString = builder.toString();
                }
            }
            if(!c.equals(currentLetter)) {
                builder.setLength(0);
                currentLetter = c;
                builder.append(c);
            }
        }
        return longestString;
    }

}
/*
*HW:
*  how to make singleton threadsafe
*   1. initialize instance
*   2. synchronized
*
*  Patterns :
*   Inversion of Control
*   DI - dependency injection
*
*   Factory, AbstractFactory
*
*   shallow copy, clone
*
*   book: clean code, robert c. martin
 */
