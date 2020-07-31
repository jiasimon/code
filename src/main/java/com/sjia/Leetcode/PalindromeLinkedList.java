package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {

    // #234 https://leetcode.com/problems/palindrome-linked-list/

    // Runtime: 3 ms, faster than 33.04% of Java online submissions for Palindrome Linked List.
    //Memory Usage: 43.3 MB, less than 26.87% of Java online submissions for Palindrome Linked List.
    public boolean isPalindrome(ListNode head) {
        List<Integer> tmpList = new ArrayList<>();
        ListNode cur = head;
        while (cur !=null) {
            tmpList.add(cur.val);
            cur = cur.next;
        }
        int left=0, right = tmpList.size()-1;
        while(left < right) {
            if (tmpList.get(left) != tmpList.get(right)) return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }

}
