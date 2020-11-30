package com.sjia.Leetcode;

import java.util.List;
import java.util.*;

public class VerticalOrderTraversalBTree {
    // #987 https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/ #fb

    //    3
    //  9   20
    //    15    7
    // Input: [3,9,20,null,null,15,7]
    // Output: [[9],[3,15],[20],[7]]

    // The tree will have between 1 and 1000 nodes.
    // Each node's value will be between 0 and 1000.


    // Runtime: 4 ms, faster than 33.55% of Java online submissions for Vertical Order Traversal of a Binary Tree.
    //Memory Usage: 39.3 MB, less than 45.31% of Java online submissions for Vertical Order Traversal of a Binary Tree.

    Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new HashMap<>();
    int minX = 0, maxX = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        helper(root, 0, 0);
        List<List<Integer>> vertical = new ArrayList<>();
        for (int i = minX; i <= maxX; i++) {
            List<Integer> level = new ArrayList<Integer>();
            for (int key : map.get(i).keySet()) {
                while (!(map.get(i).get(key)).isEmpty()) {
                    level.add(map.get(i).get(key).poll());
                }
            }
            vertical.add(level);
        }
        return vertical;

    }

    private void helper(TreeNode node, int x, int y) {
        if (node == null) return;
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        if (map.get(x) == null) { map.put(x, new TreeMap<Integer, PriorityQueue<Integer>>()); }
        if (map.get(x).get(y) == null) { map.get(x).put(y, new PriorityQueue<Integer>()); }
        map.get(x).get(y).add(node.val);
        helper(node.left, x - 1, y + 1);
        helper(node.right, x + 1, y + 1);

    }






    class VerticalOrderTraversalBTreeSolution {
        List<Location> locations;
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            // Each location is a node's x position, y position, and value
            locations = new ArrayList();
            dfs(root, 0, 0);
            Collections.sort(locations);

            List<List<Integer>> ans = new ArrayList();
            ans.add(new ArrayList<Integer>());

            int prev = locations.get(0).x;

            for (Location loc: locations) {
                // If the x value changed, it's part of a new report.
                if (loc.x != prev) {
                    prev = loc.x;
                    ans.add(new ArrayList<Integer>());
                }

                // We always add the node's value to the latest report.
                ans.get(ans.size() - 1).add(loc.val);
            }

            return ans;
        }

        public void dfs(TreeNode node, int x, int y) {
            if (node != null) {
                locations.add(new Location(x, y, node.val));
                dfs(node.left, x-1, y+1);
                dfs(node.right, x+1, y+1);
            }
        }
    }

    class Location implements Comparable<Location>{
        int x, y, val;
        Location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Location that) {
            if (this.x != that.x)
                return Integer.compare(this.x, that.x);
            else if (this.y != that.y)
                return Integer.compare(this.y, that.y);
            else
                return Integer.compare(this.val, that.val);
        }
    }


}
