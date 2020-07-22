package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTreeLevelTraversal {

    // #107 https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

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


    // Runtime: 2 ms, faster than 42.70% of Java online submissions for Binary Tree Level Order Traversal II.
    //Memory Usage: 40.8 MB, less than 5.02% of Java online submissions for Binary Tree Level Order Traversal II.
/*
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();

        levelTraversal(resultList, root, 0);
        return resultList;
    }

    private void levelTraversal(List<List<Integer>> resultList, TreeNode root, int level) {
        if (root == null) return ;
        if ( level >= resultList.size() ) {
            resultList.add(0, new LinkedList<Integer>());
        }
        levelTraversal(resultList,root.left, level+1);
        levelTraversal(resultList,root.right, level+1);
        resultList.get(resultList.size()-level-1).add(root.val);
    }*/


    // BFS , follow up
    // Runtime: 1 ms, faster than 89.66% of Java online submissions for Binary Tree Level Order Traversal II.
    //Memory Usage: 41.3 MB, less than 5.02% of Java online submissions for Binary Tree Level Order Traversal II.

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        TreeNode p = root;//循环指针
        List<List<Integer>> result = new LinkedList<>();//要返回的结果列表
        Queue<TreeNode> myQueue = new LinkedList<TreeNode>();//辅助队列
        if (p == null) return result;//如果树为空就返回空表
        myQueue.offer(p);//将根节点入队
        while (!myQueue.isEmpty()) {//循环跳出条件为队空
            List<Integer> tempList = new ArrayList<>();//创建临时列表
            int len = myQueue.size();//记录下此时队列的长度
            for (int i = 0; i < len; i++) {//进行len次循环，刚好将本层元素的值全部出队并送入临时列表
                p = myQueue.poll();//将队顶元素出队
                tempList.add(p.val);//将队顶元素的值送入临时列表
                if (p.left != null) myQueue.offer(p.left);//队顶元素左子节点入队
                if (p.right != null) myQueue.offer(p.right);//队顶元素右子节点入队
            }
            result.add(0, tempList);
        }
        return result;
    }


}
