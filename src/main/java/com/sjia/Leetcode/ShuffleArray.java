package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleArray {
    // #384. Shuffle an Array   https://leetcode.com/problems/shuffle-an-array/

    /*
    Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.

    Implement the Solution class:

    Solution(int[] nums) Initializes the object with the integer array nums.
    int[] reset() Resets the array to its original configuration and returns it.
    int[] shuffle() Returns a random shuffling of the array.

    1 <= nums.length <= 50
    -10^6 <= nums[i] <= 10^6
    All the elements of nums are unique.
     */


    // nums.clone()

    private int[] original;
    private int[] shuffled;
    private Random rand;

    public ShuffleArray(int[] nums) {
        original = nums.clone();
        shuffled = nums.clone();
        rand = new Random();

    }

    public int[] reset() {
        return original;
    }

    // Fisher-Yates Algorithm
    // 53 ms, 82.76%; 49.8 MB, 30.87%
    public int[] shuffle() {
        for ( int i = shuffled.length-1; i >0; i--) {
            int j = rand.nextInt(i + 1);
            swap(shuffled, i,j);
        }
        return shuffled;
    }


    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}


/*

// get a random number from a list
// 61ms, 11.61%; 49.5 MB, 62.1%
class ShuffleArray2 {


    private int[] original;
    private int[] shuffled;
    private Random rand;

    public ShuffleArray2(int[] nums) {
        original = nums.clone();
        shuffled = new int[nums.length];
        rand = new Random();

    }

    public int[] reset() {
        return original;
//        System.arraycopy(original, 0, shuffled, 0, shuffled.length);
//        return shuffled;
    }




    public int[] shuffle() {
        List<Integer> list = new ArrayList<>();

        for ( int n : original) {
            list.add(n);
        }

        for ( int i=0; i < original.length; i++) {
            int tmp = rand.nextInt(list.size());
            shuffled[i] = list.remove(tmp);
        }
        return shuffled;

    }


}

*/


/*
class Solution {
        private int[] original;
        private Random rand;

    public Solution(int[] nums) {
        original = nums.clone();
        rand = new Random();

    }

    public int[] reset() {
        return original;
    }

    public int[] shuffle() {
        int[] shuffled = original.clone();
        for ( int i = shuffled.length -1 ; i >=0 ; i--) {
            int j = rand.nextInt(i + 1) ;
            swap( shuffled, i, j);
        }
        return shuffled;

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
 */