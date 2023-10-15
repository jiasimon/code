package com.sjia.Leetcode;

public class Rand10UsingRand7 {
    // #470. Implement Rand10() Using Rand7()   https://leetcode.com/problems/implement-rand10-using-rand7/

    /*
    Given the API rand7() that generates a uniform random integer in the range [1, 7], write a function rand10() that generates a uniform random integer in the range [1, 10].

    Input: n = 1    Output: [2]

    Input: n = 2    Output: [2,8]

    Input: n = 3    Output: [3,8,10]

    1 <= n <= 100000

     */


    // (rand7() - 1) * 7 + rand7()
    public int rand10() {
        int result = 0;

        while (true) {
            // Use the provided rand7() function to generate random numbers from 1 to 49
            result = (rand7() - 1) * 7 + rand7();

            // If the result is in the range [1, 40], return (result % 10) + 1
            if (result <= 40) {
                return (result % 10) + 1;
            }
        }
    }

    // Simulate the provided rand7() function
    public int rand7() {
        // Simulate generating a random integer from 1 to 7
        return (int) (Math.random() * 7) + 1;
    }


    // rand7() -> rand49() -> rand40() -> rand10()
    public int rand10_rand49_rand40() {
        int result = 40;
        while (result >= 40) {result = 7 * (rand7() - 1) + (rand7() - 1);}
        return result % 10 + 1;
    }

    public static void main(String[] args) {
        Rand10UsingRand7 solution = new Rand10UsingRand7();

        // Call rand10() to generate a random integer from 1 to 10
        int randomNum = solution.rand10();
        System.out.println("Random Number: " + randomNum);
    }
}
