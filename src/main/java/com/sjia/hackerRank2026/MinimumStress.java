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
