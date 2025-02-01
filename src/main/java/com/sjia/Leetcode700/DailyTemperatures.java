package com.sjia.Leetcode700;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {
    // #739. Daily Temperatures     https://leetcode.com/problems/daily-temperatures/description/
    /*
The optimal approach involves using a stack to efficiently track the indices of temperatures for which we haven't found a warmer day yet.
Approach

    Stack Utilization: We use a stack to keep track of indices of the temperatures array. The stack helps us efficiently find the next warmer day by comparing the current temperature with the temperatures at the indices stored in the stack.

    Iterate Through Temperatures: For each temperature in the array, we check if it is warmer than the temperature at the index stored at the top of the stack. If it is, we pop the index from the stack and calculate the number of days until the warmer temperature, updating the result array accordingly.

    Result Update: Each time we find a warmer temperature, we update the result array at the popped index with the difference between the current index and the popped index, which gives the number of days waited.

     */

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return answer;
    }


    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();

        // Test case 1
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures1)));
        // Expected Output: [1, 1, 4, 2, 1, 1, 0, 0]

        // Test case 2
        int[] temperatures2 = {30, 40, 50, 60};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures2)));
        // Expected Output: [1, 1, 1, 0]

        // Test case 3
        int[] temperatures3 = {30, 60, 90};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures3)));
        // Expected Output: [1, 1, 0]
    }

}
