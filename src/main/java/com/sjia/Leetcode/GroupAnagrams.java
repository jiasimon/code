package com.sjia.Leetcode;

import java.util.*;

public class GroupAnagrams {
    // #49. Group Anagrams  https://leetcode.com/problems/group-anagrams/

    // Given an array of strings strs, group the anagrams together. You can return the answer in any order.
    // An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase

    // Input: strs = ["eat","tea","tan","ate","nat","bat"]
    // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    // Input: strs = [""]  Output: [[""]]
    // Input: strs = ["a"]  Output: [["a"]]

    // 1 <= strs.length <= 104,  0 <= strs[i].length <= 100

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length < 1 ) return new ArrayList();

//        List<List <String>> res = new ArrayList<>();
//        Map<String, List> map  = new HashMap<String, List>();
        Map<String, List<String>> map  = new HashMap<>();

        for (String s : strs) {
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String key = String.valueOf(tmp);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

//        for ( List v: map.values()) res.add(v);
//        return res;
        return new ArrayList<>(map.values());


    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat", "tba"};
        List<List<String>> groups = groupAnagrams(strs);

        for (List<String> group : groups) {
            System.out.println(group);
        }
    }


}
