package com.sjia.Leetcode;

public class ShortestDistanceCharacter {
    // #821 https://leetcode.com/problems/shortest-distance-to-a-character/
    // Input: S = "loveleetcode", C = 'e'
    // Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
    // S string length is in [1, 10000].
    // C is a single character, and guaranteed to be in string S.
    // All letters in S and C are lowercase.


    // Runtime: 1 ms, faster than 98.37% of Java online submissions for Shortest Distance to a Character.
    //Memory Usage: 39.5 MB, less than 78.27% of Java online submissions for Shortest Distance to a Character.
    public int[] shortestToChar(String S, char C) {
        int [] res = new int[S.length()];
        int lastpos = -10000 ;
        for (int i=0; i< S.length(); i++) {
            if(S.charAt(i) == C) {
                lastpos = i;
            }
            res[i] = i - lastpos;
        }

        lastpos = 20000;
        for (int i= S.length()-1; i>=0; i--) {
            if(S.charAt(i) == C) {
                lastpos = i;
            }
            res[i] = Math.min(res[i], lastpos-i);
        }
        return res;
    }


}
