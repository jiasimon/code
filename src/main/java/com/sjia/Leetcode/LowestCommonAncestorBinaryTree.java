package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestorBinaryTree {
    // #236. Lowest Common Ancestor of a Binary Tree https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/  #fb
    // The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
    // (where we allow a node to be a descendant of itself).”

    // LCA, LCABT


/*
         The number of nodes in the tree is in the range [2, 105].
         -10^9 <= Node.val <= 10^9
         All Node.val are unique.
         p != q
         p and q will exist in the tree.
*/





    // left != null && right !=null
    // Runtime: 4 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
    //Memory Usage: 41.4 MB, less than 27.49% of Java online submissions for Lowest Common Ancestor of a Binary Tree.

    // PostOrder?
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        if (leftLCA != null && rightLCA != null ) {
            return root;
        }
        else if (leftLCA != null) return leftLCA;
        else return rightLCA;

    }


    // Runtime: 4 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
    //Memory Usage: 41 MB, less than 73.30% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
/*    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }
    */



    // HashMap Store parentNode
    public void dfs(TreeNode root, Map parent) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left,parent);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right, parent);
        }
    }

    public TreeNode lowestCommonAncestorHashMap(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
        Set<Integer> visited = new HashSet<Integer>();
        dfs(root, parent);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }




    public static void main(String[] args) {
        LowestCommonAncestorBinaryTree lcaBT = new LowestCommonAncestorBinaryTree();

        // Create a Binary Tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left; // Node with value 5
        TreeNode q = root.left.right.right; // Node with value 4

        TreeNode lowestCommonAncestor = lcaBT.lowestCommonAncestorHashMap(root, p, q);
        System.out.println("Lowest Common Ancestor: " + lowestCommonAncestor.val); // Output: 5

    }

}
