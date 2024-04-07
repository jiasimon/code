package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorder {
    // #590. N-ary Tree Postorder Traversal     https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
    /*
    Given the root of an n-ary tree, return the postorder traversal of its nodes' values.

    Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)


     */

    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root == null) {
            return res;
        }
        for(Node n : root.children){
            postorder(n);
        }
        res.add(root.val);
        return res;
    }

    


}
