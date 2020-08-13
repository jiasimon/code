package com.sjia.Leetcode;

import java.util.Arrays;

public class KeyboardRow {
    // #500 https://leetcode.com/problems/keyboard-row/


    // Runtime: 4 ms, faster than 12.10% of Java online submissions for Keyboard Row.
    //Memory Usage: 37.8 MB, less than 48.06% of Java online submissions for Keyboard Row.
    public String[] findWords(String[] words) {
        return Arrays.stream(words).filter(w -> w.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
                .toArray(String[]::new);

    }

    public static void main(String[] args) {
        String[] testData  = {"Hello", "Alaska", "Dad", "Peace"};
        KeyboardRow solution = new KeyboardRow();
        String[] result = solution.findWords(testData);

        System.out.printf("testData %s findWords is %s \n", Arrays.toString(testData),
                Arrays.toString(result));
    }

}

