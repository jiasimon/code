package com.sjia.Leetcode;

public class SortedArrayBST {

    // #108 https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/


/*

    public class TreeNode {
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
    }
*/


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
    //Memory Usage: 38.7 MB, less than 98.92% of Java online submissions for Convert Sorted Array to Binary Search Tree.

    public TreeNode sortedArrayToBST(int[] nums) {
        return helperBST(nums, 0, nums.length-1 );

    }

    public TreeNode helperBST(int[] nums, int left, int right ) {
        if (left > right) return null;
        int mid = (left + right) /2;
        TreeNode root = new TreeNode (nums[mid]);
        root.left = helperBST(nums, left, mid-1);
        root.right = helperBST(nums, mid+1, right);
        return root;
    }



    public TreeNode sortedArrayToBST2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return constructBST(nums, 0, nums.length - 1);
    }

    private TreeNode constructBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = constructBST(nums, start, mid - 1);
        root.right = constructBST(nums, mid + 1, end);

        return root;
    }




}
