package com.sjia.hackerRank2026;

public class CaesarCipher {
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-caesar-cipher-1

    public static String caesarCipher(String s, int k) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        for( char c : s.toCharArray()) {
            if ( c >='A' && c <= 'Z') {
                char ch = (char)('A' +(c - 'A' + k) %26);
                sb.append(ch);
            } else if ( c >='a' && c <= 'z') {
                char ch = (char)('a' +(c - 'a' + k) %26);
                sb.append(ch);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
