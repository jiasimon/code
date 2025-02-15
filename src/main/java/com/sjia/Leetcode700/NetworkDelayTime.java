package com.sjia.Leetcode700;

import java.util.*;

public class NetworkDelayTime {
    // #743. Network Delay Time     https://leetcode.com/problems/network-delay-time/description/
    /*
The problem can be solved using Dijkstra’s Algorithm, which finds the shortest path in a graph with non-negative weights.
We use a Priority Queue (Min-Heap) to efficiently fetch the node with the smallest known distance.
We update the distances of neighboring nodes greedily.
     */

    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Build the graph (Adjacency List)
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        // Step 2: Apply Dijkstra’s Algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // Min-heap based on time
        pq.add(new int[]{k, 0}); // {node, time}

        Map<Integer, Integer> shortestTime = new HashMap<>(); // Track shortest time to each node

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0], time = current[1];

            // If node is already visited, continue
            if (shortestTime.containsKey(node)) continue;

            shortestTime.put(node, time);

            // Process all neighbors
            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0], travelTime = neighbor[1];
                    if (!shortestTime.containsKey(nextNode)) {
                        pq.add(new int[]{nextNode, time + travelTime});
                    }
                }
            }
        }

        // Step 3: Check if all nodes are reached
        if (shortestTime.size() != n) return -1;

        // Find the maximum time among all nodes
        return Collections.max(shortestTime.values());
    }

    public static void main(String[] args) {
        NetworkDelayTime solution = new NetworkDelayTime();

        // Test case 1
        int[][] times1 = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(solution.networkDelayTime(times1, 4, 2)); // Expected Output: 2

        // Test case 2
        int[][] times2 = {{1, 2, 1}};
        System.out.println(solution.networkDelayTime(times2, 2, 1)); // Expected Output: 1

        // Test case 3 (Disjoint graph)
        int[][] times3 = {{1, 2, 1}};
        System.out.println(solution.networkDelayTime(times3, 2, 2)); // Expected Output: -1
    }



}
