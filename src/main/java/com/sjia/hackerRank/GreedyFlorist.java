package com.sjia.hackerRank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class GreedyFlorist {
    // https://www.hackerrank.com/challenges/greedy-florist/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
    /*
    (1+1) * price for the second flower from the same person

    (c.length - i ) % k ==0

     */

    // k :  number of people;
    static int getMinimumCost(int k, int[] c) {
        int res = 0;
        int multiple =1;
        Arrays.sort(c);

        for (int i = c.length-1; i >= 0; i--) {
            res += c[i] * multiple;
            if(  (c.length - i ) % k ==0 ) {
                multiple++;
            }
        }
        return res;

    }


    // sort int[] desc
    static int getMinimumCost2(int k, int[] c) {
        int res = 0;
        int multiple =1;

        // int[] cannot sort desc  directly
//        Arrays.sort(c, (a,b) -> (b-a) );
//        Collections.sort(c, Collections.reverseOrder() );

        List<Integer> list = new ArrayList<>();
        for ( int num : c) {
            list.add(num);
        }

        Collections.sort(list, (a,b) -> (b-a));

        for (int i = 0; i <= list.size()-1; i++) {
            res += list.get(i) * multiple;
            if(  i % k == k-1 ) {
                multiple++;
            }
        }
        return res;

    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int k =3;
        int[] c = {1,2,3,4};

        int result1 = getMinimumCost(k, c);

        System.out.println( Arrays.toString(c) + " k is " + k + " getMinimumCost: " + result1);


/*
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
        */
    }
}
