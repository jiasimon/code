package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {
    // #1002 https://leetcode.com/problems/find-common-characters/

    // Runtime: 7 ms, faster than 54.57% of Java online submissions for Find Common Characters.
    //Memory Usage: 38.9 MB, less than 7.86% of Java online submissions for Find Common Characters.

    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String str : A) {
            int[] tmp = new int[26];
            for (Character c : str.toCharArray()){
                tmp[c - 'a']++;
            }
            for (int i=0; i < 26; i++) {
                count[i] = Math.min(count[i], tmp[i]);
            }
        }
        for (int i=0; i<26; i++) {
            while (count[i]-- > 0) res.add(""+(char)('a'+i));
        }
        return res;
    }

}
