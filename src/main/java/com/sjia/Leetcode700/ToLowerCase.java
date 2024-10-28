package com.sjia.Leetcode700;

public class ToLowerCase {
    // #709. To Lower Case  https://leetcode.com/problems/to-lower-case/description/
    /*
    Input: s = "Hello"  Output: "hello"

    1 <= s.length <= 100
    s consists of printable ASCII characters.
     */

    public String toLowerCase(String str) {
        final int diff = 'A' - 'a';

        char[] ans = str.toCharArray();

        for (int i = 0; i < ans.length; ++i)
            if (ans[i] >= 'A' && ans[i] <= 'Z')
                ans[i] -= diff;

        return new String(ans);

    }



    public static void main(String[] args) {
        ToLowerCase solution = new ToLowerCase();

        // Test Case 1: Simple string with uppercase letters
        String input1 = "Hello";
        System.out.println(solution.toLowerCase(input1));  // Output: "hello"

        // Test Case 2: Mixed case with symbols
        String input2 = "Java123!";
        System.out.println(solution.toLowerCase(input2));  // Output: "java123!"

        // Test Case 3: String with no uppercase letters
        String input3 = "world";
        System.out.println(solution.toLowerCase(input3));  // Output: "world"

        // Test Case 4: Empty string
        String input4 = "";
        System.out.println(solution.toLowerCase(input4));  // Output: ""
    }
}
