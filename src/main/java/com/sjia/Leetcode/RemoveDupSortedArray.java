package com.sjia.Leetcode;

public class RemoveDupSortedArray {

    // #26 Remove Duplicates from Sorted Array https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    // Runtime: 1 ms, faster than 39.75% of Java online submissions for Remove Duplicates from Sorted Array.
    //Memory Usage: 41.2 MB, less than 70.66% of Java online submissions for Remove Duplicates from Sorted Array.


    //{1,2,3,4,5,6}
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array.
    //Memory Usage: 41.2 MB, less than 76.86% of Java online submissions for Remove Duplicates from Sorted Array.

    static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length ==1) return 1;
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                if(q - p > 1) nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0; // i points to the last non-duplicate element
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {

        int[] testData = {0,0,1,1,1,2,2,3,3,4,5};
        int[] testData2 = {1,2,3,4,5,6};
        int result = removeDuplicates2(testData);

        System.out.println("Array non duplicate number total is: " + result);
    }

}
