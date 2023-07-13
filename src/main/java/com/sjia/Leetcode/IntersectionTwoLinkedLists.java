package com.sjia.Leetcode;

public class IntersectionTwoLinkedLists {
    // #160. Intersection of Two Linked Lists   https://leetcode.com/problems/intersection-of-two-linked-lists/
    /*
    Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

    For example, the following two linked lists begin to intersect at node c1:

        Case 1 (Have Intersection & Same Len):
               a
        A:     a1 → a2 → a3
                           ↘
                             c1 → c2 → c3 → null
                           ↗
        B:     b1 → b2 → b3
               b
                    a
        A:     a1 → a2 → a3
                           ↘
                             c1 → c2 → c3 → null
                           ↗
        B:     b1 → b2 → b3
                    b
                         a
        A:     a1 → a2 → a3
                           ↘
                             c1 → c2 → c3 → null
                           ↗
        B:     b1 → b2 → b3
                         b
        A:     a1 → a2 → a3
                           ↘ a
                             c1 → c2 → c3 → null
                           ↗ b
        B:     b1 → b2 → b3
        Since a == b is true, end loop while(a != b), return the intersection node a = c1.


        Case 2 (Have Intersection & Different Len):
                    a
        A:          a1 → a2
                           ↘
                             c1 → c2 → c3 → null
                           ↗
        B:     b1 → b2 → b3
               b
                         a
        A:          a1 → a2
                           ↘
                             c1 → c2 → c3 → null
                           ↗
        B:     b1 → b2 → b3
                    b
        A:          a1 → a2
                           ↘ a
                             c1 → c2 → c3 → null
                           ↗
        B:     b1 → b2 → b3
                         b
        A:          a1 → a2
                           ↘      a
                             c1 → c2 → c3 → null
                           ↗ b
        B:     b1 → b2 → b3
        A:          a1 → a2
                           ↘           a
                             c1 → c2 → c3 → null
                           ↗      b
        B:     b1 → b2 → b3
        A:          a1 → a2
                           ↘                a = null, then a = b1
                             c1 → c2 → c3 → null
                           ↗           b
        B:     b1 → b2 → b3
        A:          a1 → a2
                           ↘
                             c1 → c2 → c3 → null
                           ↗                b = null, then b = a1
        B:     b1 → b2 → b3
               a
                    b
        A:          a1 → a2
                           ↘
                             c1 → c2 → c3 → null
                           ↗
        B:     b1 → b2 → b3
                    a
                         b
        A:          a1 → a2
                           ↘
                             c1 → c2 → c3 → null
                           ↗
        B:     b1 → b2 → b3
                         a
        A:          a1 → a2
                           ↘ b
                             c1 → c2 → c3 → null
                           ↗ a
        B:     b1 → b2 → b3
        Since a == b is true, end loop while(a != b), return the intersection node a = c1.


        Case 3 (Have No Intersection & Same Len):
               a
        A:     a1 → a2 → a3 → null
        B:     b1 → b2 → b3 → null
               b
                    a
        A:     a1 → a2 → a3 → null
        B:     b1 → b2 → b3 → null
                    b
                         a
        A:     a1 → a2 → a3 → null
        B:     b1 → b2 → b3 → null
                         b
                              a = null
        A:     a1 → a2 → a3 → null
        B:     b1 → b2 → b3 → null
                              b = null
        Since a == b is true (both refer to null), end loop while(a != b), return a = null.


     */



    //  getLength, adjust to same
    // 1 ms , 99.99% ; 46.5 MB 81.4%
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA), lenB = getLength(headB);
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;

    }



    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }



}
