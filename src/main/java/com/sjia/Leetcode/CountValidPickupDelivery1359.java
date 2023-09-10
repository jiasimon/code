package com.sjia.Leetcode;

public class CountValidPickupDelivery1359 {
    // #1359. Count All Valid Pickup and Delivery Options   https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/description/?envType=daily-question&envId=2023-09-10

    /*
    Given n orders, each order consist in pickup and delivery services.

    Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i).

    Since the answer may be too large, return it modulo 10^9 + 7.

    Input: n = 1        Output: 1
    Explanation: Unique order (P1, D1), Delivery 1 always is after of Pickup 1.

    Input: n = 2        Output: 6
    Explanation: All possible orders:
    (P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1).
    This is an invalid order (P1,D2,P2,D1)

    Input: n = 3        Output: 90

    1 <= n <= 500
     */

    public int countOrders(int n) {
        long res = 1;
        long MOD = 1_000_000_007; // mod: 10^9 + 7

        for ( int i=1; i<=n; i++) {
            res = (res * i * (2*i -1) ) % MOD;
        }

        return (int)res;
    }

    public static void main(String[] args) {
        CountValidPickupDelivery1359 solution = new CountValidPickupDelivery1359();
        int n = 3;
        int count = solution.countOrders(n);
        System.out.println("Count of Valid Pickup and Delivery Options: " + count); // Output: 90
    }

}
