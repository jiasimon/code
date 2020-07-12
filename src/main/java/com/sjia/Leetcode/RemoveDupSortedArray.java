package com.sjia.Leetcode;

public class RemoveDupSortedArray {

    // #25 https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    // Runtime: 1 ms, faster than 39.75% of Java online submissions for Remove Duplicates from Sorted Array.
    //Memory Usage: 41.2 MB, less than 70.66% of Java online submissions for Remove Duplicates from Sorted Array.

    

    static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length ==1) return 1;
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }

    public static void main(String[] args) {

        int[] testData  = {0,0,1,1,1,2,2,3,3,4,5};
        int result = removeDuplicates(testData);

        System.out.println("Array non duplicate number total is: " + result);
    }

}
