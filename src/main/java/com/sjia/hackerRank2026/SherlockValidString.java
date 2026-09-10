package com.sjia.hackerRank2026;

import java.util.HashMap;
import java.util.Map;

public class SherlockValidString {
    // https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-sherlock-and-valid-string


    // map count each freq
    public static String isValid(String s) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        // Step 2: Count occurrences of each frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int count : charCounts.values()) {
            freqMap.put(count, freqMap.getOrDefault(count, 0) + 1);
        }

        // Case 1: All characters appear the same number of times
        if (freqMap.size() == 1) {
            return "YES";
        }

        // Case 2: More than 2 different frequencies cannot be fixed with 1 deletion
        if (freqMap.size() > 2) {
            return "NO";
        }

        // Case 3: Exactly 2 different frequencies
        int f1 = 0, f2 = 0;
        int count1 = 0, count2 = 0;
        int i = 0;

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (i == 0) {
                f1 = entry.getKey();
                count1 = entry.getValue();
            } else {
                f2 = entry.getKey();
                count2 = entry.getValue();
            }
            i++;
        }

        // Ensure f1 is the smaller frequency and f2 is the larger
        if (f1 > f2) {
            int tempF = f1; f1 = f2; f2 = tempF;
            int tempCount = count1; count1 = count2; count2 = tempCount;
        }

        // Option A: Lower frequency is 1 and occurs only once (e.g., aabbccz)
        if (f1 == 1 && count1 == 1) {
            return "YES";
        }

        // Option B: Higher frequency is 1 greater than lower frequency and occurs only once (e.g., aabbccc)
        if ((f2 - f1 == 1) && count2 == 1) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(isValid("abc"));      // Output: YES
        System.out.println(isValid("abcc"));     // Output: YES
        System.out.println(isValid("abccc"));    // Output: NO
        System.out.println(isValid("aabbcd"));   // Output: NO
        System.out.println(isValid("aabbccr"));  // Output: YES
    }

}
