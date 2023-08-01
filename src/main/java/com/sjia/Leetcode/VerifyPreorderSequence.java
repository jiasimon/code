package com.sjia.Leetcode;

import java.util.Stack;

public class VerifyPreorderSequence {
    // #255. Verify Preorder Sequence in Binary Search Tree https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/
    /*
    https://grandyang.com/leetcode/255/

         5
        / \
       2   6
      / \
     1   3

     Input: [5,2,6,1,3]     Output: false
     Input: [5,2,1,3,6]     Output: true

     */

    // stack
    public boolean verifyPreorder(int[] preorder) {
        int minValue = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for (int num : preorder) {
            if (num < minValue) {
                return false;
            }

            while (!stack.isEmpty() && num > stack.peek()) {
                minValue = stack.pop();
            }

            stack.push(num);
        }

        return true;
    }



    public boolean verifyPreorder_Stack(int[] preorder) {
        int minValue = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        stack.push(preorder[0]);

        for (int i=1; i < preorder.length ; i++) {
            if( preorder[i] < minValue) {
                return false;
            }

            while(!stack.isEmpty() && stack.peek() < preorder[i] ) {
                minValue = stack.pop();
            }

            stack.push(preorder[i]);
        }
        return true;
    }




    public static void main(String[] args) {
        int[] preorder = {5, 2, 6, 1, 3};
        VerifyPreorderSequence solution = new VerifyPreorderSequence();
        boolean result = solution.verifyPreorder(preorder);
        System.out.println("Is the sequence a valid preorder traversal of a BST? " + result); // Output: Is the sequence a valid preorder traversal of a BST? false
    }

}
