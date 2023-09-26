package com.sjia.Leetcode;

public class PassThePillow2582 {
    // #2582. Pass the Pillow   https://leetcode.com/problems/pass-the-pillow/
    /*
    There are n people standing in a line labeled from 1 to n. The first person in the line is holding a pillow initially. Every second, the person holding the pillow passes it to the next person standing in the line. Once the pillow reaches the end of the line, the direction changes, and people continue passing the pillow in the opposite direction.

    For example, once the pillow reaches the nth person they pass it to the n - 1th person, then to the n - 2th person and so on.
    Given the two positive integers n and time, return the index of the person holding the pillow after time seconds.

    Input: n = 4, time = 5      Output: 2
    Explanation: People pass the pillow in the following way: 1 -> 2 -> 3 -> 4 -> 3 -> 2.

    Input: n = 3, time = 2      Output: 3


    Input: n = 6, time = 3      Output: 4
    1 -> 2 -> 3 -> 4 -> 5 -> 6

    Input: n = 6, time = 8      Output: 3
    1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 5 -> 4 -> 3

    2 <= n <= 1000
    1 <= time <= 1000

     */


    // math, find the pattern, n-1, 2*n - t - 1
    // 0 ms, 100%; 39.3 MB, 39.57%
    public int findPillowHolder(int n, int time) {
        int t = time %(2*n-2);
        if ( t < n ) {
            return t+1;
        } else {
            return 2*n - t - 1 ;
        }


    }

    public static void main(String[] args) {
        PassThePillow2582 solution = new PassThePillow2582();
        int n = 4;
        int time = 5;
        int result = solution.findPillowHolder(n, time);
        System.out.println("The pillow holder after " + time + " seconds is person " + result); // Output: 2
    }

}
