package com.sjia.Leetcode;

import java.util.Scanner;

public class FractionAddition {
    // #592. Fraction Addition and Subtraction  https://leetcode.com/problems/fraction-addition-and-subtraction/description/
    /*
    Input: expression = "-1/2+1/2"  Output: "0/1"
    Input: expression = "-1/2+1/2+1/3"  Output: "1/3"
    Input: expression = "1/3-1/2"   Output: "-1/6"
     */

    // Scanner(expression).useDelimiter("/|(?=[-+])")
    public String fractionAddition(String expression) {
        Scanner sc = new Scanner(expression).useDelimiter("/|(?=[-+])");
        int A = 0, B = 1;
        while (sc.hasNext()) {
            int a = sc.nextInt(), b = sc.nextInt();
            A = A * b + a * B;
            B *= b;
            int g = gcd(A, B);
            A /= g;
            B /= g;
        }
        return A + "/" + B;
    }

    private int gcd(int a, int b) {
        return a != 0 ? gcd(b % a, a) : Math.abs(b);
    }


    public String fractionAddition_comment(String expression) {
        Scanner sc = new Scanner(expression).useDelimiter("/|(?=[+-])");
        int A = 0;
        int B = 1;

        // Init: A / B = 0 / 1
        // A / B + a / b = (Ab + aB) / Bb
        // So, in each round, set A = Ab + aB, B = Bb.
        while (sc.hasNext()) {
            final int a = sc.nextInt();
            final int b = sc.nextInt();
            A = A * b + a * B;
            B *= b;
            final int g = gcd(A, B);
            A /= g;
            B /= g;
        }

        return A + "/" + B;
    }



}
