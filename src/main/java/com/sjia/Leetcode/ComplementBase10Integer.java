package com.sjia.Leetcode;

public class ComplementBase10Integer {
    // #1009 https://leetcode.com/problems/complement-of-base-10-integer/
    // refer #476
    // For example, the complement of "101" in binary is "010" in binary.
    // For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.
    // Input: 5 Output: 2   5 is "101" in binary, with complement "010" in binary
    // Input: 7 Output: 0   7 is "111" in binary, with complement "000"
    // Input: 10 Output: 5
    // 0 <= N < 10^9


    // XOR
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Complement of Base 10 Integer.
    //Memory Usage: 35.5 MB, less than 5.03% of Java online submissions for Complement of Base 10 Integer.
    public int bitwiseComplement(int N) {
        int tmp = 1;
        while (N > tmp) {
            tmp = tmp *2 + 1;
        }
        return tmp ^ N;
    }



    

    public static void main(String[] args) {
        int testData  = 7;  // 182
        ComplementBase10Integer solution = new ComplementBase10Integer();
        int result = solution.bitwiseComplement(testData);

        System.out.printf("testData %s add digits is %s \n", testData,result);
    }

}
