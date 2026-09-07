package com.sjia.hackerRank2026;

public class TowerBreakers {
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-tower-breakers-1

    public static int towerBreakersOld(int n, int m) {
        if ( m == 1) return 2;
        if (n%2 == 1) {
            return 1;
        } else {
            return 2;
        }
    }


    public static int towerBreakers(int n, int m) {
        if (m == 1 || n % 2 == 0) return 2;
        return 1;
    }

}
