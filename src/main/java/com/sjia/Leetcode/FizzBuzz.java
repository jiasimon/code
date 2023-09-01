package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    // #412. Fizz Buzz https://leetcode.com/problems/fizz-buzz/

    /*
    Given an integer n, return a string array answer (1-indexed) where:

    answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
    answer[i] == "Fizz" if i is divisible by 3.
    answer[i] == "Buzz" if i is divisible by 5.
    answer[i] == i (as a string) if none of the above conditions are true.

    Input: n = 3        Output: ["1","2","Fizz"]
    Input: n = 5        Output: ["1","2","Fizz","4","Buzz"]

    1 <= n <= 104
     */



    // 1 ms, 99.75%; 44.7 MB, 63.70%
    public List<String> fizzBuzz_2(int n) {
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


    // Runtime: 8 ms, faster than 12.59% of Java online submissions for Fizz Buzz.
    //Memory Usage: 46.2 MB, less than 5.21% of Java online submissions for Fizz Buzz.

    public List<String> fizzBuzz(int n) {
        List <String> result = new ArrayList<>();
        for ( int i=1; i <=n; i++ ) {
            String tmp = "";
            if(i %3==0) {
                tmp += "Fizz";
            }
            if (i %5==0) {
                tmp += "Buzz";
            }
            if (tmp.length()==0){
                tmp += String.valueOf(i);
            }
            result.add(tmp);
        }
        return result;
    }


    // Runtime: 1 ms, faster than 99.56% of Java online submissions for Fizz Buzz.
    //Memory Usage: 40.9 MB, less than 9.00% of Java online submissions for Fizz Buzz.
    // use  instead of mode
/*
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<String>(n);
        for(int i=1,fizz=0,buzz=0;i<=n ;i++){
            fizz++;
            buzz++;
            if(fizz==3 && buzz==5){
                ret.add("FizzBuzz");
                fizz=0;
                buzz=0;
            }else if(fizz==3){
                ret.add("Fizz");
                fizz=0;
            }else if(buzz==5){
                ret.add("Buzz");
                buzz=0;
            }else{
                ret.add(String.valueOf(i));
            }
        }
        return ret;
    }*/


    public static void main(String[] args) {
        FizzBuzz solution = new FizzBuzz();

        int n =15;
        List<String> result = solution.fizzBuzz(n);
        System.out.println(result); // Output:
    }


}
