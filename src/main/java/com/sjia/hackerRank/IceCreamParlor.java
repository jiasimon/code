package com.sjia.hackerRank;

import java.util.*;

public class IceCreamParlor {
    // https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search

    /*
    similar to 2Sum,  but need some updates
    1 based index, r1<=r2
     */

    public static void whatFlavors(List<Integer> cost, int money) {
        // Write your code here
        Map<Integer, Integer> map  = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for ( int i = 0 ; i < cost.size(); i++ ) {
            if  ( map.containsKey(money - cost.get(i)) ) {
                result.add(i+1 );
                result.add(map.get(money - cost.get(i))+1);
                int r1 = i+1 ;
                int r2 = map.get(money - cost.get(i))+1;
                if ( r1 < r2) {
                    System.out.println(r1 + " " + r2);
                } else {
                    System.out.println(r2 + " " + r1);
                }

            } else {
                map.put(cost.get(i), i);
            }
        }

    }
}
