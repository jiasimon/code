package com.sjia.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class BuddyStrings {
    // #859 https://leetcode.com/problems/buddy-strings/

    // Input: A = "ab", B = "ab", Output: false
    // Input: A = "aa", B = "aa", Output: true
    // Input: A = "aaaaaaabc", B = "aaaaaaacb", Output: true
    // 0 <= A.length <= 20000
    // 0 <= B.length <= 20000
    // A and B consist only of lowercase letters.


    // Runtime: 2 ms, faster than 76.62% of Java online submissions for Buddy Strings.
    //Memory Usage: 40.4 MB, less than 10.77% of Java online submissions for Buddy Strings.
/*    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            if (A.length() > 26 ) return true;  // only of lowercase letters.
            int[] count = new int[26];
            for (int i=0; i < A.length(); i++) {
                count[ A.charAt(i) - 'a' ]++;
                if (count[ A.charAt(i) - 'a' ] > 1 ) return true;
            }
            return false;
        } else {    // only two positions can be different
            int x= -1, y= -1;
            for (int i=0; i< A.length(); i++) {
                if (A.charAt(i) !=B.charAt(i)) {
                    if (x== -1) x=i;
                    else if ( y ==-1) y=i;
                    else return false;
                }
            }
            return ( (y!= -1) && A.charAt(x)== B.charAt(y) && A.charAt(y) == B.charAt(x) );
        }

    }*/




    // Use Hashset to check duplicate
    // Runtime: 1 ms, faster than 98.92% of Java online submissions for Buddy Strings.
    //Memory Usage: 39.3 MB, less than 76.39% of Java online submissions for Buddy Strings.
    public boolean buddyStrings(String A, String B) {
        int len = A.length();
        if (len != B.length()) return false;
        if (A.equals(B)) {
            if (len > 26 ) return true;  // only of lowercase letters.
            Set<Character> count = new HashSet<>();
            for (char c : A.toCharArray()) {
                count.add(c);
            }
            return count.size() < len;
        } else {    // only two positions can be different
            int x= -1, y= -1;
            for (int i = 0; i< len; i++) {
                if (A.charAt(i) !=B.charAt(i)) {
                    if (x== -1) x=i;
                    else if ( y ==-1) y=i;
                    else return false;
                }
            }
            return ( (y!= -1) && A.charAt(x)== B.charAt(y) && A.charAt(y) == B.charAt(x) );
        }

    }



}
