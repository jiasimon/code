package com.sjia.Leetcode;

public class PerfectNumber {

    // #507 https://leetcode.com/problems/perfect-number/

    // Runtime: 1 ms, faster than 94.11% of Java online submissions for Perfect Number.
    //Memory Usage: 36.3 MB, less than 56.02% of Java online submissions for Perfect Number.
    public boolean checkPerfectNumber(int num) {
        if (num <=1 ) return false;
        int sum = 0;
        for (int i=1; i*i <=num; i++){
            if(num % i == 0) {
                sum += i;
                if (num/i !=i) sum += num/i;
            }
        }
        return sum == 2*num;

    }


    public static void main(String[] args) {
        int testData  = 28;  // 182
        PerfectNumber solution = new PerfectNumber();
        boolean result = solution.checkPerfectNumber(testData);

        System.out.printf("testData %s checkPerfectNumber is %s \n", testData,result);
    }

}
