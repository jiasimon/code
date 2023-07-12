package com.sjia.Leetcode;

import java.util.Arrays;

public class InsertionSortList {
    // #147. Insertion Sort List    https://leetcode.com/problems/insertion-sort-list/
    /*
    Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
    Input: head = [4,2,1,3]     Output: [1,2,3,4]
    Input: head = [-1,5,3,4,0]  Output: [-1,0,3,4,5]
    The number of nodes in the list is in the range [1, 5000].
     */


    // dummy, prev, curr, two while
    // 20 ms, 58.33%; 43.4 MB, 53.27%
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = head;

        while (current != null) {
            // At each iteration, we insert an element into the resulting list.
            ListNode nextNode = current.next;
            ListNode prev = dummy;
            ListNode curr = dummy.next;

            while (curr != null && curr.val < current.val) {   // "<" or "<="
                prev = curr;
                curr = curr.next;
            }

            prev.next = current;
            current.next = curr;

            current = nextNode;
        }

        return dummy.next;
    }


    // convert to array
    // 2 ms, 97.57%; 43.1 MB, 77.61%
    public ListNode insertionSortListArray(ListNode head) {
        int[] nums=new int[5000];
        int idx=0;
        ListNode temp=head;
        while (head!=null){
            nums[idx++]= head.val;
            head=head.next;
        }
        Arrays.sort(nums,0,idx);
        idx=0;
        ListNode res=temp;
        while(temp!=null){
            temp.val=nums[idx++];
            temp=temp.next;
        }
        return res;
    }



    public static void main(String[] args) {
        InsertionSortList solution = new InsertionSortList();

        // Test case: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode sortedHead = solution.insertionSortList(head);

        // Print the sorted linked list
        printList(sortedHead);
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

}
