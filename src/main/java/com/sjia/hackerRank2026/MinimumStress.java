package com.sjia.hackerRank2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumStress {
    // find a path in a weighted undirected graph from a source to a destination
    // that minimizes the maximum edge weight along the path

    // Minimax path or minimum bottleneck path

    // Inner class representing an Edge in the adjacency list
    static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    // Inner class to store state inside the PriorityQueue
    static class NodeState {
        int node;
        int maxStress;

        NodeState(int node, int maxStress) {
            this.node = node;
            this.maxStress = maxStress;
        }
    }

    /*

            static class Edge {
                int u;
                int v;
                int weight;
        Edge(int u, int v, int weight) {
                    this.u = u;
                    this.v = v;
                    this.weight = weight;
                }
            }
        static class UnionFind {
                private int[] parent;
                private int[] rank;
        UnionFind(int n) {
                    parent = new int[n];
                    rank = new int[n];
        for (int i = 0; i < n; i++) {
                        parent[i] = i;
                    }
                }
        int find(int x) {
                    if (parent[x] != x) {
                        parent[x] = find(parent[x]); // Path compression
                    }
        return parent[x];
                }
        boolean union(int a, int b) {
                    int rootA = find(a);
                    int rootB = find(b);
        if (rootA == rootB) {
                        return false;
                    }
        // Union by rank
                    if (rank[rootA] < rank[rootB]) {
                        parent[rootA] = rootB;
                    } else if (rank[rootA] > rank[rootB]) {
                        parent[rootB] = rootA;
                    } else {
                        parent[rootB] = rootA;
                        rank[rootA]++;
                    }
        return true;
                }
        boolean connected(int a, int b) {
                    return find(a) == find(b);
                }
            }
        public static int getMinimumStress(
                    int n,
                    List<List<Integer>> edges,
                    int source,
                    int destination) {
        // Convert input into Edge objects
                List<Edge> edgeList = new ArrayList<>();
        for (List<Integer> edge : edges) {
                    int u = edge.get(0);
                    int v = edge.get(1);
                    int weight = edge.get(2);
        edgeList.add(new Edge(u, v, weight));
                }
        // Process edges from smallest weight to largest
                edgeList.sort(Comparator.comparingInt(e -> e.weight));
        UnionFind uf = new UnionFind(n);
        // Special case
                if (source == destination) {
                    return 0;
                }
        for (Edge edge : edgeList) {
        // Add this edge to the graph
                    uf.union(edge.u, edge.v);
        // As soon as source and destination are connected,
                    // this edge's weight is the minimum possible stress.
                    if (uf.connected(source, destination)) {
                        return edge.weight;
                    }
                }
        // No path exists
                return -1;
            }
        }

     */


    public static int getMinimumStress(int N, List<List<Edge>> adj, int U, int V) {
        // Track the minimum bottleneck/stress needed to reach each node
        int[] minStressToNode = new int[N + 1];
        Arrays.fill(minStressToNode, Integer.MAX_VALUE);

        // Min-PriorityQueue sorted by the maximum edge weight seen so far
        PriorityQueue<NodeState> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.maxStress));

        // Initialize at the source node
        minStressToNode[U] = 0;
        pq.add(new NodeState(U, 0));

        while (!pq.isEmpty()) {
            NodeState current = pq.poll();
            int currNode = current.node;
            int currStress = current.maxStress;

            // If we reached the destination, this is the optimal minimum stress path
            if (currNode == V) {
                return currStress;
            }

            // Skip processing if a better (lower) stress path to this node was already processed
            if (currStress > minStressToNode[currNode]) {
                continue;
            }

            // Explore neighboring edges
            for (Edge edge : adj.get(currNode)) {
                // The stress of moving to the next node is the max of current path stress and the new edge weight
                int nextStress = Math.max(currStress, edge.weight);

                // Relaxation step: update only if this route yields a lower bottleneck stress
                if (nextStress < minStressToNode[edge.target]) {
                    minStressToNode[edge.target] = nextStress;
                    pq.add(new NodeState(edge.target, nextStress));
                }
            }
        }

        // If the destination cannot be reached from the source
        return -1;
    }

    public static void main(String[] args) {
        // Example setup mimicking HackerRank structure
        int N = 5; // Total nodes
        int[][] edgeData = {
                {1, 2, 4},
                {2, 3, 2},
                {3, 5, 3},
                {1, 4, 10},
                {4, 5, 8}
        };
        int U = 1; // Source
        int V = 5; // Destination

        // Build the Adjacency List (1-indexed for HackerRank convention)
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edgeData) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Edge(v, w));
            adj.get(v).add(new Edge(u, w)); // Assuming undirected graph
        }

        int result = getMinimumStress(N, adj, U, V);
        System.out.println("Minimum Stress Level: " + result);
    }






}
