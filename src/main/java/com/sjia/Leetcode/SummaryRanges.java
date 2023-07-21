package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    // #228. Summary Ranges https://leetcode.com/problems/summary-ranges/description/
    /*
    A range [a,b] is the set of all integers from a to b (inclusive).

    Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

    Each range [a,b] in the list should be output as:

    "a->b" if a != b
    "a" if a == b

    Input: nums = [0,1,2,4,5,7]     Output: ["0->2","4->5","7"]
    Input: nums = [0,2,3,4,6,8,9]   Output: ["0","2->4","6","8->9"]

     */


    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        int start = nums[0];
        int end = nums[0];
        for (int i=1; i < nums.length; i++) {
            if (nums[i] != end + 1) {
                if (start == end) {
                    result.add(start + "");
                } else {
                    result.add(start + "->" + end);
                }
                start = nums[i];
            }
            end = nums[i];
        }
        // out of loop, do not forget last range
        if (start == end) {
            result.add(start + "");
        } else {
            result.add(start + "->" + end);
        }
        return result;
    }



    // Test the code
    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();

        int[] nums = {0, 1, 2, 4, 5, 7}; // Output: ["0->2","4->5","7"]
        System.out.println(summaryRanges.summaryRanges(nums));

        int[] nums2 = {0, 2, 3, 4, 6, 8, 9}; // Output: ["0","2->4","6","8->9"]
        System.out.println(summaryRanges.summaryRanges(nums2));
    }
}
