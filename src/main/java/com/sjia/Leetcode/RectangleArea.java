package com.sjia.Leetcode;

public class RectangleArea {
    // #223. Rectangle Area https://leetcode.com/problems/rectangle-area/
    /*
    Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.

    The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).

    The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).

    -104 <= ax1 <= ax2 <= 104
     */

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaOfA = (ay2 - ay1) * (ax2 - ax1);
        int areaOfB = (by2 - by1) * (bx2 - bx1);

        // calculate x overlap
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int xOverlap = right - left;

        // calculate y overlap
        int top = Math.min(ay2, by2);
        int bottom = Math.max(ay1, by1);
        int yOverlap = top - bottom;

        int areaOfOverlap = 0;
        if (xOverlap > 0 && yOverlap > 0) {
            areaOfOverlap = xOverlap * yOverlap;
        }

        int totalArea = areaOfA + areaOfB - areaOfOverlap;

        return totalArea;

    }



}
