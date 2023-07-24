package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {
    // #246. Strobogrammatic Number https://leetcode.com/problems/strobogrammatic-number
    // https://grandyang.com/leetcode/246/

    /*
    A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
     */


    // HashMap for 01689
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



    public static void main(String[] args) {
        StrobogrammaticNumber strobogrammaticNumber = new StrobogrammaticNumber();

        System.out.println(strobogrammaticNumber.isStrobogrammatic("69")); // Output: true
        System.out.println(strobogrammaticNumber.isStrobogrammatic("88")); // Output: true
        System.out.println(strobogrammaticNumber.isStrobogrammatic("818")); // Output: true
        System.out.println(strobogrammaticNumber.isStrobogrammatic("8188")); // Output: false
        System.out.println(strobogrammaticNumber.isStrobogrammatic("00")); // Output: true
    }
}
