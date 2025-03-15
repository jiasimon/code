package com.sjia.Leetcode700;

import java.util.HashSet;
import java.util.Set;

public class CrackingSafe {
    // #753. Cracking the Safe  https://leetcode.com/problems/cracking-the-safe/description/
    /*

    Return any string of minimum length that will unlock the safe at some point of entering it.
    Input: n = 1, k = 2     Output: "10"
    Explanation: The password is a single digit, so enter each digit. "01" would also unlock the safe.

    Input: n = 2, k = 2     Output: "01100"
    Output: "01100"
Explanation: For each possible password:
- "00" is typed in starting from the 4th digit.
- "01" is typed in starting from the 1st digit.
- "10" is typed in starting from the 3rd digit.
- "11" is typed in starting from the 2nd digit.

To solve this problem, we can utilize the concept of constructing an Eulerian path in a De Bruijn graph:
	1. De Bruijn Graph Construction:
		○ Each node represents a sequence of n−1n-1n−1digits.
		○ Each directed edge represents an additional digit appended to the sequence, forming a new combination of length nnn.
	2. Eulerian Path:
		○ An Eulerian path traverses every edge in the graph exactly once.
		○ Constructing such a path ensures that all possible combinations are covered in the shortest sequence.
	3. Depth-First Search (DFS):
Perform a DFS to construct the Eulerian path, appending digits to form the desired sequence.

     */

    public String crackSafe(int n, int k) {
        if (n == 1 && k == 1) return "0";

        StringBuilder result = new StringBuilder();
        Set<String> visited = new HashSet<>();
//        String start = "0".repeat(n - 1);

        StringBuilder sb = new StringBuilder(n - 1); // Initialize with capacity for efficiency
        for (int i = 0; i < n - 1; i++) {
            sb.append('0');
        }
        String start = sb.toString();

        dfs(start, k, visited, result);
        result.append(start);

        return result.toString();
    }

    private void dfs(String node, int k, Set<String> visited, StringBuilder result) {
        for (int i = 0; i < k; i++) {
            String neighbor = node + i;
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                dfs(neighbor.substring(1), k, visited, result);
                result.append(i);
            }
        }
    }

    public static void main(String[] args) {
        CrackingSafe solution = new CrackingSafe();
        System.out.println(solution.crackSafe(1, 2)); // Output: "01"
        System.out.println(solution.crackSafe(2, 2)); // Output: "00110" or any valid sequence
    }



}
