package com.sjia.Leetcode700;

import java.util.Stack;

public class AsteroidCollision {
    // #735. Asteroid Collision     https://leetcode.com/problems/asteroid-collision/description/
    /*
    Input: asteroids = [5,10,-5]    Output: [5,10]
    Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

    Input: asteroids = [8,-8]   Output: []
    Explanation: The 8 and -8 collide exploding each other.

    Use a stack to keep track of the surviving asteroids.
    Traverse the array:

    Add positive asteroids directly to the stack.
    For negative asteroids:
        Compare with the top of the stack (only positive asteroids need to be checked).
        Resolve collisions by size and update the stack accordingly.

     */

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            // Handle collisions for negative asteroids
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int top = stack.peek();
                // If both are equal, destroy both
                if (Math.abs(asteroid) == top) {
                    stack.pop();
                    asteroid = 0; // Mark current asteroid as destroyed
                } else if (Math.abs(asteroid) > top) {
                    stack.pop(); // Destroy the top asteroid
                } else {
                    asteroid = 0; // Current asteroid is destroyed
                }
            }

            // Add the asteroid to the stack if it's not destroyed
            if (asteroid != 0) {
                stack.push(asteroid);
            }
        }

        // Convert the stack to an array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        AsteroidCollision solution = new AsteroidCollision();

        // Test Case 1
        int[] asteroids1 = {5, 10, -5};
        int[] result1 = solution.asteroidCollision(asteroids1);
        printArray(result1); // Expected: [5, 10]

        // Test Case 2
        int[] asteroids2 = {8, -8};
        int[] result2 = solution.asteroidCollision(asteroids2);
        printArray(result2); // Expected: []

        // Test Case 3
        int[] asteroids3 = {10, 2, -5};
        int[] result3 = solution.asteroidCollision(asteroids3);
        printArray(result3); // Expected: [10]

        // Test Case 4
        int[] asteroids4 = {-2, -1, 1, 2};
        int[] result4 = solution.asteroidCollision(asteroids4);
        printArray(result4); // Expected: [-2, -1, 1, 2]
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


}
