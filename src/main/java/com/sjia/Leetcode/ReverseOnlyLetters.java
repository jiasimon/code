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
/*    public String reverseOnlyLetters(String S) {
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
    }*/


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Only Letters.
    // Memory Usage: 37.6 MB, less than 68.78% of Java online submissions for Reverse Only Letters.
    public String reverseOnlyLetters(String S) {
        int j=S.length()-1;
        StringBuilder res = new StringBuilder();
        for (int i=0; i < S.length(); i++) {
            if(Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j))) {
                    j--;
                }
                res.append(S.charAt(j--));
            } else {
                res.append(S.charAt(i)) ;
            }
        }
        return res.toString();
    }


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Only Letters.
    //Memory Usage: 37.4 MB, less than 82.84% of Java online submissions for Reverse Only Letters.
/*    public String reverseOnlyLetters(String S) {
        int j=S.length()-1;
        StringBuilder res = new StringBuilder();
        char[] tmp = S.toCharArray();
        for (int i=0; i < S.length(); i++) {
            if(Character.isLetter(tmp[i])) {
                while (!Character.isLetter(tmp[j])) {
                    j--;
                }
                res.append(tmp[j--]);
            } else {
                res.append(tmp[i]) ;
            }
        }
        return res.toString();
    }*/


}
