package com.sjia.Leetcode;

import java.util.*;

public class ComparatorSort {

    private static class StringSizeComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return a.length() - b.length();
        }
    }


    private static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return (b+a).compareTo(a+b);
        }
    }



    public static void main(String[] args) {

        //int[] testData  = {0,0};
        List<String> testData  = Arrays.asList("a12", "b2", "b", "c", "c123");
        List<String> input2  = Arrays.asList("cc123", "c123c");

//        testData.sort(String::compareTo);
//        System.out.printf(" testData after sort  is %s \n", testData);

        Collections.sort(testData);
        System.out.printf(" testData after sort  is %s \n", testData);

        Collections.reverse(testData);
        System.out.printf(" testData after Collection reverse  is %s \n", testData);

        Collections.sort(testData, new StringSizeComparator());
        System.out.printf(" testData after size compare is %s \n", testData);

        Collections.sort(testData, new MyComparator());
        System.out.printf(" testData after MyComparator  is %s \n", testData);



    }



}
