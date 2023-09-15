package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinCostConnectPoints1584 {
    // #1584. Min Cost to Connect All Points    https://leetcode.com/problems/min-cost-to-connect-all-points/description/?envType=daily-question&envId=2023-09-15

    /*
    You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

    The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

    Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

    Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]    Output: 20
    Input: points = [[3,12],[-2,5],[-4,1]]              Output: 18

    1 <= points.length <= 1000
    -10^6 <= xi, yi <= 10^6
    All pairs (xi, yi) are distinct.
     */


    class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }




    // Kruskal algorithm using Union-Find
    // 319 ms, 44.85%; 65.5 MB, 43.33%
        public int minCostConnectPoints(int[][] points) {
            int n = points.length;
            List<int[]> edges = new ArrayList<>();

            // Generate all possible edges and calculate their distances
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                    edges.add(new int[]{i, j, distance});
                }
            }

            // Sort edges by distance in ascending order
            Collections.sort(edges, (a, b) -> a[2] - b[2]);

            int minCost = 0;
            int edgeCount = 0;
            UnionFind uf = new UnionFind(n);

            // Apply Kruskal's algorithm to find the minimum spanning tree
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int distance = edge[2];

                if (uf.find(u) != uf.find(v)) {
                    uf.union(u, v);
                    minCost += distance;
                    edgeCount++;
                }

                // Stop when we have included n - 1 edges (spanning tree is complete)
                if (edgeCount == n - 1) {
                    break;
                }
            }

            return minCost;
        }




        public static void main(String[] args) {
            MinCostConnectPoints1584 solution = new MinCostConnectPoints1584();
            int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
            int minCost = solution.minCostConnectPoints(points);
            System.out.println("Minimum Cost to Connect Points: " + minCost); // Output: 20
        }


}
