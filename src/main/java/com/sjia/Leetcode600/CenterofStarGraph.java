package com.sjia.Leetcode600;

public class CenterofStarGraph {
    // #1791. Find Center of Star Graph     https://leetcode.com/problems/find-center-of-star-graph
    /*
    There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.

    Input: edges = [[1,2],[2,3],[4,2]]      Output: 2

    Input: edges = [[1,2],[5,1],[1,3],[1,4]]    Output: 1


     */

    public int findCenter(int[][] edges) {

        // Check if the second edge contains one of the nodes from the first edge
        if (edges[0][0] == edges[1][0]  || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        } else {
            return edges[0][1];
        }
    }

    public static void main(String[] args) {
        CenterofStarGraph solution = new CenterofStarGraph();

        // Test case 1
        int[][] edges1 = { {1, 2}, {2, 3}, {4, 2} };
        System.out.println("Test case 1: " + solution.findCenter(edges1)); // Expected output: 2

        // Test case 2
        int[][] edges2 = { {1, 3}, {2, 3}, {4, 3} };
        System.out.println("Test case 2: " + solution.findCenter(edges2)); // Expected output: 3

        // Test case 3
        int[][] edges3 = { {5, 1}, {5, 2}, {5, 3}, {5, 4} };
        System.out.println("Test case 3: " + solution.findCenter(edges3)); // Expected output: 5

        // Test case 4
        int[][] edges4 = { {1, 4}, {2, 4}, {3, 4} };
        System.out.println("Test case 4: " + solution.findCenter(edges4)); // Expected output: 4

        // Test case 5
        int[][] edges5 = { {10, 11}, {11, 12}, {11, 13}, {11, 14} };
        System.out.println("Test case 5: " + solution.findCenter(edges5)); // Expected output: 11
    }

}
