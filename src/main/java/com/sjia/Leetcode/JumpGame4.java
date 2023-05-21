package com.sjia.Leetcode;

import java.util.*;

public class JumpGame4 {
    // #1345. Jump Game IV  https://leetcode.com/problems/jump-game-iv/

    /*
    Given an array of integers arr, you are initially positioned at the first index of the array.

    In one step you can jump from index i to index:

    i + 1 where: i + 1 < arr.length.
    i - 1 where: i - 1 >= 0.
    j where: arr[i] == arr[j] and i != j.
    Return the minimum number of steps to reach the last index of the array.
     */

    /*
    Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
    Output: 3
    Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.

    Example 2:
    Input: arr = [7]
    Output: 0
    Explanation: Start index is the last index. You do not need to jump.

    Input: arr = [7,6,9,6,9,6,9,7]
    Output: 1
    Explanation: You can jump directly from index 0 to index 7 which is last index of the array.

     */

    // 1 <= arr.length <= 5 * 104
    // -10^8 <= arr[i] <= 10^8

    public static int minJumps(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }

        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            valueToIndices.computeIfAbsent(arr[i], ArrayList::new).add(i);
//            valueToIndices.computeIfAbsent(arr[i], v -> new ArrayList()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int jumps = 0;
        boolean[] visited = new boolean[arr.length];
        visited[0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int currentIndex = queue.poll();

                if (currentIndex == arr.length - 1) {
                    return jumps;
                }

                List<Integer> neighbors = valueToIndices.get(arr[currentIndex]);
                neighbors.add(currentIndex - 1);
                neighbors.add(currentIndex + 1);

                for (int neighborIndex : neighbors) {
                    if (neighborIndex >= 0 && neighborIndex < arr.length && !visited[neighborIndex]) {
                        queue.offer(neighborIndex);
                        visited[neighborIndex] = true;
                    }
                }

                neighbors.clear(); // Optimization to avoid revisiting indices with the same value
            }

            jumps++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        System.out.println("Minimum jumps: " + minJumps(arr1)); // Output: 3

        int[] arr2 = {7};
        System.out.println("Minimum jumps: " + minJumps(arr2)); // Output: 0

        int[] arr3 = {7, 6, 9, 6, 9, 6, 9, 7};
        System.out.println("Minimum jumps: " + minJumps(arr3)); // Output: 1

        int[] arr4 = {6, 1, 9};
        System.out.println("Minimum jumps: " + minJumps(arr4)); // Output: 2

        int[] arr5 = {11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13};
        System.out.println("Minimum jumps: " + minJumps(arr5)); // Output: 3
    }



}
