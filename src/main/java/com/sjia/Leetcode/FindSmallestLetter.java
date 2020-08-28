package com.sjia.Leetcode;

public class FindSmallestLetter {
    // #744. Find Smallest Letter Greater Than Target
    // https://leetcode.com/problems/find-smallest-letter-greater-than-target/
    // Letters also wrap around. For example,
    // if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'

    // Note: input is sorted
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Smallest Letter Greater Than Target.
    //Memory Usage: 39.7 MB, less than 79.45% of Java online submissions for Find Smallest Letter Greater Than Target.
    public char nextGreatestLetter(char[] letters, char target) {
        for (char c : letters) {
            if (c > target) return c;
        }
        return letters[0];
    }


}
