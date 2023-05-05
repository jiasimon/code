package com.sjia.Leetcode;

import java.util.*;

public class ThreeSum {
    // #15 3Sum, ThreeSum  https://leetcode.com/problems/3sum/
    // Given an array nums of n integers, are there elements a, b, c in nums
    // such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.


    // 0 <= nums.length <= 3000, this condition updated to 3 <= nums.length <= 3000
    // -10^5 <= nums[i] <= 10^5



    //ArrayList, Runtime: 32 ms, faster than 51.21% of Java online submissions for 3Sum.
    //Memory Usage: 56.5 MB, less than 9.93% of Java online submissions for 3Sum.

    //LinkedList Runtime: 41 ms, faster than 38.43% of Java online submissions for 3Sum.
    //Memory Usage: 56.6 MB, less than 9.42% of Java online submissions for 3Sum.

    // add "if (num.length < 2 ) return new ArrayList<>();"
    // Runtime: 31 ms, faster than 53.37% of Java online submissions for 3Sum.
    //Memory Usage: 56.5 MB, less than 10.35% of Java online submissions for 3Sum.

    // if (num[0] > 0 || num[num.length -1] < 0 ) return new ArrayList<>();
    // Memory Usage: 43.4 MB, less than 74.51% of Java online submissions for 3Sum.
/*
    static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 2 ) return new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length-1] < 0 ) return new ArrayList<>();
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = n - 1;
            while (l < r) {
                if (nums[l] + nums[r] == 0 - nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l + 1] == nums[l]) l++;
                    while (l < r && nums[r - 1] == nums[r]) r--;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < 0 - nums[i]) {
                    l++;
                } else  {
                    r--;
                }
            }
        }
        return res;

    }*/




    // Runtime: 20 ms, faster than 68.84% of Java online submissions for 3Sum.
    //Memory Usage: 42.8 MB, less than 5.08% of Java online submissions for 3Sum.
    // Arrays.sort   two pointer
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = n - 1;
            while (l < r) {
                if (nums[l] + nums[r] == 0 - nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l + 1] == nums[l]) l++;
                    while (l < r && nums[r - 1] == nums[r]) r--;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < 0 - nums[i]) {
                    l++;
                } else  {
                    r--;
                }
            }
        }
        return res;
    }



    // HashSet
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

//        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> result=new HashSet<>();
        for (int i=0; i < n-2; i++) {
            int l = i+1, r = n-1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    result.add(tmp);
//                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                } else r--;
            }
        }
        return new ArrayList<>(result);
    }




    public static void main(String[] args) {

        // {-1, 0, 1, 2, -1, -4}
        // [ -1 -1 2 ][ -1 0 1 ]

        // int[] testData = {1, 1, 2, 4 ,8 ,10};
        int[] testData  = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(testData);

        System.out.printf(" Three sum result is %s \n", result);
    }

}
