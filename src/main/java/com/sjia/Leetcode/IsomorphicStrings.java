package com.sjia.Leetcode;

import java.util.HashMap;

public class IsomorphicStrings {

    // #205. Isomorphic Strings  https://leetcode.com/problems/isomorphic-strings/

    // egg:add  foo:bar paper:title good:cooks

    // Runtime: 11 ms, faster than 42.85% of Java online submissions for Isomorphic Strings.
    //Memory Usage: 40.1 MB, less than 5.24% of Java online submissions for Isomorphic Strings.

    // second run, Runtime: 5 ms, faster than 85.54% of Java online submissions for Isomorphic Strings.
    //Memory Usage: 40.7 MB, less than 5.24% of Java online submissions for Isomorphic Strings.
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] map1 = new int[256], map2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (map1[s.charAt(i)] != map2[t.charAt(i)]) return false;
            else {
                map1[s.charAt(i)] = i + 1;
                map2[t.charAt(i)] = i + 1;
            }
        }
        return true;
    }



    // Single Map, containsValue
    // 11 ms, 60.14%; 41.8 MB, 23.98%
    public boolean isIsomorphicHashMap(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.length() <= 1) return true;

        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                } else {
                    map.put(s.charAt(i), t.charAt(i));
                }
            }
        }
        return true;
    }




    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";
        IsomorphicStrings solution = new IsomorphicStrings();

        boolean result = solution.isIsomorphic(s, t);
        System.out.printf("%s and %s isIsomorphic: %s", s, t, result);
        System.out.println();
/*

        // Test Case 2: "foo" and "bar" are not isomorphic
        String s2 = "foo";
        String t2 = "bar";
        boolean result2 = solution.isIsomorphicHashMap(s2, t2);
        System.out.println("Are \"" + s2 + "\" and \"" + t2 + "\" isomorphic? " + result2);

        // Test Case 3: "paper" and "title" are isomorphic
        String s3 = "paper";
        String t3 = "title";
        boolean result3 = solution.isIsomorphicHashMap(s3, t3);
        System.out.println("Are \"" + s3 + "\" and \"" + t3 + "\" isomorphic? " + result3);
*/

    }

}
