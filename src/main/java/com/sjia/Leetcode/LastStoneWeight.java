package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    // #1046 https://leetcode.com/problems/last-stone-weight/

    // 1 <= stones.length <= 30
    // 1 <= stones[i] <= 1000


    // if we can modify input, since array length is small
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Last Stone Weight.
    // Memory Usage: 36.2 MB, less than 19.85% of Java online submissions for Last Stone Weight.
/*    public int lastStoneWeight(int[] stones) {
        int N = stones.length;
        Arrays.sort(stones);
        for (int i=N-1; i>=1; i-- ) {
            stones[i-1] = stones[i] - stones[i-1];
            Arrays.sort(stones);
        }
        return stones[0];
    }*/


    // PriorityQueue
    // Runtime: 1 ms, faster than 92.21% of Java online submissions for Last Stone Weight.
    // Memory Usage: 36.3 MB, less than 19.85% of Java online submissions for Last Stone Weight.
/*    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i: stones) {
            pq.add(i);
        }
        int x, y;
        while (pq.size()>1){
            x = pq.poll();
            y = pq.poll();
            if (y !=x)
            pq.offer(x-y);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }*/


    // Runtime: 1 ms, faster than 92.04% of Java online submissions for Last Stone Weight.
    //Memory Usage: 36.3 MB, less than 19.42% of Java online submissions for Last Stone Weight.
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones)
            pq.offer(i);
        while (pq.size() > 1)
            pq.offer(pq.poll() - pq.poll());
        return pq.poll();
    }




}
