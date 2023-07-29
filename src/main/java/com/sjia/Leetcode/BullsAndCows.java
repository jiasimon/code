package com.sjia.Leetcode;

public class BullsAndCows {
    // #299. Bulls and Cows https://leetcode.com/problems/bulls-and-cows/description/
    /*
    The number of "bulls", which are digits in the guess that are in the correct position.
    The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position.

    Input: secret = "1807", guess = "7810"  Output: "1A3B"
    Explanation: Bulls are connected with a '|' and cows are underlined:
    "1807"
      |
    "7810"
     */

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] secretFreq = new int[10];
        int[] guessFreq = new int[10];

        for ( int i = 0 ; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if( s == g) {
                bulls++;
            } else {
                secretFreq[s - '0']++;
                guessFreq[g - '0']++;
            }
        }


        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretFreq[i], guessFreq[i]);
        }

        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        String secret = "1807";
        String guess = "7810";
        BullsAndCows solution = new BullsAndCows();
        String result = solution.getHint(secret, guess);
        System.out.println("The bulls and cows: " + result); // Output: The bulls and cows: 1A3B

        secret = "1123";
        guess = "0111";
        result = solution.getHint(secret, guess);
        System.out.println("The bulls and cows: " + result);  // 1A1B


    }


}
