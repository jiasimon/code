package com.sjia.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class DesignAddSearchWordsDataStructure {
    // #211. Design Add and Search Words Data Structure     https://leetcode.com/problems/design-add-and-search-words-data-structure/
    /*
    bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
    word may contain dots '.' where dots can be matched with any letter.
    There will be at most 2 dots in word for search queries.
     */


    // TLE 22/29

    class WordDictionary {
    Set<String> set=new HashSet<>();



//     Initialize your data structure here.
    public WordDictionary() {
        set.clear();
    }

//     Adds a word into the data structure.
    public void addWord(String word) {
        set.add(word);
    }

//     Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(set.contains(word)){return true;}
        for(String s:set){if(match(s,word)){return true;}}
        return false;
    }

    boolean match(String s,String t){
        if(s.length()!=t.length()){return false;}
        for(int i=0;i<s.length();i++){
            char c=t.charAt(i);
            if(c!='.'&&c!=s.charAt(i)){return false;}
        }
        return true;
    }

}





}
