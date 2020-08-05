package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    // #412 https://leetcode.com/problems/fizz-buzz/

    // Runtime: 2 ms, faster than 56.23% of Java online submissions for Fizz Buzz.
    //Memory Usage: 45.8 MB, less than 5.21% of Java online submissions for Fizz Buzz.
    public List<String> fizzBuzz(int n) {
        List <String> result = new ArrayList<>();
        for ( int i=1; i <=n; i++ ) {
            if ( (i %3 ==0) && (i %5 ==0) ) {
                result.add("FizzBuzz");
            } else if(i %3==0) {
                result.add("Fizz");
            } else if (i %5==0) {
                result.add("Buzz");
            } else {
                result.add( String.valueOf(i));
            }
        }
        return result;

    }

}
