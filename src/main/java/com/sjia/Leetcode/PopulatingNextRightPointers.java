package com.sjia.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers {
    // #116. Populating Next Right Pointers in Each Node  https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
    /*
    You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

    Initially, all next pointers are set to NULL.

    The number of nodes in the tree is in the range [0, 2^12 - 1].
    -1000 <= Node.val <= 1000

    Input: root = [1,2,3,4,5,6,7]   Output: [1,#,2,3,#,4,5,6,7,#]

     */

// Definition for a Node.
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


    // recursive
    // 0 ms, 100%; Memory 43.3 MB, 50.85%
    public Node connect(Node root) {
        if(root == null) return null;
        if(root.left != null) root.left.next = root.right;
        if(root.right != null && root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }


    // BFS, right to left
    public Node connectBFS(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            Node rightNode = null;
            int levelSize = q.size();
            for(int i = 0; i < levelSize; i++) {
//            for(int i = q.size(); i > 0; i--) {
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



    // BFS without queue, Space-Optimized
    public Node connect2(Node root) {
        Node head = root;
        for(; root != null; root = root.left)
            for(Node cur = root; cur != null; cur = cur.next)
                if(cur.left != null) {
                    cur.left.next = cur.right;
                    if(cur.next != null) cur.right.next = cur.next.left;
                } else break;

        return head;
    }

    public static void main(String[] args) {
        PopulatingNextRightPointers solution = new PopulatingNextRightPointers();

        // Create the tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Connect the nodes
        Node result = solution.connect2(root);

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
