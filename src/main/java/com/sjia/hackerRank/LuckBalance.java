package com.sjia.hackerRank;

import java.util.*;

public class LuckBalance {
    // https://www.hackerrank.com/challenges/luck-balance/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms&h_r=next-challenge&h_v=zen

    /*

     */


    public static int luckBalance(int k, List<List<Integer>> contests) {
        // Write your code here
        int res = 0;
        List<Integer> important = new ArrayList<>();

        for (List<Integer> tmp : contests) {
            if (tmp.get(1) == 0) {
                res += tmp.get(0);
            } else {
                important.add(tmp.get(0));
            }
        }

        Collections.sort(important, (a,b) -> b-a);

        for (int i=0; i < important.size(); i++) {
            if(i < k) {
                res += important.get(i);
            } else {
                res -= important.get(i);
            }
        }
        return res;

    }



    public static void main(String[] args) {
        List<List<Integer>> test1 = new ArrayList<>();
        test1.add(Arrays.asList(5,1));
        test1.add(Arrays.asList(1,1));
        test1.add(Arrays.asList(4,0));

        int result1 = luckBalance(2, test1);
        System.out.println( test1 +" k=2 " + " luckBalance: " +  result1);

        int result2 = luckBalance(1, test1);
        System.out.println( test1 + " k=1 " + " luckBalance: " +  result2);




/*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> contests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int luck = scanner.nextInt();
            int importance = scanner.nextInt();
            if (importance == 0) {
                contests.add(luck);
            } else {
                contests.add(luck);
            }
        }

        int result = luckBalance(k, contests);
        System.out.println(result);
        scanner.close();*/
    }


}
