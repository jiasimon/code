package com.sjia.Leetcode;

public class ShortestWordDistance3 {
    // #245. Shortest Word Distance III https://grandyang.com/leetcode/245/
    /*
    Given a list of words and two words  word1  and  word2 , return the shortest distance between these two words in the list.
    word1  and  word2  may be the same and they represent two individual words in the list.
     */


    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int res = Integer.MAX_VALUE;
        boolean sameWords = word1.equals(word2);

        for (int i =0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                if ( sameWords) {
                    index1 = index2;
                    index2 = i;

                } else {
                    index1 = i;
                }

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
        ShortestWordDistance3 shortestWordDistance3 = new ShortestWordDistance3();

        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println("Shortest distance: " + shortestWordDistance3.shortestWordDistance(words, "coding", "practice")); // Output: 3
        System.out.println("Shortest distance: " + shortestWordDistance3.shortestWordDistance(words, "makes", "coding")); // Output: 1
        System.out.println("Shortest distance: " + shortestWordDistance3.shortestWordDistance(words, "makes", "makes")); // Output: 3


    }

}
