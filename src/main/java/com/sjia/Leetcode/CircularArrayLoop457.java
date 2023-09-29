package com.sjia.Leetcode;

public class CircularArrayLoop457 {
    // #457. Circular Array Loop        https://leetcode.com/problems/circular-array-loop/description/
    /*
    You are playing a game involving a circular array of non-zero integers nums. Each nums[i] denotes the number of indices forward/backward you must move if you are located at index i:

    If nums[i] is positive, move nums[i] steps forward, and
    If nums[i] is negative, move nums[i] steps backward.

    A cycle in the array consists of a sequence of indices seq of length k where:

    Following the movement rules above results in the repeating index sequence seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
    Every nums[seq[j]] is either all positive or all negative.
    k > 1
    Return true if there is a cycle in nums, or false otherwise.

    Input: nums = [2,-1,1,2,2]      Output: true
    Explanation: The graph shows how the indices are connected. White nodes are jumping forward, while red is jumping backward.
    We can see the cycle 0 --> 2 --> 3 --> 0 --> ..., and all of its nodes are white (jumping in the same direction).

    Input: nums = [-1,-2,-3,-4,-5,6]    Output: false
    Explanation: The graph shows how the indices are connected. White nodes are jumping forward, while red is jumping backward.
    The only cycle is of size 1, so we return false.

    1 <= nums.length <= 5000
    -1000 <= nums[i] <= 1000
    nums[i] != 0

    Follow up: Could you solve it in O(n) time complexity and O(1) extra space complexity?
     */


    // slow fast pointer
    // 0 ms, 100%; 39.8 MB, 70%
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue; // Skip elements that are already marked as visited
            }

            int slow = i;
            int fast = getNextIndex(i, nums);

            // Check if there's a loop in the same direction
            while (nums[i] * nums[fast] > 0 && nums[i] * nums[getNextIndex(fast, nums)] > 0) {
                if (slow == fast) {
                    // Found a loop with length >= 1
                    if (slow == getNextIndex(slow, nums)) {
                        break; // Loop of length 1 is not valid
                    }
                    return true;
                }
                slow = getNextIndex(slow, nums);
                fast = getNextIndex(getNextIndex(fast, nums), nums);
            }

            // Mark the elements as visited
            int current = i;
            while (nums[current] * nums[getNextIndex(current, nums)] > 0) {
                int next = getNextIndex(current, nums);
                nums[current] = 0;
                current = next;
            }
        }

        return false;
    }


/*

    private int getNextIndex(int currentIndex, int[] nums) {
        int n = nums.length;
        return (currentIndex + nums[currentIndex] + n) % n;
    }
    */

    private int getNextIndex(int currentIndex, int[] nums) {
        int n = nums.length;
        int tmp =(currentIndex + nums[currentIndex] ) % n;
        return tmp >= 0 ? tmp: tmp+n;
    }

    public static void main(String[] args) {
        CircularArrayLoop457 solution = new CircularArrayLoop457();
//        int[] nums1 = {2, -1, 1, 2, 2};
//        int[] nums2 = {-1, 2};
//        int[] nums3 = {-2, 1, -1, -2, -2};

        int[] nums4 = {-2, -3, -9};

//        System.out.println(solution.circularArrayLoop(nums1)); // Output: true
//        System.out.println(solution.circularArrayLoop(nums2)); // Output: false
//        System.out.println(solution.circularArrayLoop(nums3)); // Output: false

        System.out.println(solution.circularArrayLoop(nums4)); // Output: false
    }



}
