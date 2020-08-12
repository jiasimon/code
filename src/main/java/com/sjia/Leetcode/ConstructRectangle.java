package com.sjia.Leetcode;

public class ConstructRectangle {
    // #492 https://leetcode.com/problems/construct-the-rectangle/
    // 1. The area of the rectangular web page you designed must equal to the given target area.
    //
    //2. The width W should not be larger than the length L, which means L >= W.
    //
    //3. The difference between length L and width W should be as small as possible.


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Construct the Rectangle.
    //Memory Usage: 37.2 MB, less than 42.91% of Java online submissions for Construct the Rectangle.
/*
    public int[] constructRectangle(int area) {
        int tmp = (int)Math.sqrt(area);
        while ( area % tmp != 0) {
            tmp--;
        }
        return new int[] {area/tmp, tmp};
    }*/


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Construct the Rectangle.
    //Memory Usage: 36.8 MB, less than 75.10% of Java online submissions for Construct the Rectangle.
    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        int tmp = (int)Math.sqrt(area);
        while ( area % tmp != 0) {
            tmp--;
        }
        result[0] = area/tmp;
        result[1] = tmp;
        return result;
    }


}
