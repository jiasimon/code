package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyListRandomPointer {
    // #138. Copy List with Random Pointer  https://leetcode.com/problems/copy-list-with-random-pointer/description/
    /*
    A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
    Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer

    Input: head = [[1,1],[2,1]] Output: [[1,1],[2,1]]
    Input: head = [[3,null],[3,0],[3,null]] Output: [[3,null],[3,0],[3,null]]

    0 <= n <= 1000, -10^4 <= Node.val <= 10^4
     */

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a new node for each existing node and insert it next to the existing node
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        // Step 2: Assign the random pointer of each new node
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the original and cloned lists
        Node clonedHead = head.next;
        Node clonedCurrent = clonedHead;
        current = head;

        while (current != null) {
            current.next = current.next.next;
            if (clonedCurrent.next != null) {
                clonedCurrent.next = clonedCurrent.next.next;
            }
            current = current.next;
            clonedCurrent = clonedCurrent.next;
        }

        return clonedHead;
    }



    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList_map(Node head) {
        if (head == null)
            return null;
        if (map.containsKey(head))
            return map.get(head);

        Node newNode = new Node(head.val);
        map.put(head, newNode);
        newNode.next = copyRandomList_map(head.next);
        newNode.random = copyRandomList_map(head.random);
        return newNode;
    }



    public static void main(String[] args) {
        CopyListRandomPointer solution = new CopyListRandomPointer();

        // Test case
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.next = node2;
        head.random = node3;
        node2.next = node3;
        node2.random = head;
        node3.random = node2;

        Node clonedHead = solution.copyRandomList_map(head);

        // Print the cloned list
        printList(clonedHead);
    }

    private static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("Node(" + current.val + ")");
            if (current.random != null) {
                System.out.print(" -> Random(" + current.random.val + ")");
            }
            System.out.println();
            current = current.next;
        }
    }


}
