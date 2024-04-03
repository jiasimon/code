package com.sjia.Leetcode;

import java.util.*;

public class ErectFence {
    // #587. Erect the Fence    https://leetcode.com/problems/erect-the-fence/description/

    /*
    Fence the entire garden using the minimum length of rope, as it is expensive. The garden is well-fenced only if all the trees are enclosed.

    Return the coordinates of trees that are exactly located on the fence perimeter. You may return the answer in any order.

    Input: trees = [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]    Output: [[1,1],[2,0],[4,2],[3,3],[2,4]]
    Explanation: All the trees will be on the perimeter of the fence except the tree at [2, 2], which will be inside the fence.

    Input: trees = [[1,2],[2,2],[4,2]]  Output: [[4,2],[2,2],[1,2]]
    Explanation: The fence forms a line that passes through all the trees.
     */

    // chatgpt incorrect
    public int[][] outerTrees_fix_gpt(int[][] trees) {
        List<int[]> points = new ArrayList<>();
        for (int[] tree : trees) {
            points.add(new int[]{tree[0], tree[1]});
        }

        List<int[]> convexHull = convexHull(points);

        int[][] result = new int[convexHull.size()][2];
        for (int i = 0; i < convexHull.size(); i++) {
            result[i] = convexHull.get(i);
        }

        return result;
    }

    private List<int[]> convexHull(List<int[]> points) {
        if (points.size() <= 1) return points;

        points.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        List<int[]> upperHull = new ArrayList<>();
        for (int[] point : points) {
            while (upperHull.size() >= 2 && orientation(upperHull.get(upperHull.size() - 2), upperHull.get(upperHull.size() - 1), point) > 0) {
                upperHull.remove(upperHull.size() - 1);
            }
            upperHull.add(point);
        }

        List<int[]> lowerHull = new ArrayList<>();
        for (int i = points.size() - 1; i >= 0; i--) {
            int[] point = points.get(i);
            while (lowerHull.size() >= 2 && orientation(lowerHull.get(lowerHull.size() - 2), lowerHull.get(lowerHull.size() - 1), point) > 0) {
                lowerHull.remove(lowerHull.size() - 1);
            }
            lowerHull.add(point);
        }

        List<int[]> hull = new ArrayList<>(upperHull);
        hull.addAll(lowerHull.subList(1, lowerHull.size() - 1));

        // use set to remove duplicate
        Set<int[]> set = new HashSet<>(hull);
        List<int[]> res = new ArrayList<>();
        res.addAll(set);

        return hull;
    }



    private int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }



    // Test case
    public static void main(String[] args) {
        ErectFence solution = new ErectFence();

        int[][] trees = {{1,1},{2,2},{2,0},{2,4},{3,3},{4,2}};
        int[][] result = solution.outerTrees(trees);

        System.out.println("Test Case 1:");
        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
        // Output: [[1,1],[2,0],[4,2],[2,4],[3,3],[2,2]]
    }
}
