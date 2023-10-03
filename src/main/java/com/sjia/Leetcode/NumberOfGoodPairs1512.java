package com.sjia.Leetcode;

public class NumberOfGoodPairs1512 {
    // #1512. Number of Good Pairs      https://leetcode.com/problems/number-of-good-pairs/description/?envType=daily-question&envId=2023-10-03
    /*
    Given an array of integers nums, return the number of good pairs.

    A pair (i, j) is called good if nums[i] == nums[j] and i < j.

    Input: nums = [1,2,3,1,1,3]     Output: 4
    Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

    Input: nums = [1,1,1,1]         Output: 6
    Explanation: Each pair in the array are good.

    1 <= nums.length <= 100
    1 <= nums[i] <= 100
     */


    // count[num]++, n(n-1)/2
    // 0 ms, 100%; 40 MB, 34.90%
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101]; // Assuming the range of values is [1, 100]
        int res = 0;

        // Count the occurrences of each number in the array
        for (int num : nums) {
            count[num]++;
        }

        // Calculate the number of good pairs for each number that occurs more than once
        for (int i = 1; i <= 100; i++) {
            if (count[i] > 1) {
                // n choose 2 formula for counting pairs: n(n-1)/2
                res += (count[i] * (count[i] - 1)) / 2;
            }
        }

        return res;
    }


    // two loops, j=i+1
    //
    public int numIdenticalPairs_twoFor(int[] nums) {
        int res =0;
        for (int i=0; i < nums.length; i++){
            for (int j=i+1; j < nums.length; j++) {
                if (nums[j] == nums[i]) res++;
            }
        }
        return res;

    }


    public static void main(String[] args) {
        NumberOfGoodPairs1512 solution = new NumberOfGoodPairs1512();
        int[] nums = {1, 2, 3, 1, 1, 3};
        int goodPairs = solution.numIdenticalPairs(nums);
        System.out.println("Number of good pairs: " + goodPairs); // Output: 4
    }

}
