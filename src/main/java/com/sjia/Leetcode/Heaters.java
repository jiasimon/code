package com.sjia.Leetcode;

import java.util.Arrays;

public class Heaters {
    // #475 https://leetcode.com/problems/heaters/

    // Runtime: 719 ms, faster than 7.44% of Java online submissions for Heaters.
    //Memory Usage: 42.8 MB, less than 67.21% of Java online submissions for Heaters.
/*
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int res = 0;
        int i = 0;
        for (int house : houses) {
            for (i = 0; i < heaters.length - 1; i++) {
                if (Math.abs(heaters[i] - house) < Math.abs(heaters[i + 1] - house)) {
                    break;
                }
            }

            res = Math.max(res, Math.abs(heaters[i] - house));
        }

        return res;
    }*/



    // Runtime: 6 ms, faster than 100.00% of Java online submissions for Heaters.
    //Memory Usage: 42.7 MB, less than 73.53% of Java online submissions for Heaters.

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0, res = 0;
        for (int house : houses) {
            while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= house * 2) {
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
        }

        return res;
    }

    public static void main(String[] args) {
        int[] houses = {474833169,264817709,998097157,817129560};
        int[] heaters = {197493099,404280278,893351816,505795335};
        Heaters solution = new Heaters();
        int result = solution.findRadius(houses, heaters);
        System.out.printf(" houses: %s  heaters %s , radious is: %s ", Arrays.toString(houses),
                Arrays.toString(heaters), result);


    }

}
