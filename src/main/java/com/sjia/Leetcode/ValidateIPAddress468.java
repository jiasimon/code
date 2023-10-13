package com.sjia.Leetcode;

public class ValidateIPAddress468 {
    // #468. Validate IP Address    https://leetcode.com/problems/validate-ip-address/description/

    /*
    A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:

    1 <= xi.length <= 4
    xi is a hexadecimal string which may contain digits, lowercase English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
    Leading zeros are allowed in xi.
    For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses, while "2001:0db8:85a3::8A2E:037j:7334" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.

    Input: queryIP = "172.16.254.1"     Output: "IPv4"
    Input: queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"    Output: "IPv6"

    Input: queryIP = "256.256.256.256"  Output: "Neither"
    Explanation: This is neither a IPv4 address nor a IPv6 address.

    queryIP consists only of English letters, digits and the characters '.' and ':'
     */


    public String validIPAddress(String IP) {
        if (IP == null || IP.isEmpty()) {
            return "Neither";
        }

        if (IP.contains(".")) {
            // Check for IPv4
            if (isValidIPv4(IP)) {
                return "IPv4";
            }
        } else if (IP.contains(":")) {
            // Check for IPv6
            if (isValidIPv6(IP)) {
                return "IPv6";
            }
        }

        return "Neither";
    }

    private boolean isValidIPv4(String ip) {
        if (ip.startsWith(".") || ip.endsWith(".") || ip.length() < 7) {
            return false;
        }

        String[] parts = ip.split("\\.");
        if (parts.length != 4) {
            return false;
        }

        for (String part : parts) {
            if (part.length() == 0 || part.length() > 3) {
                return false;
            }

            if (part.charAt(0) == '0' && part.length() > 1) {
                return false;
            }

            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }

            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidIPv6(String ip) {
        if (ip.startsWith(":") || ip.endsWith(":") || ip.length() < 15) {
            return false;
        }

        String[] parts = ip.split(":");
        if (parts.length != 8) {
            return false;
        }

        for (String part : parts) {
            if (part.length() == 0 || part.length() > 4) {
                return false;
            }

            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c) && !isValidHexDigit(c)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidHexDigit(char c) {
        return (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
    }

    public static void main(String[] args) {
        ValidateIPAddress468 solution = new ValidateIPAddress468();
        String IP = "192.0.2.0";

        String result = solution.validIPAddress(IP);
        System.out.println("IP Type: " + result); // Output: "IPv4"
    }
}
