package com.sjia.Leetcode;

import java.util.Arrays;

public class FindMedianSortedArrays {
    // #4 Median of Two Sorted Arrays https://leetcode.com/problems/median-of-two-sorted-arrays/description/

//    Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//    The overall run time complexity should be O(log (m+n)).


    /*

        nums1.length == m
        nums2.length == n
        0 <= m <= 1000
        0 <= n <= 1000
        1 <= m + n <= 2000
        -106 <= nums1[i], nums2[i] <= 106



    We create a new array with length that of the sum of the array lengths
We initialize i & j = 0. [i for nums1 & j for nums2]
Since the given arrays are already sorted it is easy to compare their elements. We comapre by observing nums1[i] < nums2[j]
if the element in nums1nums1nums1 at ithi^{th}i
th
  is less than that of element at jthj^{th}j
th
  index of nums2nums2nums2, we add nums1[i]nums1[i]nums1[i] to new array and increment i; so as to compare the next element of the array to nums2[j].
If the opposite case arises, we add nums2[j]nums2[j]nums2[j] to the new array as you can guess. And increment j by 1 for the same reasons we did it with i.
Depending on the length of new array, we calculate median.
If the length of array is even, median by rule is the average of the 2 middle elements of the array
If it is off, it is the middlemost element

     */


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int size = n1 + n2;
        int[] tmp = new int[size];

        int i=0;
        int j=0;
        int k=0;

        while( ( i <= n1) &&  (j <= n2) ) {
            if( i == n1) {
                while (j < n2) {
                    tmp[k] = nums2[j];
                    k++;
                    j++;
                }
                break;
            } else if ( j == n2) {
                while ( i < n1) {
                    tmp[k] = nums1[i];
                    k++;
                    i++;
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                tmp[k] = nums1[i];
                k++;
                i++;
            } else {
                tmp[k] = nums2[j];
                k++;
                j++;
            }

        }

        if (size%2 == 0) return (float) (tmp[size/2 - 1] + tmp[size/2])/2;
        else return tmp[size/2];


    }


    public double findMedianSortedArraysArraycopy(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int size = n1 + n2;
        int[] tmp = new int[size];

        System.arraycopy(nums1, 0, tmp, 0, n1);
        System.arraycopy(nums2, 0, tmp, n1, n2);

        Arrays.sort(tmp);

        if (size%2 == 0) return (float) (tmp[size/2 - 1] + tmp[size/2])/2;
        else return tmp[size/2];

    }


    public static void main(String[] args) {
//        int []nums1  = {1,3};
//        int []nums2  = {2};

        int []nums1  = {1,2};
        int []nums2  = {3,4};

        FindMedianSortedArrays solution = new FindMedianSortedArrays();
        double result = solution.findMedianSortedArrays(nums1, nums2);

        System.out.printf("The result is: %s \n", result);
        System.out.printf("The result is: %.5f \n", result);  
        System.out.printf("The result is: " + result  + " \n");

        double result2 = solution.findMedianSortedArraysArraycopy(nums1, nums2);
        System.out.printf("The result by using arraycopy  is: %s \n", result2);
        System.out.printf("The result2 by using arraycopy is: %.5f \n", result2);

    }



}
