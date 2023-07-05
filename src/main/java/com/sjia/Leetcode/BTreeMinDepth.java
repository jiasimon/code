package com.sjia.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class BTreeMinDepth {

    // #111. Minimum Depth of Binary Tree https://leetcode.com/problems/minimum-depth-of-binary-tree/

    // [3,9,20,null,null,15,7], [-9,-3,2,null,4,4,0,-6,null,-5]

    // submission 2020-7-23 Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary Tree.
    //Memory Usage: 39.7 MB, less than 18.39% of Java online submissions for Minimum Depth of Binary Tree.

    // 16ms, 62.3MB submission 2023-7-5
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        if(root.left == null && root.right == null) return 1;

        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);

        if(root.left == null || root.right == null) return m1 + m2 + 1;

        return Math.min(m1,m2) + 1;

    }

    // 12 ms , 62.2 MB
    public int minDepthDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // If only one of child is non-null, then go into that recursion.
        if (root.left == null) {
            return 1 + minDepthDfs(root.right);
        } else if (root.right == null) {
            return 1 + minDepthDfs(root.left);
        }

        // Both children are non-null, hence call for both childs.
        return 1 + Math.min(minDepthDfs(root.left), minDepthDfs(root.right));
    }


    // 10ms, 61.8 MB
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        int L = minDepth2(root.left), R = minDepth2(root.right), m = Math.min(L, R);
        return 1 + (m > 0 ? m : Math.max(L, R));
    }




    //  BFS, 1ms, 99.31% ; 61.4MB, 87.10%
    public int minDepthBFS(TreeNode root) {
        if(root == null) return 0;
        int depth = 1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            // for each level
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left == null && node.right == null){
                    return depth;
                }
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }



    //  add test cases
    public static void main(String[] args) {
        BTreeMinDepth solution = new BTreeMinDepth();

        // Input: rt = [3,9,20,null,null,15,7]
        TreeNode rt = new TreeNode(3);
        rt.left = new TreeNode(9);
        rt.right = new TreeNode(20);

        rt.right.left = new TreeNode(15);
        rt.right.right = new TreeNode(7);

        int res1 = solution.minDepthBFS(rt);
        System.out.println("pathSum tree: " + res1);


        // [5,4,8,11,null,13,4,7,2,null,null,5,1]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);


        // root = [5,4,8,11,null,13,4,7,2,null,null,5,1]  targetSum = 22
        // Output: [[5,4,11,2],[5,8,4,5]]
        int res2 = solution.minDepthBFS(root);
        System.out.println("pathSum tree: " + res2);


    }


}
