package com.sjia.Leetcode;

public class LicenseKeyFormatting {
    // #482 https://leetcode.com/problems/license-key-formatting/
    // Given a number K, we want to reformat the strings such that each group contains exactly K characters,
    // except for the first group which could be shorter than K

    // Runtime: 10 ms, faster than 82.04% of Java online submissions for License Key Formatting.
    //Memory Usage: 39.4 MB, less than 90.21% of Java online submissions for License Key Formatting.
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder tmp = new StringBuilder();
        for (int i=S.length()-1; i>=0; i--) {
            if(S.charAt(i) != '-') {
                if (tmp.length() %( K+1) == K ) tmp.append("-");
                tmp.append(S.charAt(i));
            }
        }
        return tmp.reverse().toString().toUpperCase();
    }

    public static void main(String[] args) {
        String testData  = "5F3Z-2e-9-w";  //
        int K = 4;
        LicenseKeyFormatting solution = new LicenseKeyFormatting();
        String result = solution.licenseKeyFormatting(testData, K);

        System.out.printf("testData %s and %s hammingDistance is %s \n", testData,K, result);
    }

}
