package com.sjia.Leetcode;

public class FaultyKeyboard {
    // #2810. Faulty Keyboard   https://leetcode.com/problems/faulty-keyboard/description/

    /*
    #interview
    Your laptop keyboard is faulty, and whenever you type a character 'i' on it, it reverses the string that you have written. Typing other characters works as expected.

    You are given a 0-indexed string s, and you type each character of s using your faulty keyboard.

    Return the final string that will be present on your laptop screen.

    Input: s = "string"     Output: "rtsng"

    Input: s = "poiinter"   Output: "ponter"
    1 <= s.length <= 100
    s[0] != 'i'
     */



    // String +=, s.charAt(i),
    // 9ms, 17.70%; 44.88MB, 34.92%
    public String finalString(String s) {
        String res = "";
        for (int i=0; i < s.length(); i++) {
            if(s.charAt(i) != 'i'){
                res += s.charAt(i);
            } else {
                res = new StringBuilder(res).reverse().toString();
            }
        }
        return res;
    }

    


}
