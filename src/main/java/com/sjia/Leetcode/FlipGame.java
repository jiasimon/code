package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List <String> result = new ArrayList<>();
        if ( s== null || s.length() <=1 ) return result;
        char[] tmp = s.toCharArray();
        for (int i=1; i < tmp.length; i++ ) {
            if (tmp[i] == '+' && tmp[i-1] == '+') {
                tmp[i] ='-';
                tmp[i-1]='-';
                result.add(new String(tmp));
                tmp[i] ='+';
                tmp[i-1]='+';
            }
        }
        return result;
    }


    
}
