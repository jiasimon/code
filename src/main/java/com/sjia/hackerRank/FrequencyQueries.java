package com.sjia.hackerRank;

import java.util.*;

public class FrequencyQueries {
    // https://www.hackerrank.com/challenges/frequency-queries/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
    /*
    3 operations: 1, insert   ; 2, Delete  ;  3 check any frequency is exactly z

     */

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> valueFrequency = new HashMap<>();
        Map<Integer, Integer> frequencyCount = new HashMap<>();

        for (List<Integer> query : queries) {
            int op = query.get(0);
            int val = query.get(1);

            if (op == 1) {
                int tmp = valueFrequency.getOrDefault(val, 0) +1;
                valueFrequency.put(val, tmp);
                frequencyCount.put(tmp, frequencyCount.getOrDefault(tmp, 0) +1);
                frequencyCount.put(tmp-1, frequencyCount.getOrDefault(tmp-1, 0) -1);
            } else if ( op == 2) {
                int currentCount = valueFrequency.getOrDefault(val, 0);
                if ( currentCount > 0) {
                    valueFrequency.put(val, currentCount-1);
                    frequencyCount.put(currentCount-1, frequencyCount.getOrDefault(currentCount-1, 0) +1 );
                    frequencyCount.put(currentCount, frequencyCount.getOrDefault(currentCount, 0) -1 );
                }

            } else if ( op == 3) {
                if (  frequencyCount.containsKey(val) && frequencyCount.get(val) >0) {
                    result.add(1);
                } else {
                    result.add(0);
                }
            }


        }
        return result;

    }


    public static void main(String[] args) {
        List<List<Integer>> test1 = new ArrayList<>();
        test1.add(Arrays.asList(1,1));
        test1.add(Arrays.asList(2,2));
        test1.add(Arrays.asList(3,2));
        System.out.println(freqQuery(test1));
        test1.add(Arrays.asList(1,1));
        test1.add(Arrays.asList(1,1));
        test1.add(Arrays.asList(2,1));
        test1.add(Arrays.asList(3,2));
        System.out.println(freqQuery(test1));

    }


}
