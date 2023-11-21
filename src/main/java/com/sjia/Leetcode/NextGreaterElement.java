package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    // #496 https://leetcode.com/problems/next-greater-element-i/

    // Runtime: 8 ms, faster than 18.88% of Java online submissions for Next Greater Element I.
    //Memory Usage: 39.4 MB, less than 93.85% of Java online submissions for Next Greater Element I.
/*
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
    }*/


    // Use Hashmap for nums2
    // Runtime: 2 ms, faster than 99.16% of Java online submissions for Next Greater Element I.
    //Memory Usage: 39.5 MB, less than 85.34% of Java online submissions for Next Greater Element I.
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> m = new HashMap<>();

        for(int i = 0;i < nums2.length;i++) {
            m.put(nums2[i], i);
        }

        for(int i = 0;i < nums1.length;i++) {
            result[i] = -1;
            for(int j = m.get(nums1[i]) + 1;j < nums2.length;j++) {
                if(nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        return result;
    }


    // Use Stack
    // Runtime: 3 ms, faster than 90.64% of Java online submissions for Next Greater Element I.
    //Memory Usage: 39.9 MB, less than 48.90% of Java online submissions for Next Greater Element I.
/*
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        for (int num: nums2) {
            while( !stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for (int i=0; i<nums1.length; i++ ) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }*/


    public int[] nextGreaterElement_stack(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement solution = new NextGreaterElement();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] nextGreater = solution.nextGreaterElement(nums1, nums2);
        System.out.println("Next Greater Elements: " + Arrays.toString(nextGreater));
    }


}
