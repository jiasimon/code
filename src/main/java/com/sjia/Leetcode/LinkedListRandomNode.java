package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedListRandomNode {
    // #382. Linked List Random Node    https://leetcode.com/problems/linked-list-random-node/description/

    /*
    Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

    Implement the Solution class:

    Solution(ListNode head) Initializes the object with the head of the singly-linked list head.
    int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be chosen.


     */


    List<Integer> list = new ArrayList<>();
    Random random= new Random();

    public LinkedListRandomNode(ListNode head) {
        while ( head != null) {
            list.add(head.val);
            head = head.next;
        }

    }

    // random.nextInt(list.size()),
    // 10 ms, 98.88%; 44.6 MB, 22.42%;
    public int getRandom() {
        int index = random.nextInt(list.size());

        return list.get(index);

    }


}


class LinkedListRandomNodeReservoir {
    private ListNode head;
    private Random rand;

    public LinkedListRandomNodeReservoir(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    public int getRandom() {
        int count = 1;
        int result = 0;
        ListNode curr = head;

        while (curr != null) {
            if (rand.nextInt(count) == 0) {
                result = curr.val;
            }
            count++;
            curr = curr.next;
        }

        return result;
    }
}






/*
class Solution {
    List<Integer> list ;
    private Random rand;

    public Solution(ListNode head) {
        list = new ArrayList<>();
        rand = new Random();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }


    }

    public int getRandom() {
        int tmp = rand.nextInt(list.size());
        return list.get(tmp);

    }
}
 */

