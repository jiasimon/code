package com.sjia;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RansomNote {

    //python   from collections import Counter
    //
    //def ransom_note(magazine, rasom):
    //    return (Counter(rasom) - Counter(magazine)) == {}


    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Hashtable<String, Integer > magazineTable = new Hashtable<String, Integer >();

        for(String s: magazine) {
            if(magazineTable.containsKey(s)) {
                magazineTable.put(s, magazineTable.get(s) + 1);
            } else {
                magazineTable.put(s, 1);
            }
        }

        for(String s: note) {
            if (!magazineTable.containsKey(s)) {
                System.out.println("No");
                return;
            }
            int  flag = magazineTable.get(s) - 1;
            if (flag == 0) {
                magazineTable.remove(s);
            } else {
                magazineTable.put(s, flag);
            }
        }

        System.out.println("Yes");




    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
