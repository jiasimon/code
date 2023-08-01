package com.sjia.Leetcode;

import java.util.*;

public class MinimumHeightTrees {
    // #310. Minimum Height Trees   https://leetcode.com/problems/minimum-height-trees/description/
    /*
    Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
    Return a list of all MHTs' root labels. You can return the answer in any order.

    The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

    Input: n = 4, edges = [[1,0],[1,2],[1,3]]   Output: [1]
    Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]   Output: [3,4]

    compare to #207. Course Schedule TopSort
     */


    // BFS,
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> res = new ArrayList<>();

        // edge case, only 1 node
        if (n == 1) {
            res.add(0);
            return res;
        }

        int[] degree = new int[n];

        List<List<Integer>> map = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;/*  outdegree  */
            map.get(edge[0]).add(edge[1]);/*add adj nodes*/
            map.get(edge[1]).add(edge[0]);

        }


        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // leaf node degree is 1
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            res = new ArrayList<>(); // need create a new ArrayList for each loop

            int size = queue.size(); // level node size

            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);

                List<Integer> neighbors = map.get(cur);

                for (int neighbor : neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        // if it is a new leaf
                        queue.offer(neighbor);
                    }

                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        MinimumHeightTrees solution = new MinimumHeightTrees();
        int n = 6;
        int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        System.out.println(result); // Output: [3, 4]
    }
}
