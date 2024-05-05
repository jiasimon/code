package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingOffers {
    // #638. Shopping Offers    https://leetcode.com/problems/shopping-offers/description/
    /*
    Input: price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]   Output: 14
    Explanation: There are two kinds of items, A and B. Their prices are $2 and $5 respectively.
    In special offer 1, you can pay $5 for 3A and 0B
    In special offer 2, you can pay $10 for 1A and 2B.
    You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.

    Input: price = [2,3,4], special = [[1,1,0,4],[2,2,1,9]], needs = [1,2,1]    Output: 11

    The price of A is $2, and $3 for B, $4 for C.
    You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C.
    You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), and $3 for 1B, $4 for 1C.
    You cannot add more items, though only $9 for 2A ,2B and 1C.
     */


    // 529 ms, 9.92%
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shopping(price, special, needs, 0);
    }

    private int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos) {
        int minCost = directPurchase(price, needs);

        for (int i = pos; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            List<Integer> updatedNeeds = new ArrayList<>(needs);

            boolean isValidOffer = true;
            for (int j = 0; j < needs.size(); j++) {
                if (offer.get(j) > needs.get(j)) {
                    isValidOffer = false;
                    break;
                }
                updatedNeeds.set(j, needs.get(j) - offer.get(j));
            }

            if (isValidOffer) {
                minCost = Math.min(minCost, offer.get(offer.size() - 1) + shopping(price, special, updatedNeeds, i));
            }
        }

        return minCost;
    }

    private int directPurchase(List<Integer> price, List<Integer> needs) {
        int cost = 0;
        for (int i = 0; i < needs.size(); i++) {
            cost += price.get(i) * needs.get(i);
        }
        return cost;
    }


    public static void main(String[] args) {
        ShoppingOffers solution = new ShoppingOffers();

        // Test Case
        List<Integer> price = Arrays.asList(2, 5);
        List<List<Integer>> special = Arrays.asList(
                Arrays.asList(3, 0, 5),
                Arrays.asList(1, 2, 10)
        );
        List<Integer> needs = Arrays.asList(3, 2);
        System.out.println("Test Case 1: " + solution.shoppingOffers(price, special, needs)); // Output: 14
    }


}
