package com.sjia.Leetcode;

import java.util.Arrays;

public class SearchInsertPosition {

    // #35 Search Insert Position https://leetcode.com/problems/search-insert-position/

    // normal scan
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
    //Memory Usage: 41 MB, less than 5.54% of Java online submissions for Search Insert Position.

    // second run Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
    //Memory Usage: 40.9 MB, less than 9.35% of Java online submissions for Search Insert Position.

/*
    static int searchInsert(int[] nums, int target) {
        for (int i = 0; i< nums.length ; i++) {
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }*/


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
    //Memory Usage: 41 MB, less than 7.61% of Java online submissions for Search Insert Position.

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
    //Memory Usage: 39 MB, less than 74.10% of Java online submissions for Search Insert Position.

    static int searchInsert(int[] nums, int target) {
        if (nums.length == 0 ) return 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid-1;
            else left = mid+1;
        }
        return left;
    }


    public static int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while ( left <= right ) {
            int mid = left + (right-left)/2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) left = mid + 1;
            else right =mid -1;
        }

        // Target not found, return the position where it would be inserted
        return left;
    }



    // chat-gpt generated, incorrect
    public static int searchInsert3(int[] nums, int target) {
        int insertIndex = Arrays.stream(nums)
                .filter(num -> num < target)
                .reduce((a, b) -> b)
                .orElse(-1);
        return insertIndex ;
    }




    public static void main(String[] args) {
        int[] testData = {1,3,5,6};
        int[] testData2 = {1,3,5,6,8,15,20};
        int target = 5;
        int result = searchInsert3(testData, target);
        System.out.printf( "Number %d insert at : %d ", target, result);
    }

}
