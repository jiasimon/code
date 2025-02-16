package com.sjia.Leetcode700;

public class FindSmallestLetter {
    // #744. Find Smallest Letter Greater Than Target   https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
    /*
Use Binary Search to find the smallest letter greater than target.
If such a letter is found, return it.
If not, return the first letter (letters[0]) due to the circular wrap-around condition.
     */

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] > target) {
                right = mid - 1; // Search in the left half
            } else {
                left = mid + 1; // Search in the right half
            }
        }

        // If left goes out of bounds, return the first letter (wrap-around case)
        return letters[left % letters.length];
    }

    public static void main(String[] args) {
        FindSmallestLetter solution = new FindSmallestLetter();

        // Test Cases
        char[] letters1 = {'c', 'f', 'j'};
        System.out.println(solution.nextGreatestLetter(letters1, 'a')); // Expected Output: 'c'

        char[] letters2 = {'c', 'f', 'j'};
        System.out.println(solution.nextGreatestLetter(letters2, 'c')); // Expected Output: 'f'

        char[] letters3 = {'c', 'f', 'j'};
        System.out.println(solution.nextGreatestLetter(letters3, 'd')); // Expected Output: 'f'

        char[] letters4 = {'c', 'f', 'j'};
        System.out.println(solution.nextGreatestLetter(letters4, 'j')); // Expected Output: 'c' (Wrap-around)

        char[] letters5 = {'a', 'b', 'c'};
        System.out.println(solution.nextGreatestLetter(letters5, 'z')); // Expected Output: 'a' (Wrap-around)
    }


}
