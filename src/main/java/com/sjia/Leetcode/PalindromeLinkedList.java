package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {

    // #234. Palindrome Linked List https://leetcode.com/problems/palindrome-linked-list/
    /*
    Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
    Input: head = [1,2,2,1]     Output: true

     */

    // Runtime: 3 ms, faster than 33.04% of Java online submissions for Palindrome Linked List.
    //Memory Usage: 43.3 MB, less than 26.87% of Java online submissions for Palindrome Linked List.

    // copy to ArrayList, two pointer
    public boolean isPalindromeArrayList(ListNode head) {
        List<Integer> tmp = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            tmp.add(cur.val);
            cur = cur.next;
        }

        int left =0, right = tmp.size()-1;
        while(left < right) {
            // Integer object, if we use tmp.get(left) !=  tmp.get(right) , test case failed in 2020, but passed now
            // better to use equals method
//             if( tmp.get(left) != tmp.get(right)) {
            if( ! tmp.get(left).equals( tmp.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }


    // fast, slow pointers Runtime: 1 ms, faster than 97.19% of Java online submissions for Palindrome Linked List.
    //Memory Usage: 45.4 MB, less than 11.27% of Java online submissions for Palindrome Linked List.

    public boolean isPalindrome(ListNode head) {
        ListNode fast =head, slow = head;
        while(fast !=null && fast.next !=null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast !=null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while( slow!= null) {
            if(fast.val != slow.val ) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode tmpNext = head.next;
            head.next = prev;
            prev = head;
            head = tmpNext;
        }
        return prev;
    }


    public static void main(String[] args) {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();

        // Create a palindrome linked list: 1 -> 2 -> 3 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        System.out.println("Is Palindrome: " + palindromeLinkedList.isPalindromeArrayList(head)); // Output: true
    }


}
