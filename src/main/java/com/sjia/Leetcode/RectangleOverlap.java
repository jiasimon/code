package com.sjia.Leetcode;

public class RectangleOverlap {
    // #836 https://leetcode.com/problems/rectangle-overlap/

    // reverse non-overlap, project to X, Y
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Rectangle Overlap.
    //Memory Usage: 36.6 MB, less than 83.16% of Java online submissions for Rectangle Overlap.
/*
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return ! ( rec1[0] >=rec2[2] || rec1[2] <= rec2[0] ||
                rec1[1] >= rec2[3] || rec1[3] <= rec2[1] );
    }*/



    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Rectangle Overlap.
    //Memory Usage: 38.8 MB, less than 10.76% of Java online submissions for Rectangle Overlap.
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (rec1[0] < rec2[2]) && ( rec1[2] > rec2[0] )&&
                (rec1[1] < rec2[3]) && (rec1[3] > rec2[1]) ;
    }



}
