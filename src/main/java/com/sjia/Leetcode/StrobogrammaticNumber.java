package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {
    // #246 https://leetcode.com/problems/strobogrammatic-number



    public boolean isStrobogrammatic(String num) {
        if (num.length() ==0) return true;
        Map<Character, Character> tmp = new HashMap<>();
        tmp.put('0','0');
        tmp.put('1','1');
        tmp.put('6','9');
        tmp.put('8','8');
        tmp.put('9','6');

        int left =0, right= num.length()-1 ;
        while(left <= right) {
            if (tmp.get(num.charAt(left)) != num.charAt(right) ||
                    !tmp.containsKey(num.charAt(left) )) return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}
