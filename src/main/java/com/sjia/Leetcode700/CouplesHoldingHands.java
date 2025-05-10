package com.sjia.Leetcode700;

public class CouplesHoldingHands {
    // #765. Couples Holding Hands https://leetcode.com/problems/couples-holding-hands/description/
    /*
    Input: row = [0,2,1,3]   Output: 1
    Explanation: We only need to swap the first and second person to get the couples together.

    Input: row = [3,2,0,1]   Output: 0
    2n == row.length
    2 <= n <= 30
     */

    public int minSwapsCouples(int[] row) {
        int n = row.length / 2;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < row.length; i += 2) {
            int a = row[i] / 2;
            int b = row[i + 1] / 2;
            uf.union(a, b);
        }

        return n - uf.count();
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int x) {
            if (x != parent[x]) parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }

        public int count() {
            int cnt = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i) cnt++;
            }
            return cnt;
        }
    }

    public static void main(String[] args) {
        CouplesHoldingHands solution = new CouplesHoldingHands();
        System.out.println(solution.minSwapsCouples(new int[]{0, 2, 1, 3})); // Output: 1
        System.out.println(solution.minSwapsCouples(new int[]{3, 2, 0, 1})); // Output: 0
    }


}
