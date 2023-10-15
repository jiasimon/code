package com.sjia.Leetcode;

import java.util.*;

public class FindDisappearedNumbers {
    // #448. Find All Numbers Disappeared in an Array https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    // FindDisappearedNumbers448

    /*
    Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

    Input: nums = [4,3,2,7,8,2,3,1]     Output: [5,6]
    Input: nums = [1,1]                 Output: [2]
     */

    // Runtime: 18 ms, faster than 27.03% of Java online submissions for Find All Numbers Disappeared in an Array.
    //Memory Usage: 48.2 MB, less than 89.42% of Java online submissions for Find All Numbers Disappeared in an Array.
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i=0; i< nums.length; i++) {
            map.put(nums[i], true);
        }

        List<Integer> result = new ArrayList<>();

        for (int i=1; i<= nums.length; i++) {
            if (!map.containsKey(i)) result.add(i);
        }
        return result;
    }




    // index = Math.abs(n) -1;
    // 5 ms, 89.57%; 53.8 MB, 34.62%
    public List<Integer> findDisappearedNumbers_negative(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for ( int n : nums) {
            int index = Math.abs(n) -1;
            if(nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for ( int i =0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }

        return res;

    }






    public static void main(String[] args) {
        FindDisappearedNumbers solution = new FindDisappearedNumbers();
        int[] nums = {4, 3, 2, 7, 8, 2, 1};

        List<Integer> disappearedNumbers = solution.findDisappearedNumbers_negative(nums);
        System.out.println("Disappeared Numbers: " + disappearedNumbers); // Output: [5, 6]
    }


}
