package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;

public class ThreeSumCloset {

    // #16 https://leetcode.com/problems/3sum-closest/

    // Constraints:
    //3 <= nums.length <= 10^3
    //-10^3 <= nums[i] <= 10^3
    //-10^4 <= target <= 10^4


    //Runtime: 3 ms, faster than 98.31% of Java online submissions for 3Sum Closest.
    //Memory Usage: 39.3 MB, less than 35.78% of Java online submissions for 3Sum Closest.


    static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closet = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] * 3 > target) return Math.min(closet, nums[i] + nums[i+1] + nums[i+2]);
            int lo = i+1, hi = nums.length-1, diff = Math.abs (target - closet);
            while (lo < hi) {
                int total = nums[i] + nums[lo] + nums[hi];
                int tmp = Math.abs(target - total);
                if (tmp == 0) return total;
                if (tmp < diff) {
                    diff = tmp;
                    closet = total;
                }
                if (total < target) lo++;
                else hi--;
            }

        }
        return closet;

    }


    public static void main(String[] args) {

        //int[] testData = {1, 1, 2, 4 ,10 ,20};
        int[] testData  = {0,2,1,-3};
        int result = threeSumClosest(testData , 1);

        System.out.printf(" Three sum result is %s \n", result);
    }
}
