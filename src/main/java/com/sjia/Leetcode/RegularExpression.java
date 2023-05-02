package com.sjia.Leetcode;

public class RegularExpression {
    // #10 https://leetcode.com/problems/regular-expression-matching/
    // '.' Matches any single character.​​​​ '*' Matches zero or more of the preceding element.
    // Given an input string (s) and a pattern (p),
    // implement regular expression matching with support for '.' and '*' where:

    // Runtime: 43 ms, faster than 27.82% of Java online submissions for Regular Expression Matching.
    //Memory Usage: 39.3 MB, less than 5.05% of Java online submissions for Regular Expression Matching.
/*    public boolean isMatch(String s, String p) {
        return s.matches(p);
    }*/



    /*
    1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
    2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
    3, If p.charAt(j) == '*':
   here are two sub conditions:
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty


     */

    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }


    // https://leetcode-cn.com/problems/regular-expression-matching/solution/shou-hui-tu-jie-wo-tai-nan-liao-by-hyj8/

    // f[i][j] 表示 s 的前 i 个字符与 p 中的前 j 个字符是否能够匹配。在进行状态转移时，
    // 我们考虑 p 的第 j 个字符的匹配情况
    // 字母 + 星号的组合在匹配的过程中，本质上只会有两种情况：
    //
    //    匹配 s 末尾的一个字符，将该字符扔掉，而该组合还可以继续进行匹配；
    //
    //    不匹配字符，将该组合扔掉，不再进行匹配。
    //


    //

    public boolean isMatch2(String s, String p) {
        return isMatch(0,s,0,p);
    }
    private boolean isMatch(int i, String s, int j, String p) {
        int sn = s.length(), pn = p.length();
        if(j==pn) { // since * in p can match 0 of previous char, so empty string(i==sn) may match p
            return i==sn;
        }
        char pj = p.charAt(j);
        if(j+1<pn && p.charAt(j+1)=='*') { //match *, needs to look at the next char to repeate current char
            if(isMatch(i,s,j+2,p)) {
                return true;
            }
            while(i<sn && (pj == '.'||pj==s.charAt(i))) {
                if(isMatch(++i,s,j+2,p)) {
                    return true;
                }
            }
        } else if(i<sn && (s.charAt(i) == pj ||    //match char
                pj=='.')) {              //match dot
            return isMatch(i+1, s, j+1, p);
        }
        return false;
    }




    public static void main(String[] args) {
        // int range:  -2147483648～2147483647

//        String s = "baa";
//        String p = "ba*";

        String s = "baaccc";
        String p = "ba*c*";

        RegularExpression solution = new RegularExpression();

        boolean result = solution.isMatch2(s,p);

        System.out.printf(" input %s and %s RegularExpressionMatch: %b ", s,p, result);
    }



}
