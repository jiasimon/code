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

/*
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

    }*/




    // Runtime: 5 ms, faster than 55.20% of Java online submissions for 3Sum Closest.
    //Memory Usage: 38.5 MB, less than 16.94% of Java online submissions for 3Sum Closest.

/*    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res =nums[0] + nums[1] + nums[2], n = nums.length;
        if (res >= target) return res;
        for (int i = 0; i < n -2 ; i++) {
            int l= i+1, r = n-1;
            if (nums[i] + nums[l] + nums[r] == target) return target;
            int tmp = Math.abs(target - res);
            while ( l < r ) {
                int sum = nums[i] + nums[l] + nums[r];
                int diff = Math.abs(target - sum);
                if (diff < tmp) {
                    tmp = diff;
                    res = sum;
                }
                if ( sum < target) l++;
                else r--;

            }
        }
        return res;
    }*/



    // Runtime: 4 ms, faster than 86.25% of Java online submissions for 3Sum Closest.
    //Memory Usage: 38.6 MB, less than 16.94% of Java online submissions for 3Sum Closest.
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res =nums[0] + nums[1] + nums[2], n = nums.length;
        if (res > target) return res;
        for (int i = 0; i < n -2 ; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int l= i+1, r = n-1;
            while ( l < r ) {
                int sum = nums[i] + nums[l] + nums[r];
                int diff = Math.abs(target - sum);
                if (diff == 0) return target;
                int min = Math.abs(target - res);
                if (diff < min) {
                    min = diff;
                    res = sum;
                }
                if ( sum < target) l++;
                else r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        //int[] testData = {1, 1, 2, 4 ,10 ,20};
        int[] testData  = {0,2,1,-3};
        ThreeSumCloset solution = new ThreeSumCloset();
        int result = solution.threeSumClosest(testData , 1);

        System.out.printf(" Three sum result is %s \n", result);
    }
}
