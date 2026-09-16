package com.sjia.hackerRank2026;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PickingNumbers {
    // https://www.hackerrank.com/challenges/picking-numbers

    // failed on (5, 2, 1, 3, 3)
    public static int pickingNumbers_incorrect(List<Integer> a) {
        // Write your code here
        int res=1, tmp =1;
        boolean flag=true;
        a.sort(Comparator.naturalOrder());
        for (int i=1; i < a.size(); i++) {
            if(a.get(i) == a.get(i-1)) {
                tmp++;
            } else if ( (a.get(i) == a.get(i-1) +1 ) && flag) {
                tmp++;
                flag = false;
            } else {
                res=Math.max(res, tmp);
                tmp=1;
                flag=true;
            }
        }
        // return res;
        return Math.max(res, tmp);
    }

    // Math.max(res, freq[i] + freq[i + 1])
    public static int pickingNumbers(List<Integer> a) {
        if (a.isEmpty()) return 0;

        // Per HackerRank constraints, values are 0..99
        int[] freq = new int[102];
        for (int num : a) {
            freq[num]++;
        }

        int res = 0;
        for (int i = 0; i < 101; i++) {
            res = Math.max(res, freq[i] + freq[i + 1]);
        }
        return res;
    }


    public static void main(String[] args) throws IOException {

        List<Integer> s = Arrays.asList(5, 2, 1, 3, 3);

        int result = PickingNumbers.pickingNumbers(s);

        System.out.print(result);

    }

}
