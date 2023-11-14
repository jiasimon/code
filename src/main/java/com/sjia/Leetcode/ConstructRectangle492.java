package com.sjia.Leetcode;

public class ConstructRectangle492 {
    // #492. Construct the Rectangle    https://leetcode.com/problems/construct-the-rectangle/

    /*
    The area of the rectangular web page you designed must equal to the given target area.
    The width W should not be larger than the length L, which means L >= W.
    The difference between length L and width W should be as small as possible.
    Return an array [L, W] where L and W are the length and width of the web page you designed in sequence.

    Input: area = 4     Output: [2,2]
    Input: area = 37    Output: [37,1]

    Input: area = 122122    Output: [427,286]

    1 <= area <= 10^7
     */


    // (int) Math.sqrt(area)
    // 0 ms, 100%; 40.3 MB, 7.85%
    public int[] constructRectangle(int area) {
        int[] result = new int[2];

        int width = (int) Math.sqrt(area);
        while (area % width != 0) {
            width--;
        }

        int length = area / width;
        result[0] = length;
        result[1] = width;

        return result;
    }

    public static void main(String[] args) {
        ConstructRectangle492 solution = new ConstructRectangle492();

        // Example usage:
        int area = 36;
        int[] rectangle = solution.constructRectangle(area);

        System.out.println("Length: " + rectangle[0] + ", Width: " + rectangle[1]);
        // Output: Length: 6, Width: 6
    }

}
