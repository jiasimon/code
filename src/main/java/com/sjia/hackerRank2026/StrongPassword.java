package com.sjia.hackerRank2026;

public class StrongPassword {
    // https://www.hackerrank.com/challenges/strong-password/problem?isFullScreen=true

    // String special_characters = "!@#$%^&*()-+";

    public static int minimumNumber(int n, String password) {
        boolean hasNumber = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else {
                if ("!@#$%^&*()-+".contains(c + "")) {
                    hasSpecial = true;
                }
            }
        }

        int missingType = 0;
        if (!hasNumber) missingType++;
        if (!hasLower) missingType++;
        if (!hasUpper) missingType++;
        if (!hasSpecial) missingType++;

        int len = password.length();
        return Math.max(missingType, (6 - len));
    }


}
