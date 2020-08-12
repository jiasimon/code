package com.sjia.Leetcode;

public class NextGreaterElement {
    // #496 https://leetcode.com/problems/next-greater-element-i/

    // Runtime: 8 ms, faster than 18.88% of Java online submissions for Next Greater Element I.
    //Memory Usage: 39.4 MB, less than 93.85% of Java online submissions for Next Greater Element I.
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i=0; i< nums1.length; i++ ) {
            int j=0;

            for(;j<nums2.length;j++){
                if(nums2[j] == nums1[i]){
                    break;
                }
            }
            
            for (; j< nums2.length; j++) {
                if (nums2[j] >nums1[i] ) {
                    result[i]=nums2[j];
                    break;
                }
            }
            if ( j== nums2.length) {
                result[i]=-1;
            }
        }
        return result;
    }

}
