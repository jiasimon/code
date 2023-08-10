package com.sjia.hackerRank;

import java.util.Scanner;

public class MinimumSwaps2 {


    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i + 1) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
                swaps++;
            }
        }
        return swaps;

    }

    static int minimumSwaps_TLE(int[] arr) {
        int count = 0;
        for ( int i=0; i < arr.length; i++) {
            for (int j=i+1; j < arr.length; j++ ) {
                if(arr[j] == i+1 ) {
                    swap(arr, i, j);
                    count++;
                }
            }
        }
        return count;

    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = {4,3,1,2};

        int[] arr2 = {7,1,3,2,4,5,6};

        int res = minimumSwaps(arr);
        System.out.println(arr + " minimumSwaps is :" + res);


/*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        int swaps = minimumSwaps(arr);
        System.out.println(swaps);
        */
    }


}
