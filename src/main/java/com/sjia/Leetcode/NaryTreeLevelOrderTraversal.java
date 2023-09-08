package com.sjia.Leetcode;

import java.util.*;

public class NaryTreeLevelOrderTraversal {
    // #429. N-ary Tree Level Order Traversal   https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/

    /*
    Given an n-ary tree, return the level order traversal of its nodes' values.

    Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
       1
     3  2  4
    5 6
    Input: root = [1,null,3,2,4,null,5,6]
    Output: [[1],[3,2,4],[5,6]]

    The height of the n-ary tree is less than or equal to 1000
    The total number of nodes is between [0, 10000]
     */

    static class Node {
        int val;
        List<Node> children;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelValues = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                levelValues.add(node.val);

                if (node.children != null) {
                    for (Node child : node.children) {
                        if (child != null) {
                            queue.offer(child);
                        }
                    }
                }
            }

            result.add(levelValues);
        }

        return result;

    }

    public static void main(String[] args) {
        NaryTreeLevelOrderTraversal solution = new NaryTreeLevelOrderTraversal();

        // Example usage:
        Node root = new Node(1);
        Node child1 = new Node(3);
        Node child2 = new Node(2);
        Node child3 = new Node(4);
        List<Node> children1 = new ArrayList<>();
        children1.add(child1);
        children1.add(child2);
        children1.add(child3);
        root.children = children1;

        Node child4 = new Node(5);
        Node child5 = new Node(6);
        child1.children = new ArrayList<>();
        child1.children.add(child4);
        child1.children.add(child5);

        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println("Level Order Traversal: " + result);
    }


}
