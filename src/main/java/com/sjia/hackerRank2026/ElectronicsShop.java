package com.sjia.hackerRank2026;

public class ElectronicsShop {
    // https://www.hackerrank.com/challenges/electronics-shop

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int res=-1 ;
        for(int i=0; i< keyboards.length; i++) {
            for (int j=0; j< drives.length; j++) {
                if ( (keyboards[i] + drives[j] <= b ) && (keyboards[i] + drives[j] >= res) ) {
                    res = keyboards[i] + drives[j];
                }
            }
        }
        return res;
    }


}
