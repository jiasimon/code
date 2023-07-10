package com.sjia.Leetcode;

public class CopyListRandomPointer {
    // #138. Copy List with Random Pointer  https://leetcode.com/problems/copy-list-with-random-pointer/description/
    /*
    A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
    Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer

    Input: head = [[1,1],[2,1]] Output: [[1,1],[2,1]]
    Input: head = [[3,null],[3,0],[3,null]] Output: [[3,null],[3,0],[3,null]]

    0 <= n <= 1000, -10^4 <= Node.val <= 10^4
     */

    class Node {
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


}
