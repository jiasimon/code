package com.sjia.hackerRank2026;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CutSticks {
    // https://www.hackerrank.com/challenges/cut-the-sticks

    // use equals instead of !=
    public static List<Integer> cutTheSticks(List<Integer> arr) {
        List<Integer> res = new ArrayList<>();
        arr.sort(Comparator.naturalOrder());
        int n = arr.size();
        res.add(n);

        for (int i=1; i<n; i++) {
            if (!arr.get(i).equals(arr.get(i-1))) {
//            if (arr.get(i) != arr.get(i-1)) {
                res.add(n-i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Sample 1: expect [6, 4, 2, 1]
        List<Integer> test1 = new ArrayList<>(List.of(5, 4, 4, 2, 2, 8));
        System.out.println("Input:  " + test1);
        System.out.println("Output: " + cutTheSticks(test1));
        System.out.println("Expect: [6, 4, 2, 1]");
        System.out.println();

        // Sample 2: expect [8, 6, 4, 1]
        List<Integer> test2 = new ArrayList<>(List.of(1, 2, 3, 4, 3, 3, 2, 1));
        System.out.println("Input:  " + test2);
        System.out.println("Output: " + cutTheSticks(test2));
        System.out.println("Expect: [8, 6, 4, 1]");
        System.out.println();

        // Edge case: all sticks the same length -> single level
        List<Integer> test3 = new ArrayList<>(List.of(3, 3, 3));
        System.out.println("Input:  " + test3);
        System.out.println("Output: " + cutTheSticks(test3));
        System.out.println("Expect: [3]");
        System.out.println();

        // Edge case: single stick
        List<Integer> test4 = new ArrayList<>(List.of(5));
        System.out.println("Input:  " + test4);
        System.out.println("Output: " + cutTheSticks(test4));
        System.out.println("Expect: [1]");


        List<Integer> test5 = new ArrayList<>(List.of(1,2,3,4,5));
        System.out.println("Input:  " + test5);
        System.out.println("Output: " + cutTheSticks(test5));
        System.out.println("Expect: []");

    }


}
