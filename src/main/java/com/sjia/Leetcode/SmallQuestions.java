package com.sjia.Leetcode;

import java.util.Arrays;

public class SmallQuestions {



    public static void main(String[] args) {

        // write code to generate 1/5, 1/4, 1/3, 1/2, 1, 2, 3, 4, 5
        double a = 1;
        int len = 9;
        double[] array = new double[len];
        for (int l = len / 2, r = len / 2; l > -1 && r < len; --l, ++r) {
            array[l] = 1 / a;
            array[r] = a++;
        }
        System.out.println(" array is : " + Arrays.toString(array));


        double res;
        for (int i=1; i< 10; i++) {
            if (i<=5 ) {
                res = 1/(6-i);
                int tmp = 6-i;
                System.out.println( res );
//                System.out.println( "1/" + tmp );
            } else {
                res = i - 4;
                System.out.println( res );
            }
        }


    }




}
