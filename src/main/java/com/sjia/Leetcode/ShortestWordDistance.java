package com.sjia.Leetcode;

import static java.lang.Math.abs;

public class ShortestWordDistance {

    // #243. Shortest Word Distance https://leetcode.com/problems/shortest-word-distance/   #premium
    // https://leetcode.ca/2016-07-30-243-Shortest-Word-Distance/

    /*
    Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2, return the shortest distance between these two words in the list.
    Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
    Output: 3

     */


    //
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int res = Integer.MAX_VALUE;

        for (int i =0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                index1 = i;
            } else if (words[i].equals(word2)) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                res = Math.min(res, Math.abs(index2 - index1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ShortestWordDistance shortestWordDistance = new ShortestWordDistance();

        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";
        System.out.println("Shortest distance: " + shortestWordDistance.shortestDistance(words, word1, word2)); // Output: 3

        word1 = "makes";
        word2 = "coding";
        System.out.println("Shortest distance: " + shortestWordDistance.shortestDistance(words, word1, word2)); // Output: 1
    }

}
