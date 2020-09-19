package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GroupSpecialEquivalentStrings {
    // #893 https://leetcode.com/problems/groups-of-special-equivalent-strings/


    // Runtime: 14 ms, faster than 46.47% of Java online submissions for Groups of Special-Equivalent Strings.
    //Memory Usage: 39.6 MB, less than 56.90% of Java online submissions for Groups of Special-Equivalent Strings.
    public int numSpecialEquivGroups(String[] A) {
        Set<String> tmp = new HashSet<>();
        for (String str : A) {
            int[] odd = new int[26];
            int[] even = new int[26];
            for (int i=0; i<str.length(); i++) {
                if( i%2 ==0) even[str.charAt(i)-'a']++;
                else odd[str.charAt(i)-'a']++;
            }
            String key = Arrays.toString(odd) + Arrays.toString(even);
            tmp.add(key);
        }
        System.out.println(tmp);
        return tmp.size();
    }

    public static void main(String[] args) {
        String[] testData  = new String[] {"abcd","cdab","cbad","xyzz","zzxy","zzyx"};
        GroupSpecialEquivalentStrings solution = new GroupSpecialEquivalentStrings();
        int result = solution.numSpecialEquivGroups(testData);

        System.out.printf("testData %s Group of SpecialEquivalentStrings is %s \n", Arrays.asList(testData),result);
    }

}
