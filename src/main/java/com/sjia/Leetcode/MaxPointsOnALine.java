package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    // #149. Max Points on a Line   https://leetcode.com/problems/max-points-on-a-line/description/
    /*
    Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
    Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]   Output: 4

    1 <= points.length <= 300
    points[i].length == 2
     */


    static class Point {
        int x;
        int y;

        Point() {
            this.x = 0;
            this.y = 0;
        }

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // duplicatePoints, verticalPoints
    public int maxPoints(Point[] points) {
        if (points.length < 3) {
            return points.length;
        }

        int maxPoints = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int duplicatePoints = 1;
            int verticalPoints = 0;

            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    duplicatePoints++;
                } else if (points[i].x == points[j].x) {
                    verticalPoints++;
                } else {
                    int dx = points[j].x - points[i].x;
                    int dy = points[j].y - points[i].y;
                    int gcd = gcd(dx, dy);
                    String slope = (dy / gcd) + "/" + (dx / gcd);

                    slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
                }
            }

            int currentMax = verticalPoints;

            for (int count : slopeCount.values()) {
                currentMax = Math.max(currentMax, count);
            }

            currentMax += duplicatePoints;
            maxPoints = Math.max(maxPoints, currentMax);
        }

        return maxPoints;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        MaxPointsOnALine solution = new MaxPointsOnALine();

        // Test case: [(1, 1), (2, 2), (3, 3)]
        Point[] points = {new Point(1, 1), new Point(2, 2), new Point(3, 3)};

        int maxPoints = solution.maxPoints(points);

        System.out.println("Max Points on a Line: " + maxPoints);
    }


}
