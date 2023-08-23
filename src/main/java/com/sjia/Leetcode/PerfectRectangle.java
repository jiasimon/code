package com.sjia.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class PerfectRectangle {
    // #391. Perfect Rectangle  https://leetcode.com/problems/perfect-rectangle/description/
    /*
    Given an array rectangles where rectangles[i] = [xi, yi, ai, bi] represents an axis-aligned rectangle. The bottom-left point of the rectangle is (xi, yi) and the top-right point of it is (ai, bi).

    Return true if all the rectangles together form an exact cover of a rectangular region.

    rectangles = [
      [1,1,3,3],
      [3,1,4,2],
      [3,2,4,4],
      [1,3,2,4],
      [2,3,3,4]
    ]
    Return true.

    rectangles = [
      [1,1,2,3],
      [1,3,2,4],
      [3,1,4,2],
      [3,2,4,4]
    ]
    Return false

    rectangles = [
      [1,1,3,3],
      [3,1,4,2],
      [1,3,2,4],
      [3,2,4,4]
    ]
    Return false.

    1 <= rectangles.length <= 2 * 10^4
    rectangles[i].length == 4
    -10^5 <= xi, yi, ai, bi <= 10^5
     */


    // blue(corner), green, red
    // 50 ms, 47.20%; 53.7 MB, 20%
    public boolean isRectangleCover(int[][] rectangles) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        int totalArea = 0;
        Set<String> points = new HashSet<>();

        for (int[] rect : rectangles) {
            minX = Math.min(minX, rect[0]);
            minY = Math.min(minY, rect[1]);
            maxX = Math.max(maxX, rect[2]);
            maxY = Math.max(maxY, rect[3]);

            totalArea += (rect[2] - rect[0]) * (rect[3] - rect[1]);

            String bottomLeft = rect[0] + "," + rect[1];
            String topLeft = rect[0] + "," + rect[3];
            String bottomRight = rect[2] + "," + rect[1];
            String topRight = rect[2] + "," + rect[3];

            if (!points.add(bottomLeft)) points.remove(bottomLeft);
            if (!points.add(topLeft)) points.remove(topLeft);
            if (!points.add(bottomRight)) points.remove(bottomRight);
            if (!points.add(topRight)) points.remove(topRight);
        }

        String expectedBottomLeft = minX + "," + minY;
        String expectedTopLeft = minX + "," + maxY;
        String expectedBottomRight = maxX + "," + minY;
        String expectedTopRight = maxX + "," + maxY;

        if (!points.contains(expectedBottomLeft) || !points.contains(expectedTopLeft) ||
                !points.contains(expectedBottomRight) || !points.contains(expectedTopRight) ||
                points.size() != 4) {
            return false;
        }

        return totalArea == (maxX - minX) * (maxY - minY);
    }



    // corners.size() != 4, points: String[], faster
    // 39 ms, 81.90%; 50.5 MB, 96.98%
    public boolean isRectangleCover_corner(int[][] rectangles) {
        int area = 0;
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        Set<String> corners = new HashSet<>();

        for (int[] r : rectangles) {
            area += (r[2] - r[0]) * (r[3] - r[1]);
            x1 = Math.min(x1, r[0]);
            y1 = Math.min(y1, r[1]);
            x2 = Math.max(x2, r[2]);
            y2 = Math.max(y2, r[3]);

            // Four points of current rectangle
            String[] points = new String[] {r[0] + " " + r[1], //
                    r[0] + " " + r[3], //
                    r[2] + " " + r[1], //
                    r[2] + " " + r[3]};
            for (final String point : points)
                if (!corners.add(point))
                    corners.remove(point);
        }

        if (corners.size() != 4)
            return false;
        if (!corners.contains(x1 + " " + y1) || //
                !corners.contains(x1 + " " + y2) || //
                !corners.contains(x2 + " " + y1) || //
                !corners.contains(x2 + " " + y2))
            return false;

        return area == (x2 - x1) * (y2 - y1);

    }


    public static void main(String[] args) {
        PerfectRectangle solution = new PerfectRectangle();
        int[][] rectangles = {{1, 1, 3, 3}, {3, 1, 4, 2}, {1, 3, 2, 4}, {2, 2, 4, 4}};
        boolean isPerfectRectangle = solution.isRectangleCover(rectangles);
        System.out.println("Is a perfect rectangle: " + isPerfectRectangle); // Output: false
    }


}
