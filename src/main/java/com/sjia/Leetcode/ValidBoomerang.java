package com.sjia.Leetcode;

public class ValidBoomerang {
    // #1037    https://leetcode.com/problems/valid-boomerang
    // A boomerang is a set of 3 points that are all distinct and not in a straight line.
    // Given a list of three points in the plane, return whether these points are a boomerang.

    // points.length == 3
    //points[i].length == 2
    //0 <= points[i][j] <= 100

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Boomerang.
    //Memory Usage: 36.2 MB, less than 19.29% of Java online submissions for Valid Boomerang.
    public boolean isBoomerang(int[][] points) {
        return (points[0][0]- points[1][0]) * (points[1][1]- points[2][1])  ==
                (points[1][0]- points[2][0]) * (points[0][1]- points[1][1]);
    }



}
