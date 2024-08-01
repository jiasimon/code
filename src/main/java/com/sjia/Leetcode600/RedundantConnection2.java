package com.sjia.Leetcode600;

public class RedundantConnection2 {
    // #685. Redundant Connection II    https://leetcode.com/problems/redundant-connection-ii/description/
    /*
    Return an edge that can be removed so that the resulting graph is a rooted tree of n nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.

    Input: edges = [[1,2],[1,3],[2,3]]      Output: [2,3]
    Input: edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]  Output: [4,1]

     */

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        int[] candidate1 = null;
        int[] candidate2 = null;

        // Step 1: Check whether there is a node with two parents
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (parent[v] == 0) {
                parent[v] = u;
            } else {
                candidate1 = new int[]{parent[v], v};
                candidate2 = new int[]{u, v};
                edge[1] = 0; // Mark this edge as invalid
            }
        }

        // Step 2: Union-Find to check whether there is a cycle
        for (int i = 0; i <= edges.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            if (edge[1] == 0) continue; // Skip the invalid edge
            int u = edge[0];
            int v = edge[1];
            if (find(parent, u) == v) {
                return candidate1 == null ? edge : candidate1;
            }
            parent[v] = u;
        }

        return candidate2;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }


    public static void main(String[] args) {
        RedundantConnection2 solution = new RedundantConnection2();

        // Test Case 1
        int[][] edges1 = {{1, 2}, {1, 3}, {2, 3}};
        int[] result1 = solution.findRedundantDirectedConnection(edges1);
        System.out.println("Test Case 1: [" + result1[0] + ", " + result1[1] + "]"); // Output: [2, 3]

        // Test Case 2
        int[][] edges2 = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
        int[] result2 = solution.findRedundantDirectedConnection(edges2);
        System.out.println("Test Case 2: [" + result2[0] + ", " + result2[1] + "]"); // Output: [4, 1]

        // Test Case 3: Node with two parents
        int[][] edges3 = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {2, 5}};
        int[] result3 = solution.findRedundantDirectedConnection(edges3);
        System.out.println("Test Case 3: [" + result3[0] + ", " + result3[1] + "]"); // Output: [4, 1]
    }
}
