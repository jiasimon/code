package com.sjia.Leetcode;

import java.util.Arrays;

public class Candy {
    // #135. Candy  https://leetcode.com/problems/candy/
    /*
    There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.
    Return the minimum number of candies you need to have to distribute the candies to the children.

    Input: ratings = [1,0,2]    Output: 5
    Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

    Input: ratings = [1,2,2]    Output: 4
    Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.

    n == ratings.length， 1 <= n <= 2 * 10^4
    0 <= ratings[i] <= 2 * 10^4

     */

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int [n];
        Arrays.fill(candies,1);

        // scan left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // scan right to left, from n-2
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int res = 0;
        for (int candy : candies){
            res += candy;
        }
        return res;
    }

    public static void main(String[] args) {
        Candy solution = new Candy();

        // Test case
        int[] ratings = {1, 0, 2};
        int result = solution.candy(ratings);

        // Print the result
        System.out.println("Total Number of Candies: " + result);  // Output: 5
    }


}
