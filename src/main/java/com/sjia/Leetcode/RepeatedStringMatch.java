package com.sjia.Leetcode;

public class RepeatedStringMatch {
    // #686 https://leetcode.com/problems/repeated-string-match/

    // Runtime: 518 ms, faster than 18.19% of Java online submissions for Repeated String Match.
    //Memory Usage: 39.9 MB, less than 20.78% of Java online submissions for Repeated String Match.
    public int repeatedStringMatch(String A, String B) {
        int a = A.length(), b = B.length();
        StringBuilder sb = new StringBuilder();
        for (int i=1; i <= b/a + 2; i++) {
            sb.append(A);
            if(i>= b/a && sb.toString().contains(B)) return i;
        }
        return -1;
    }
}
