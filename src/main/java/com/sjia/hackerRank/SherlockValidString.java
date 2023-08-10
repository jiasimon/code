package com.sjia.hackerRank;

import java.util.*;

public class SherlockValidString {
    public static String isValidSherlockValidString(String s) {
        // Write your code here
        int[] freq = new int[26];
        for ( char c : s.toCharArray()) {
            freq[ c - 'a']++;
        }
//        List<Integer> freqList = new ArrayList<>();

        List<Integer> freqList = new ArrayList<>();

        for ( int n: freq) {
            if (n != 0) {
                freqList.add(n);
            }
        }
        int size = freqList.size();
        if (size ==1 ) return "YES";
        Collections.sort(freqList);

/*
        if (freqList.get(0) == freqList.get(size-1)) {
            return "YES";
        }
        if (freqList.get(0) == freqList.get(1) && freqList.get(1) == freqList.get(size-2) && freqList.get(size-2)+1 == freqList.get(size-1)) {
            return "YES";
        }
        if (freqList.get(0) ==1 && freqList.get(1) == freqList.get(size-1)) {
            return "YES";
        }
        return "NO";
*/


        int first = freqList.get(0);
        int second = freqList.get(1);
        int secondLast = freqList.get(size-2);
        int last = freqList.get(size-1);

        // If first and last are same, then all frequencies are same
        if (first == last) return "YES";

        // If first is 1, and all other characters have 1 frequency
        if (first == 1 && second == last) return "YES";

        // If all are same and last character has just 1 extra count
        if (first == second && second == secondLast && secondLast == (last - 1)) return "YES";

        // Else invalid string
        return "NO";
    }


    public static void main(String[] args) {

//        String s1 = "abba";
//        System.out.println(s1 + " sherlockAndAnagrams: " + isValidSherlockValidString(s1));

        String s2 = "abba";
        System.out.println(s2 + " sherlockAndAnagrams: " + isValidSherlockValidString(s2));
    }

    }
