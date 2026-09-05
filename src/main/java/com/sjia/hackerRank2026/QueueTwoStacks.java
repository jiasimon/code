package com.sjia.hackerRank2026;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class QueueTwoStacks {
    // https://www.hackerrank.com/challenges/queue-using-two-stacks/problem

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Stack<Integer> stackIn = new Stack<>();
        Stack<Integer> stackOut = new Stack<>();

        Scanner sc = new Scanner(System.in);
        int q = Integer.parseInt(sc.nextLine().trim());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int value = Integer.parseInt(st.nextToken());
                stackIn.push(value);
            } else if (type == 2) {
                shift(stackIn, stackOut);
                stackOut.pop();
            } else {
                shift(stackIn, stackOut);
                sb.append(stackOut.peek()).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static void shift(Stack<Integer> stackIn, Stack<Integer> stackOut) {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }
}
