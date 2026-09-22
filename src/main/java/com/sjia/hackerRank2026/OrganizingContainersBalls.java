package com.sjia.hackerRank2026;

import java.util.Arrays;
import java.util.List;

public class OrganizingContainersBalls {
    // https://www.hackerrank.com/challenges/organizing-containers-of-balls

    public static String organizingContainers(List<List<Integer>> container) {
        int n = container.size();

        long[] containerCapacities = new long[n]; // total balls in each container
        long[] ballTypeCounts = new long[n];    // total balls of each type, across all containers

        // Calculate the row sums (capacities) and column sums (ball types)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long value = container.get(i).get(j);
                containerCapacities[i] += value;
                ballTypeCounts[j] += value;
            }
        }

        // Sort both arrays to compare their distributions
        Arrays.sort(containerCapacities);
        Arrays.sort(ballTypeCounts);

        // If they match perfectly, organization is possible
        if (Arrays.equals(containerCapacities, ballTypeCounts)) {
            return "Possible";
        } else {
            return "Impossible";
        }
    }

}
