package com.sjia.hackerRank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndAnagrams {
    /*
    https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
     */

    static int sherlockAndAnagrams(String s) {
        int totalCount = 0;

        Map<String, Integer> map = new HashMap<>();
        for (int length = 1; length < s.length(); length++) {
            for (int i = 0; i <= s.length() - length; i++) {
                String substring = s.substring(i, i + length);
                char[] chars = substring.toCharArray();
                java.util.Arrays.sort(chars);
                String sortedSubstring = new String(chars);

                map.put(sortedSubstring, map.getOrDefault(sortedSubstring, 0) + 1);
            }


        }
        for (int count : map.values()) {
            totalCount += count * (count - 1) / 2;
        }

        return totalCount;
    }

    public static void main(String[] args) {

        String s1 = "abba";
        System.out.println(s1 + " sherlockAndAnagrams: " + sherlockAndAnagrams(s1)); // output: 4

        String s2 = "kkkk";
        System.out.println(s2 + " sherlockAndAnagrams: " + sherlockAndAnagrams(s2)); // output: 10

        String s3 = "ifailuhkqq";
        System.out.println(s3 + " sherlockAndAnagrams: " + sherlockAndAnagrams(s3)); // output: 3

/*        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < q; i++) {
            String s = scanner.nextLine();
            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }
        scanner.close();
        */

    }
}
