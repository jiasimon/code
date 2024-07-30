package com.sjia.Leetcode600;

public class RedundantConnection {
    // #684. Redundant Connection   https://leetcode.com/problems/redundant-connection/description/

    /*
    Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.


    Input: edges = [[1,2],[1,3],[2,3]]  Output: [2,3]

    Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]  Output: [1,4]
     */

    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            if (find(parent, node1) == find(parent, node2)) {
                return edge;
            } else {
                union(parent, node1, node2);
            }
        }
        return new int[0];
    }

    private int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }

    private void union(int[] parent, int node1, int node2) {
        parent[find(parent, node1)] = find(parent, node2);
    }

    public static void main(String[] args) {
        RedundantConnection solution = new RedundantConnection();

        // Test Case 1
        int[][] edges1 = {{1, 2}, {1, 3}, {2, 3}};
        int[] result1 = solution.findRedundantConnection(edges1);
        System.out.println("Test Case 1: [" + result1[0] + ", " + result1[1] + "]"); // Output: [2, 3]

        // Test Case 2
        int[][] edges2 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] result2 = solution.findRedundantConnection(edges2);
        System.out.println("Test Case 2: [" + result2[0] + ", " + result2[1] + "]"); // Output: [1, 4]
    }
}
