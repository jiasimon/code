package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {
    // #970 https://leetcode.com/problems/powerful-integers/
    // 1 <= x <= 100
    // 1 <= y <= 100
    // 0 <= bound <= 10^6


    // Runtime: 1 ms, faster than 96.99% of Java online submissions for Powerful Integers.
    //Memory Usage: 36.9 MB, less than 87.72% of Java online submissions for Powerful Integers.
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < 20 && Math.pow(x, i) <= bound; i++){
            for (int j = 0; j < 20 && Math.pow(y, j) <= bound; j++) {
                int tmp = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (tmp <= bound) res.add(tmp);
            }
        }
        return new ArrayList<>(res);
    }
}
