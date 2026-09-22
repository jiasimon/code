package com.sjia.hackerRank2026;

import java.util.List;

public class AngryProfessor {
    // https://www.hackerrank.com/challenges/angry-professor

    public static String angryProfessor(int k, List<Integer> a) {
        int count =0;
        for (int num : a) {
            if (num <=0) count++;
        }
        if (count >= k) return "NO";
        else return "YES";
    }


}
