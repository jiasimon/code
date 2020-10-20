package com.sjia.Leetcode;

public class RemoveAdjacentDuplicates {
    // #1047 https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
    // Given a string S of lowercase letters,
    // a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
    // Input: "abbaca"  Output: "ca"


    // sb.deleteCharAt(sb.length()-1)
    // Runtime: 7 ms, faster than 88.93% of Java online submissions for Remove All Adjacent Duplicates In String.
    //Memory Usage: 39.8 MB, less than 5.06% of Java online submissions for Remove All Adjacent Duplicates In String.
/*    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c: S.toCharArray()) {
            if(sb.length()>0 && c== sb.charAt(sb.length()-1)) {
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }*/



    // two pointers, i for original
    // Runtime: 3 ms, faster than 99.58% of Java online submissions for Remove All Adjacent Duplicates In String.
    //Memory Usage: 39.5 MB, less than 5.06% of Java online submissions for Remove All Adjacent Duplicates In String.
    public String removeDuplicates(String S) {
        int j=0, n=S.length();
        char[] res = S.toCharArray();
        for (int i=0; i<n; i++, j++) {
            res[j] = res[i];
            if( j > 0 && res[j]==res[j-1]) {  // when duplicate =2
                j -= 2;
            }
        }
        return new String(res,0,j);
    }


}
