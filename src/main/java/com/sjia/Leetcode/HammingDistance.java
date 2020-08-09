package com.sjia.Leetcode;

public class HammingDistance {
    // #461 https://leetcode.com/problems/hamming-distance/
    // Hamming distance between two integers is the number
    // of positions at which the corresponding bits are different
    // bit question

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Hamming Distance.
    //Memory Usage: 36.1 MB, less than 88.94% of Java online submissions for Hamming Distance.
/*
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }*/


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Hamming Distance.
    //Memory Usage: 35.9 MB, less than 97.23% of Java online submissions for Hamming Distance.
    public int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        return countOne(tmp) ;

    }

    private int countOne(int tmp) {
        int result =0;
        while (tmp != 0) {
            tmp = tmp &(tmp-1);
            result++;
        }
        return result;
    }


    public static void main(String[] args) {
        int testData  = 1;  // 182
        int testData2 = 8;
        HammingDistance solution = new HammingDistance();
        int result = solution.hammingDistance(testData, testData2);

        System.out.printf("testData %s and %s hammingDistance is %s \n", testData,testData2, result);
    }

}
