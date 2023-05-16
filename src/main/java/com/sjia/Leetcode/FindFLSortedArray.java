package com.sjia.Leetcode;

import java.util.Arrays;

public class FindFLSortedArray {

    // #34 https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

    // FindFirstLastSortedArray
    // If target is not found in the array, return [-1, -1].
    // 0 <= nums.length <= 10^5
    // -10^9 <= nums[i] <= 10^9
    // nums is a non-decreasing array.
    // -10^9 <= target <= 10^9


    // j=nums.length  while (i<j)


    public static int[] searchRange(int[] nums, int target) {
        int [] res = {-1, -1};
        if (nums.length < 1) return res;
        if (nums.length  == 1) return nums[0] == target ? new int[] {0,0} : res;
        res[0] = binarySearch(nums, target);
        if (res[0] == -1) return res;
        res[1] = binarySearchRightBound(nums, target) -1;
        return res;

    }


    private static int binarySearch(int[] nums, int target) {
        int i=0, j=nums.length;
        while (i < j) {
            int mid = i + (j-i)/2;
            if (nums[mid] >= target) j = mid;
            else i = mid+1;
        }
        return i;
    }


    private static int binarySearchRightBound(int[] nums, int target) {
        int i=0, j=nums.length;
        while (i < j) {
            int mid = i + (j-i)/2;
            if (nums[mid] > target) j = mid;
            else i = mid+1;
        }
        return i;
    }



    // normal scan ,two pointer
    // Runtime: 1 ms, faster than 15.78% of Java online submissions for Find First and Last Position of Element in Sorted Array.
    //Memory Usage: 44 MB, less than 5.51% of Java online submissions for Find First and Last Position of Element in Sorted Array.

    public static int[] searchRange2(int[] nums, int target) {
        int [] res = {-1, -1};
        if (nums.length < 1) return res;
//        if (nums.length  == 1) return nums[0] == target ? new int[] {0,0} : res;
        int l =0, r = nums.length-1;
        while ( l <= r) {
            if(nums[l] != target) l++;
            else  {
                res[0] = l;
                break;
            }
        }
        while (r >= l) {
            if(nums[r] != target) r--;
            else {
                res[1] = r;
                break;
            }
        }
        return res;

    }



    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
    //Memory Usage: 42.6 MB, less than 72.07% of Java online submissions for Find First and Last Position of Element in Sorted Array.

    // Need follow up.


/*    static int[] searchRange(int[] nums, int target) {
        int [] result = {-1 ,-1};
        int [] single = {1,1};
        if (nums.length == 0) return result;
        if (nums.length == 1) return nums[0] == target ? single:result;
        int l = 0, r = nums[nums.length-1];

        int left = twoDivide(nums, target, true);
        if (left == nums.length || nums[left] != target) {
            return result;
        }

        result[0] = left;
        result[1] = twoDivide(nums, target, false)-1;

        return result;

        }


        static int twoDivide(int[] nums, int target, boolean flag) {
            int lo = 0;
            int hi = nums.length;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] > target || (flag && target == nums[mid])) { // when left, flag is true
                    hi = mid;
                }
                else {
                    lo = mid+1;
                }
            }

            return lo;
        }*/



    public static void main(String[] args) {
        int[] testData2 = {5,7,7,8,8,10};
        int[] testData = {7};
        int target = 7;
        int[] result = searchRange2(testData, target);
        System.out.println( "Number " + target + " result is: " + Arrays.toString(result));
    }


}
