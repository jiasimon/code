package com.sjia.Leetcode700;

public class MyLinkedList {
    // #707. Design Linked List     https://leetcode.com/problems/design-linked-list/description/

    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;  // Head of the linked list
    private int size;   // Size of the linked list

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // Get the value of the node at the given index
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    // Add a node of value val at the head of the list
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Add a node of value val at the tail of the list
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }

    // Add a node of value val at the given index
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;  // Invalid index
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node newNode = new Node(val);
        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }

    // Delete the node at the given index
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;  // Invalid index
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
        size--;
    }



    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

        // Test Case 1: Add elements at head and tail
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        System.out.println(linkedList.get(0));  // Output: 1

        // Test Case 2: Add element at index
        linkedList.addAtIndex(1, 2);  // List becomes 1 -> 2 -> 3
        System.out.println(linkedList.get(1));  // Output: 2

        // Test Case 3: Delete element at index
        linkedList.deleteAtIndex(1);  // List becomes 1 -> 3
        System.out.println(linkedList.get(1));  // Output: 3

        // Test Case 4: Get element at invalid index
        System.out.println(linkedList.get(3));  // Output: -1
    }
    
}
