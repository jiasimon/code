package com.sjia.hackerRank;

public class CommonChild {
    // https://www.hackerrank.com/challenges/common-child/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings

    /*
    CommonChildString
    s1= "ABCD"  S2="ABDC"
    common child string is "ABC", or same subsequence String; return 3
     */

    static int commonChild(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static int commonChild2(String s1, String s2) {
        // Write your code here
        int m = s1.length();
        // int n = s2.length();
        int[][] dp = new int[m+1][m+1];

        for ( int i=0; i <= m ; i++) {     // Note:  should be  "<="  instead of "<"
            for (int j=0; j <= m ; j++) {
                if(i==0 || j== 0 ) {
                    dp[i][j] = 0;
                } else if ( s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); // we may exclude last char from s1 or s2
                }
            }
        }
        return dp[m][m];

    }

    public static void main(String[] args) {

        String s1 = "HARRY";
        String s2 = "SALLY";
        int result = commonChild(s1, s2);
        System.out.println(s1 + " and " + s2 + " commonChild: " + commonChild2(s1, s2));

    }
}
