package com.sjia.Leetcode;

public class TotalHammingDistance477 {
    // #477. Total Hamming Distance     https://leetcode.com/problems/total-hamming-distance/

    /*
    The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

    Given an integer array nums, return the sum of Hamming distances between all the pairs of the integers in nums.

    Input: nums = [4,14,2]      Output: 6
    Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
    showing the four bits relevant in this case).
    The answer will be:
    HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.


    Input: nums = [4,14,4]      Output: 4

    1 <= nums.length <= 10^4
    0 <= nums[i] <= 10^9
     */


    // res += countOnes * countZeros
    // 4 ms, 78.35%; 44.9 MB, 66.18%
    public int totalHammingDistance(int[] nums) {
        int totalDistance = 0;
        int n = nums.length;

        for (int i = 0; i < 32; i++) {
            int countOnes = 0;

            for (int num : nums) {
                countOnes += (num >> i) & 1;
            }

            int countZeros = n - countOnes;
            totalDistance += countOnes * countZeros;
        }

        return totalDistance;
    }


    public static void main(String[] args) {
        TotalHammingDistance477 solution = new TotalHammingDistance477();
        int[] nums = {4, 14, 2};

        int hammingDistance = solution.totalHammingDistance(nums);
        System.out.println("Total Hamming Distance: " + hammingDistance); // Output: 6
    }


}
