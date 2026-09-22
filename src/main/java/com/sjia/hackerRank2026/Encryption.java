package com.sjia.hackerRank2026;

public class Encryption {
    // https://www.hackerrank.com/challenges/encryption

    // s.replaceAll("\\s+", "")
    public static String encryption(String s) {
        // Remove spaces
        s = s.replaceAll("\\s+", "");
        int length = s.length();
        // Calculate rows and columns
        int rows = (int) Math.floor(Math.sqrt(length));
        int cols = (int) Math.ceil(Math.sqrt(length));
        // If rows * cols is too small, increase rows
        if (rows * cols < length) {
            rows++;
        }
        StringBuilder result = new StringBuilder();
        // Read column by column
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                int index = row * cols + col;
                if (index < length) {
                    result.append(s.charAt(index));
                }
            }
            // Space between encoded words
            if (col < cols - 1) {
                result.append(' ');
            }
        }
        return result.toString();
    }

}
