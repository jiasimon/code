package com.sjia.Leetcode;

public class ReverseOnlyLetters {
    // #917 https://leetcode.com/problems/reverse-only-letters/
    // "ab-cd"  "dc-ba"
    // "a-bC-dEf-ghIj"  "j-Ih-gfE-dCba"
    // "Test1ng-Leet=code-Q!"   "Qedo1ct-eeLg=ntse-T!"

    // S.length <= 100
    // 33 <= S[i].ASCIIcode <= 122
    // S doesn't contain \ or "



    // Runtime: 5 ms, faster than 8.00% of Java online submissions for Reverse Only Letters.
    //Memory Usage: 37.8 MB, less than 48.67% of Java online submissions for Reverse Only Letters.
    public String reverseOnlyLetters(String S) {
        int j=S.length()-1;
        String res ="";
        for (int i=0; i < S.length(); i++) {
            if(Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j))) {
                    j--;
                }
                res += S.charAt(j--);
            } else {
                res += S.charAt(i);
            }
        }
        return res;
    }



}
