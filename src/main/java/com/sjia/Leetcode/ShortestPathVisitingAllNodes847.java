package com.sjia.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes847 {
    // #847. Shortest Path Visiting All Nodes   https://leetcode.com/problems/shortest-path-visiting-all-nodes/?envType=daily-question&envId=2023-09-17

    /*
    You have an undirected, connected graph of n nodes labeled from 0 to n - 1. You are given an array graph where graph[i] is a list of all the nodes connected with node i by an edge.

    Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.

    Input: graph = [[1,2,3],[0],[0],[0]]    Output: 4
    Explanation: One possible path is [1,0,2,0,3]

    Input: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]  Output: 4
    Explanation: One possible path is [0,1,4,2,3]

    n == graph.length, 1 <= n <= 12
    0 <= graph[i].length < n
    graph[i] does not contain i.
    If graph[a] contains b, then graph[b] contains a.
    The input graph is always connected.
     */



    // BFS with bit mask
    // 9 ms, 95.19%; 42.8 MB, 95.93%
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int targetMask = (1 << n) - 1; // Target mask with all nodes visited
        Queue<int[]> queue = new LinkedList<>(); // Queue for BFS

        boolean[][] visited = new boolean[n][1 << n]; // To track visited nodes and masks

        // Initialize the queue with all nodes as starting points
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i});
            visited[i][1 << i] = true;
        }

        int steps = 0; // Number of steps in the shortest path

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int node = current[0];
                int mask = current[1];

                if (mask == targetMask) {
                    return steps; // All nodes visited, return the shortest path
                }

                // Explore neighbors
                for (int neighbor : graph[node]) {
                    int newMask = mask | (1 << neighbor);

                    if (!visited[neighbor][newMask]) {
                        queue.offer(new int[]{neighbor, newMask});
                        visited[neighbor][newMask] = true;
                    }
                }
            }

            steps++;
        }

        return -1; // Should not reach here if the graph is connected
    }

    public static void main(String[] args) {
        ShortestPathVisitingAllNodes847 solution = new ShortestPathVisitingAllNodes847();
        int[][] graph = {
                {1, 2, 3},
                {0},
                {0},
                {0}
        };

        int shortestPath = solution.shortestPathLength(graph);
        System.out.println("Shortest Path Length: " + shortestPath); // Output: 4
    }


}
