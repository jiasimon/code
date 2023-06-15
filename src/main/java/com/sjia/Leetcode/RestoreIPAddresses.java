package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    //  #93. Restore IP Addresses  https://leetcode.com/problems/restore-ip-addresses/

    /*
    A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

    For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
    Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

    Input: s = "25525511135"  Output: ["255.255.11.135","255.255.111.35"]
    Input: s = "0000"  Output: ["0.0.0.0"]
    Input: s = "101023"  Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
     */


    // backtrack
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int index, List<String> current, List<String> result) {
        // If we have found 4 parts and used all characters in the string, add the valid IP address to the result
        if (current.size() == 4 && index == s.length()) {
            result.add(String.join(".", current));
            return;
        }

        // If we have found 4 parts but there are still characters remaining in the string, backtrack
        if (current.size() == 4 || index == s.length()) {
            return;
        }

        // Explore all possibilities for the next part of the IP address
        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String part = s.substring(index, index + i);
            if (isValidPart(part)) {
                current.add(part);
                backtrack(s, index + i, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isValidPart(String part) {
        if (part.length() > 1 && part.charAt(0) == '0') {
            return false; // Leading zeros are not allowed
        }

        int num = Integer.parseInt(part);
        return num >= 0 && num <= 255;
    }


    // Iterative  
    private boolean isValid(String s, int start, int length) {
        return length == 1 ||
                (s.charAt(start) != '0' &&
                        (length < 3 ||
                                s.substring(start, start + length).compareTo("255") <= 0));
    }

    public List<String> restoreIpAddresses2(String s) {
        List<String> ans = new ArrayList<>();
        for (int len1 = Math.max(1, s.length() - 9);
             len1 <= 3 && len1 <= s.length() - 3; ++len1) {
            if (!isValid(s, 0, len1)) {
                continue;
            }

            for (int len2 = Math.max(1, s.length() - len1 - 6);
                 len2 <= 3 && len2 <= s.length() - len1 - 2; ++len2) {
                if (!isValid(s, len1, len2)) {
                    continue;
                }
                for (int len3 = Math.max(1, s.length() - len1 - len2 - 3);
                     len3 <= 3 && len3 <= s.length() - len1 - len2 - 1; ++len3) {
                    if (isValid(s, len1 + len2, len3) &&
                            isValid(s, len1 + len2 + len3,
                                    s.length() - len1 - len2 - len3)) {
                        ans.add(String.join(".", s.
                                        substring(0, len1),
                                s.substring(len1, len1 + len2),
                                s.substring(len1 + len2, len1 + len2 + len3),
                                s.substring(len1 + len2 + len3)));
                    }
                }
            }

        }
        return ans;
    }



    public static void main(String[] args) {
        String s = "25525511135";
        String s2 = "101023";
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        List<String> result = restoreIPAddresses.restoreIpAddresses(s);
        System.out.println(result);

        List<String> result2 = restoreIPAddresses.restoreIpAddresses(s2);
        System.out.println(result2);

    }


}
