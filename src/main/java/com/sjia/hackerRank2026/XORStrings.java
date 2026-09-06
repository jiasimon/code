package com.sjia.hackerRank2026;

import java.util.Scanner;

public class XORStrings {
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-strings-xor

    public static String stringsXOR(String s, String t) {
        // Use StringBuilder for optimal performance during string concatenation
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            // If the characters at the same position match, append '0'
            if (s.charAt(i) == t.charAt(i)) {
                res.append("0");
            } else {
                // If they are different, append '1'
                res.append("1");
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Read the two input binary strings
        String s = in.nextLine();
        String t = in.nextLine();

        // Output the XOR result
        System.out.println(stringsXOR(s, t));

        in.close();
    }

}
