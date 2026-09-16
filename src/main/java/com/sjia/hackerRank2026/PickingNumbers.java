package com.sjia.hackerRank2026;

import java.util.Comparator;
import java.util.List;

public class PickingNumbers {
    // https://www.hackerrank.com/challenges/picking-numbers

    public static int pickingNumbers(List<Integer> a) {
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

}
