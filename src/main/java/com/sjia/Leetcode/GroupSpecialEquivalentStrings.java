package com.sjia.Leetcode;

import java.util.*;

public class GroupSpecialEquivalentStrings {
    // #893 https://leetcode.com/problems/groups-of-special-equivalent-strings/
    // 1 <= A.length <= 1000
    // 1 <= A[i].length <= 20
    // All A[i] have the same length.
    // All A[i] consist of only lowercase letters.


    // Runtime: 14 ms, faster than 46.47% of Java online submissions for Groups of Special-Equivalent Strings.
    //Memory Usage: 39.6 MB, less than 56.90% of Java online submissions for Groups of Special-Equivalent Strings.
    /*public int numSpecialEquivGroups(String[] A) {
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
    }*/


    // Runtime: 11 ms, faster than 63.55% of Java online submissions for Groups of Special-Equivalent Strings.
    //Memory Usage: 39.4 MB, less than 69.07% of Java online submissions for Groups of Special-Equivalent Strings.
    public int numSpecialEquivGroups(String[] A) {
        Set<String> tmp = new HashSet<>();
        for (String str : A) {
            List<Character> odd = new ArrayList<>();
            List<Character> even = new ArrayList<>();
            int i=0;
            for (char c : str.toCharArray()) {
                if (i++%2==1) odd.add(c);
                else even.add(c);
            }
            Collections.sort(odd);
            Collections.sort(even);
            String key = String.valueOf(odd) + String.valueOf(even);
            tmp.add(key);
        }
        System.out.println(tmp);
        return tmp.size();
    }


    // Runtime: 12 ms, faster than 62.41% of Java online submissions for Groups of Special-Equivalent Strings.
    //Memory Usage: 39.9 MB, less than 40.69% of Java online submissions for Groups of Special-Equivalent Strings.
/*    public int numSpecialEquivGroups(String[] A) {
        Set<String> tmp = new HashSet<>();
        for (String str : A) {
            List<Character> odd = new ArrayList<>();
            List<Character> even = new ArrayList<>();
            for (int i=0; i<str.length(); i++) {
                if (i%2==1) odd.add(str.charAt(i));
                else even.add(str.charAt(i));
            }
            Collections.sort(odd);
            Collections.sort(even);
            String key = String.valueOf(odd) + String.valueOf(even);
            tmp.add(key);
        }
        System.out.println(tmp);
        return tmp.size();
    }*/



    public static void main(String[] args) {
        String[] testData  = new String[] {"abcd","cdab","cbad","xyzz","zzxy","zzyx"};
        GroupSpecialEquivalentStrings solution = new GroupSpecialEquivalentStrings();
        int result = solution.numSpecialEquivGroups(testData);

        System.out.printf("testData %s Group of SpecialEquivalentStrings is %s \n", Arrays.asList(testData),result);
    }

}
