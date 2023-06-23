package com.sjia.Leetcode;

public class SymmetricTree {

/*    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }*/
    // #101. Symmetric Tree https://leetcode.com/problems/symmetric-tree/
    /*
    Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
    The number of nodes in the tree is in the range [1, 1000].
    -100 <= Node.val <= 100
     */


    // Runtime: 1 ms, faster than 39.46% of Java online submissions for Symmetric Tree.
    //Memory Usage: 40.3 MB, less than 5.05% of Java online submissions for Symmetric Tree.

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return checkSymmetric(root.left, root.right);
    }

    // use "else if, else" instead of "if, if"
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
    //Memory Usage: 37.3 MB, less than 97.09% of Java online submissions for Symmetric Tree.

    public boolean checkSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;
        else return (left.val == right.val) && checkSymmetric(left.left, right.right)
                    && checkSymmetric(left.right, right.left);
    }

    public boolean checkMirror(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        else return (left.val == right.val) && checkMirror(left.left, right.right) && checkMirror(left.right, right.left);
    }



    public static void main(String[] args) {
        SymmetricTree solution = new SymmetricTree();

        // Example tree: [1,2,2,3,4,4,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean isSymmetric = solution.isSymmetric(root);
        System.out.println("Is the tree symmetric? " + isSymmetric);
    }


}
