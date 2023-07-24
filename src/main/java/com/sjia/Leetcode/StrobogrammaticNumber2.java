package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumber2 {
    // #247. Strobogrammatic Number II  https://grandyang.com/leetcode/247/
    /*
    Find all strobogrammatic numbers that are of length = n.
    n = 0:   none
    n = 1:   0, 1, 8
    n = 2:   11, 69, 88, 96
    n = 3:   101, 609, 808, 906, 111, 619, 818, 916, 181, 689, 888, 986
    n = 4:   1001, 6009, 8008, 9006, 1111, 6119, 8118, 9116, 1691, 6699, 8698, 9696, 1881, 6889, 8888, 9886, 1961, 6969, 8968, 9966
     */

    
    public List<String> findStrobogrammatic(int n) {
        return new ArrayList<>(Arrays.asList(""));
    }




    public static void main(String[] args) {
        StrobogrammaticNumber2 strobogrammaticNumber2 = new StrobogrammaticNumber2();

        int n = 2;
        System.out.println("Strobogrammatic numbers of length " + n + ": " + strobogrammaticNumber2.findStrobogrammatic(n));
        // Output: ["11","69","88","96"]

        n = 3;
        System.out.println("Strobogrammatic numbers of length " + n + ": " + strobogrammaticNumber2.findStrobogrammatic(n));
        // Output: ["101","609","808","906","111","619","818","916","181","689","888","986"]
    }



}
