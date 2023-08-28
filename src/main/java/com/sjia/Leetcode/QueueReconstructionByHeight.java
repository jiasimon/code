package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {
    // #406. Queue Reconstruction by Height     https://leetcode.com/problems/queue-reconstruction-by-height/description/

    /*
    You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.

    Reconstruct and return the queue that is represented by the input array people. The returned queue should be formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).

    Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
    Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]

    Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
    Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]

    1 <= people.length <= 2000
    0 <= hi <= 10^6
     */


    // (a,b) -> a[0]==b[0] ? a[1] - b[1] : b[0] - a[0]
    // 7 ms, 85.70%; 44.7 MB, 21.46%
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> res = new ArrayList<>();

        Arrays.sort(people, (a,b) -> a[0]==b[0] ? a[1] - b[1] : b[0] - a[0]);

        for ( int[] p : people) {
            res.add(p[1], p);
        }

        return res.toArray(new int[res.size()][]);

    }



    // 7 ms, 85.70%; 44.4 MB, 65.13%
    // (a, b) -> { if else }
    public int[][] reconstructQueue_comparator(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                // Sort by height in descending order
                return b[0] - a[0];
            } else {
                // If heights are the same, sort by k value in ascending order
                return a[1] - b[1];
            }
        });

        List<int[]> queue = new ArrayList<>();
        for (int[] person : people) {
            // Insert at the index specified by k value
            queue.add(person[1], person);
        }

        return queue.toArray(new int[queue.size()][]);
    }


    public static void main(String[] args) {
        QueueReconstructionByHeight solution = new QueueReconstructionByHeight();

        int[][] people = {
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };

        int[][] reconstructedQueue = solution.reconstructQueue(people);
        System.out.println("Reconstructed Queue:");
        for (int[] person : reconstructedQueue) {
            System.out.println(Arrays.toString(person));
        }
    }

}
