package com.sjia.Leetcode;

import java.util.Stack;

public class VerifyPreorderBinaryTree {
    // #331. Verify Preorder Serialization of a Binary Tree  https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/
    /*

         _9_
        /   \
       3     2
      / \   / \
     4   1  #  6
    / \ / \   / \
    # # # #   # #
    For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#",
    where # represents a null node.
    "1,2,#,#,3,#,#"

    Input: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"   Output: true
    Input: preorder = "1,#"     Output: false
    Input: preorder = "9,#,#,1" Output: false

     */


    // stack.size() == 1, one # in the end
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int n = nodes.length;
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String currNode = nodes[i];

            // Check if the current node is a non-empty node
            while (currNode.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop(); // Pop the current "#" node
                if (stack.isEmpty()) {
                    return false; //
                }
                stack.pop(); // Pop the parent node of the consecutive "#" nodes
            }

            stack.push(currNode);
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }

    public static void main(String[] args) {
        VerifyPreorderBinaryTree solution = new VerifyPreorderBinaryTree();
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(solution.isValidSerialization(preorder)); // Output: true
    }


}
