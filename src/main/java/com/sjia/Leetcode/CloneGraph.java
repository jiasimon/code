package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    // #133. Clone Graph    https://leetcode.com/problems/clone-graph/
    /*
    Given a reference of a node in a connected undirected graph.
    Return a deep copy (clone) of the graph.
    Input: adjList = [[2,4],[1,3],[2,4],[1,3]]

    Output: [[2,4],[1,3],[2,4],[1,3]]

     */

    class Node {
        int val;
        List<Node> neighbors;

        Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> visited = new HashMap<>();
        return cloneNode(node, visited);
    }

    private Node cloneNode(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node clone = new Node(node.val);
        visited.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneNode(neighbor, visited));
        }

        return clone;
    }


}
