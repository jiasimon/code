package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin {
    // #973 https://leetcode.com/problems/k-closest-points-to-origin/   #fb



    // lambda
    // Runtime: 22 ms, faster than 59.23% of Java online submissions for K Closest Points to Origin.
    //Memory Usage: 47.7 MB, less than 55.49% of Java online submissions for K Closest Points to Origin.
    public int[][] kClosest(int[][] points, int K) {
        List<int[]> res  = new ArrayList<>();
        Arrays.sort(points, (a, b) -> a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1] );
        for (int[] p : points ) {
            if (K > 0) {
                res.add(p);
                K--;
            }
        }
        return res.toArray(new int[K][]);
    }


    public int[][] kClosest3(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }


    // solution:2
    public int[][] kClosest2(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }


}
