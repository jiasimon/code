package com.sjia.Leetcode;

import java.util.Arrays;

public class AddTwoNumbers {
    // #2 https://leetcode.com/problems/add-two-numbers/
    // Input: l1 = [2,4,3], l2 = [5,6,4]    Output: [7,0,8], 342 + 465 = 807
    // l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] [8,9,9,9,0,0,0,1]

    static int[] addTwoNumbers(int[] input1, int[] input2) {
        int size = input1.length + 1 ;
        int smallSize = input2.length;

        int[] result = new int[size];
        int carry = 0;
        for (int i =0; i< size-1; i++) {
            int sum;
            if (i < smallSize )  {
                sum = carry + input1[i] + input2[i];
            } else {
                sum = carry + input1[i];
            }
            result[i] = sum%10;
            carry = sum/10;
        }
        if(carry == 1) {
            result[size-1] =1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num1 = { 2, 4, 3};
        int[] num2 = { 5, 6, 2};
        //int[] num2 = { };
        //int[] num2 = { 5, 6};
        int[] result;


        if (num1.length >= num2.length) {
            result = addTwoNumbers(num1, num2);
        } else {
            result = addTwoNumbers(num2, num1);
        }

        if (result[result.length-1] == 1) {
            System.out.print(result[result.length-1]);
        }
        for ( int j= result.length-2; j>=0; j--)
            System.out.print(result[j]);

        System.out.println("The result is: " + Arrays.toString( result) );

    }


    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Two Numbers.
    // Memory Usage: 39.3 MB, less than 17.05% of Java online submissions for Add Two Numbers.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry =0;
        while (l1 != null || l2 != null) {
            int d1 = l1 == null ? 0 : l1.val;
            int d2 = l2 == null ? 0 : l2.val;
            int sum =d1 + d2 + carry;
            carry = sum /10 ;
            cur.next = new ListNode (sum %10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if( carry ==1) cur.next = new ListNode(1);
        return dummy.next;
    }


/*    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int d1 = l1 == null ? 0 : l1.val;
            int d2 = l2 == null ? 0 : l2.val;
            int sum = d1 + d2 + carry;
            carry = sum >= 10 ? 1 : 0;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) cur.next = new ListNode(1);
        return dummy.next;
    }*/



}
