package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumber2 {
    // #247. Strobogrammatic Number II  https://grandyang.com/leetcode/247/ #premium
    /*
    Find all strobogrammatic numbers that are of length = n.
    n = 0:   none
    n = 1:   0, 1, 8
    n = 2:   11, 69, 88, 96
    n = 3:   101, 609, 808, 906, 111, 619, 818, 916, 181, 689, 888, 986
    n = 4:   1001, 6009, 8008, 9006, 1111, 6119, 8118, 9116, 1691, 6699, 8698, 9696, 1881, 6889, 8888, 9886, 1961, 6969, 8968, 9966
     */


    public List<String> findStrobogrammatic(int n) {
        return findStrobogrammaticHelper(n, n);
    }

    // f(n-2, m) if ( n != m) res.add("0" + s + "0");
    private List<String> findStrobogrammaticHelper(int n, int m) {
        if ( n== 0) {
            return new ArrayList<>(Arrays.asList(""));
        }
        if ( n== 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }

        List<String> res = new ArrayList<>();

        List<String> inner = findStrobogrammaticHelper(n - 2, m);

        for ( String s : inner) {
            // add "0" and "0" to the left and right  of the numbers if n is not equal to m
            if ( n != m) {
                res.add("0" + s + "0");
            }
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;

    }


    public static void main(String[] args) {
        StrobogrammaticNumber2 strobogrammaticNumber2 = new StrobogrammaticNumber2();

        int n = 4;
        System.out.println("Strobogrammatic numbers of length " + n + ": " + strobogrammaticNumber2.findStrobogrammatic(n));
        // Output: ["11","69","88","96"]

        n = 3;
        System.out.println("Strobogrammatic numbers of length " + n + ": " + strobogrammaticNumber2.findStrobogrammatic(n));
        // Output: ["101","609","808","906","111","619","818","916","181","689","888","986"]
    }



}
