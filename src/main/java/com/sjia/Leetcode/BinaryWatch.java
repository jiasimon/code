package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    // #401. Binary Watch   https://leetcode.com/problems/binary-watch/description/

    /*
    A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent the minutes (0-59).
    Each LED represents a zero or one, with the least significant bit on the right.

    For example, the below binary watch reads "4:51".

    The hour must not contain a leading zero.

    For example, "01:00" is not valid. It should be "1:00".
    The minute must consist of two digits and may contain a leading zero.

    For example, "10:2" is not valid. It should be "10:02".


    Input: n = 1
    Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
     */

    // Integer.bitCount(h) + Integer.bitCount(m)
    // 12 ms, 27.50%; 41.6 MB, 41.47%
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();

        for ( int h = 0; h < 12; h++) {
            for ( int m = 0; m < 60; m++) {
                if( Integer.bitCount(h) + Integer.bitCount(m) == num ) {
                    res.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return res;

    }




    // m < 10 ? "0" + m : m
    // 10 ms, 42.79%; 41 MB, 91.3%
    public List<String> readBinaryWatch_(int num) {
        List<String> res = new ArrayList<>();
        //直接遍历  0:00 -> 12:00   每个时间有多少1
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == num)
                    res.add(h + ":" + (m < 10 ? "0" + m : m));
            }
        }
        return res;

    }


    public static void main(String[] args) {
        BinaryWatch binaryWatch = new BinaryWatch();
        int num = 1;
        List<String> times = binaryWatch.readBinaryWatch(num);
        System.out.println("Possible times with " + num + " set bit(s):");
        for (String time : times) {
            System.out.println(time);
        }
    }

}
