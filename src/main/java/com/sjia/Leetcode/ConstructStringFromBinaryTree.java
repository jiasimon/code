package com.sjia.Leetcode;

public class ConstructStringFromBinaryTree {
    // #606. Construct String from Binary Tree  https://leetcode.com/problems/construct-string-from-binary-tree/description/
    /*
    Input: root = [1,2,3,4]     Output: "1(2(4))(3)"

    Input: root = [1,2,3,null,4]    Output: "1(2()(4))(3)"
    The number of nodes in the tree is in the range [1, 10000].
     */

    // StringBuilder
    // 4ms, 45.3MB
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        if (t.left != null || t.right != null) {
            sb.append("(").append(tree2str(t.left)).append(")");
            if (t.right != null) {
                sb.append("(").append(tree2str(t.right)).append(")");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ConstructStringFromBinaryTree solution = new ConstructStringFromBinaryTree();

        // Test Case
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println("Test Case 1: " + solution.tree2str(root)); // Output: "1(2()(4))(3)"
    }




}
