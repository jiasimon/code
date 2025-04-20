package com.sjia.Leetcode700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpecialBinaryString {
    // #761. Special Binary String https://leetcode.com/problems/special-binary-string/description/
    /*
    Input: s = "11011000"
    Output: "11100100"
    Explanation: The strings "10" [occuring at s[1]] and "1100" [at s[3]] are swapped.
    This is the lexicographically largest string possible after some number of swaps.

    1 <= s.length <= 50
    s[i] is either '0' or '1'.
    s is a special binary string.

    Parse the string to extract special substrings recursively.

    Sort these substrings in descending lexicographical order.

    Concatenate and return.
     */

    public String makeLargestSpecial(String s) {
        List<String> specials = new ArrayList<>();
        int count = 0, start = 0;

        for (int i = 0; i < s.length(); ++i) {
            count += s.charAt(i) == '1' ? 1 : -1;
            if (count == 0) {
                // s.substring(start + 1, i) is the inside part of the special string
                String inner = makeLargestSpecial(s.substring(start + 1, i));
                specials.add("1" + inner + "0");
                start = i + 1;
            }
        }

        // Sort in reverse (descending lexicographical) order
        Collections.sort(specials, Collections.reverseOrder());

        StringBuilder result = new StringBuilder();
        for (String str : specials) {
            result.append(str);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        SpecialBinaryString solution = new SpecialBinaryString();
        String s = "11011000";
        System.out.println(solution.makeLargestSpecial(s)); // Output: "11100100"
    }


}
