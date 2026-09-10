package com.sjia.hackerRank2026;

import java.util.List;

public class NewYearChaos {
    // https://www.hackerrank.com/challenges/new-year-chaos/problem
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int bribes = 0;
        for ( int i=0; i < q.size(); i++) {
            if (q.get(i) - (i+1) >2 ) {
                System.out.println("Too chaotic");
                return;
            }
            int start = Math.max(0, q.get(i) - 2);
            for (int j =start; j < i; j++) {
                if (q.get(j) > q.get(i)) bribes++;
            }
        }
        System.out.println(bribes);
    }

    static void minimumBribesNCustomer(int[] q) {
        int n = q.length;
        int bribes = 0;
        final int MAX_BRIBE = 3; // <-- changed from 2 to 3

        for (int i = n - 1; i >= 0; i--) {
            // If a person moved forward more than MAX_BRIBE positions, it's impossible
            if (q[i] - (i + 1) > MAX_BRIBE) {
                System.out.println("Too chaotic");
                return;
            }

            // Only need to check people who could have bribed q[i]
            // i.e. those originally within MAX_BRIBE positions ahead of q[i]'s current spot
            for (int j = Math.max(0, q[i] - MAX_BRIBE); j < i; j++) {
                if (q[j] > q[i]) {
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }


    public static void minimumBribes2(List<Integer> q) {
        int totalBribes = 0;

        for (int i = 0; i < q.size(); i++) {
            // Original 1-based index position for the person currently at index i
            int originalPosition = q.get(i);
            // Current 1-based position in the queue
            int currentPosition = i + 1;


            if (originalPosition - currentPosition > 2) {
                System.out.println("Too chaotic");
                return;
            }

            int startLookback = Math.max(0, originalPosition - 2);
            for (int j = startLookback; j < i; j++) {
                if (q.get(j) > originalPosition) {
                    totalBribes++;
                }
            }
        }

        System.out.println(totalBribes);
    }

}
