package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueBinaryString {
    // #1980. Find Unique Binary String
    // https://leetcode.com/problems/find-unique-binary-string/description/?envType=daily-question&envId=2023-11-16

    /*
    Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.

    Input: nums = ["01","10"]       Output: "11"
    Input: nums = ["00","01"]       Output: "11"
    Input: nums = ["111","011","001"]   Output: "101"

    n == nums.length, 1 <= n <= 16
    nums[i].length == n
    nums[i] is either '0' or '1'.
    All the strings of nums are unique.
     */

    // Set<Integer> stream
    // 14 ms, 19.64%; 41.5 MB, 21.9%
    public String findDifferentBinaryString(String[] nums) {
        final int bitSize = nums[0].length();
        final int maxNum = 1 << bitSize;
        Set<Integer> numsSet = Arrays.stream(nums)
                .mapToInt(num -> Integer.parseInt(num, 2))
                .boxed()
                .collect(Collectors.toSet());

        for (int num = 0; num < maxNum; ++num)
            if (!numsSet.contains(num)) {
                System.out.println( num + " , " + Integer.toBinaryString(num));
                return String.format("%" + bitSize + "s", Integer.toBinaryString(num)).replace(' ', '0');
            }


        throw new IllegalArgumentException();

    }


    public static void main(String[] args) {
        UniqueBinaryString solution = new UniqueBinaryString();
        String[] nums = {"00", "01", "11"};

        String result = solution.findDifferentBinaryString(nums);
        System.out.println("Unique Binary String: " + result);

        String[] nums2 = {"001", "010", "111"};
        result = solution.findDifferentBinaryString(nums2);
        System.out.println("Unique Binary String: " + result);



    }

}
