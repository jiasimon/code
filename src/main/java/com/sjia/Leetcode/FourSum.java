package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {

    // #18  4Sum  https://leetcode.com/problems/4sum/


    // [1000000000,1000000000,1000000000,1000000000], Wrong Answer, -294967296



    // Move i,j to remove dup
    // Runtime: 13 ms, faster than 77.03% of Java online submissions for 4Sum.
    // Memory Usage: 39.7 MB, less than 77.46% of Java online submissions for 4Sum.

    // add dup check condition at the beginning of i, j loop
    //Runtime: 10 ms, faster than 85.32% of Java online submissions for 4Sum.
    //Memory Usage: 39.7 MB, less than 80.85% of Java online submissions for 4Sum.

    static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);

        if (nums[0] * 4 > target) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if(i!=0 && nums[i]==nums[i-1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if(j!=i+1 && nums[j]==nums[j-1]) continue;
                int lo = j + 1, hi = nums.length - 1, tmp = target - nums[i] - nums[j];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == tmp) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < tmp) {
                        lo++;
                    } else {
                        hi--;
                    }
                    //while ( nums[j]==nums[j+1] && j < nums.length - 2) j++;
                }
                //while ( nums[i]==nums[i+1] && i < nums.length - 3)  i++;
            }

        }
        return res;
    }


    // HashSet for dup
    public static List<List<Integer>> fourSum2(int[] num, int target) {
        if (num.length < 3) return new ArrayList<>();
        Arrays.sort(num);

        //if (nums[0] * 4 > target) return new ArrayList<>();

        HashSet<ArrayList<Integer>> hSet = new HashSet<ArrayList<Integer>>();
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                for (int k = j + 1, l = num.length - 1; k < l;) {
//                    int sum = num[i] + num[j] + num[k] + num[l];
                    long sum = num[i];
                    sum += num[j];
                    sum += num[k];
                    sum += num[l];
                    if (sum > target) {
                        l--;
                    }
                    else if (sum < target) {
                        k++;
                    }
                    else if (sum == target) {
                        ArrayList<Integer> found = new ArrayList<Integer>();
                        found.add(num[i]);
                        found.add(num[j]);
                        found.add(num[k]);
                        found.add(num[l]);

                        hSet.add(found);

                        k++;
                        l--;

                    }
                }
            }
        }
        return new ArrayList<>(hSet);

    }



    public static void main(String[] args) {


        // int[] testData = {1, 0, -1, 0, -2, 2};
        // int[] testData  = {-3,-2,-1,0,0,1,2,3}; 0
        // int[] testData  = {1,-2,-5,-4,-3,3,3,5}; -11
        int[] testData  = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;

        List<List<Integer>> result = fourSum(testData, target);
        System.out.printf(" Four sum result is %s \n", result);

        int[] testData2  = {1000000000,1000000000,1000000000,1000000000};

        List<List<Integer>> result2 = fourSum2(testData2, target);

        System.out.printf(" Four sum result2 is %s \n", result2);
    }
}
