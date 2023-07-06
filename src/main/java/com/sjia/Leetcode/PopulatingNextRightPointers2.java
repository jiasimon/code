package com.sjia.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers2 {
    // #117. Populating Next Right Pointers in Each Node II  https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/

    /*
    Given a binary tree  , instead of "perfect binary tree"  in #116
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

    The number of nodes in the tree is in the range [0, 6000].
    -100 <= Node.val <= 100
     */

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };


    // BFS, right to left
    public Node connectBFS(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            Node rightNode = null;
            int levelSize = q.size();
            for(int i = 0; i < levelSize; i++) {
                Node cur = q.poll();
                cur.next = rightNode;
                rightNode = cur;
                if(cur.right != null) {
                    q.offer(cur.right);
//                    q.offer(cur.left);
                }
                if(cur.left != null) {
                    q.offer(cur.left);
                }
            }
        }
        return root;
    }



    // BFS, normal left to right
    public Node connectBFS2(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            Node prev = null;
            for(int i = 0; i < levelSize; i++) {
                Node cur = queue.poll();
                if (prev != null) {
                    prev.next = cur;
                }
                prev = cur;

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }

            }

        }
        return root;
    }



    public static void main(String[] args) {
        PopulatingNextRightPointers2 solution = new PopulatingNextRightPointers2();

        // Create the tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
//        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Connect the nodes
        Node result = solution.connectBFS2(root);

        // Validate the next pointers
        validateNextPointers(result);
    }

    private static void validateNextPointers(Node root) {
        Node levelStart = root;

        while (levelStart != null) {
            Node currentNode = levelStart;

            while (currentNode != null) {
                if (currentNode.next != null) {
                    System.out.println("Node " + currentNode.val + " -> Next: " + currentNode.next.val);
                } else {
                    System.out.println("Node " + currentNode.val + " -> Next: null");
                }

                currentNode = currentNode.next;
            }

            levelStart = levelStart.left;
        }
    }

}
