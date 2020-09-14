package com.sjia;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class SubStringSolution {

    public static void main(String[] args) {
	// write your code here
/*        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();

        if (start > end) {
            System.out.println("Start number should be smaller than  End number.");
        }

        try {
            System.out.println(S.substring(start, end));
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("Change End number to greater than Start number");
        }*/


/*    // getSmallestAndLargest Main
        Scanner scan=new Scanner(System.in);
        String str=scan.next();
        int k=scan.nextInt();
        scan.close();

        System.out.println("Results are: ");
        System.out.println( SubStringSolution.getSmallestAndLargest(str, k) ); */



        // palindrome
        //Scanner scanner = new Scanner(System.in);
        //String input = scanner.next()
/*        String input = "a1A";
        System.out.println(input.equals(new StringBuilder(input).reverse().toString()) ? "Yes" : "No");
        System.out.println("Do not consider Case: " + ( input.equalsIgnoreCase(new StringBuilder(input).reverse().toString())
                ? "Yes" : "No"));*/
        // trailing spaces were not counted/considered

//        Scanner sc=new Scanner(System.in);
//        String A=sc.next();
//        System.out.println( A.equals( new StringBuilder(A).reverse().toString())
//                ? "Yes" : "No" );



/*
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();

        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) > 0 ? "Yes":"No");
        System.out.println(A.substring(0, 1).toUpperCase()+A.substring(1, A.length())+" "+B.substring(0, 1).toUpperCase()+B.substring(1, B.length()));
*/


/*        String a = "asaab";
        String b = "asaba";
        System.out.println("a and b isAnagram: " + isAnagram(a,b) );
        System.out.println("a and b isAnagram: " + isAnagramNew(a,b) );*/


        // String Token
/*        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] items = s.trim().split("[ !,?.\\_'@]+");

        if (s == null || s.equals("") || s.trim().equals("")){
            System.out.println("0");

        }
        else if(s.length() > 400000){
            return;
        }
        else{
            System.out.println(items.length);
        }

        for(String item: items){
            System.out.println(item);
        }
        scan.close();*/


/*        // regex Pattern
        Scanner in = new Scanner(System.in);
        //int testCase = in.nextInt();

        int testCases = Integer.parseInt(in.nextLine().trim());
        //int testCase = Integer.parseInt(in.nextLine());

        while(testCases > 0){
            String pattern = in.nextLine();
            try {
                Pattern.compile(pattern);
                System.out.println("Valid");
            } catch (PatternSyntaxException e) {
                System.out.println("Invalid");
            }
            testCases--;
        }*/

        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();

         //BigInteger input = new BigInteger(n);
        System.out.println(new BigInteger(n).isProbablePrime(100) ? "prime" : "not prime");

//        System.out.println(scanner.nextBigInteger().isProbablePrime(100) ? "prime" : "not prime");
//        System.out.println(scanner.nextBigInteger().isProbablePrime(10) ? "prime" : "not prime");


        // usernameRegex
        // The username consists of 8 to 30 characters inclusive.
        // username can only contain alphanumeric characters and underscores
        // first character of the username must be an alphabetic character

        String regularExpression = "^[a-zA-Z]\\w{7,29}$";

        String regexUserName =  "^[a-zA-Z][a-zA-Z0-9_]{7,29}$" ;








    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        if (s.isEmpty()){
            System.out.println("Input String is Empty");
        } else if (k > s.length()) {
            System.out.println("Substring length K is longer than original string");
        }


/*        SortedSet<String> sortedSet = new TreeSet<String>();

        for (int i=0; i <= s.length()-k; i++) {
            sortedSet.add(s.substring(i, i+k));
        }
        smallest = sortedSet.first();
        largest = sortedSet.last();*/
        List<String> mylist = new ArrayList<String> ();
        for (int i=0; i <= s.length()-k; i++) {
            mylist.add(s.substring(i, i+k));
        }

        Collections.sort(mylist);
        //mylist.sort(null);

        smallest = mylist.get(0);
        largest = mylist.get(mylist.size() - 1);




        return smallest + "\n" + largest;
    }


    static boolean isAnagramSimple(String a, String b) {
        char a1[] = a.toLowerCase().toCharArray();
        char b1[] = b.toLowerCase().toCharArray();
        Arrays.sort(a1);
        Arrays.sort(b1);

        return Arrays.equals(a1, b1);
    }

    static boolean isAnagramNew(String a, String b) {
        if(a.length() != b.length()) return false;
        int c[] = new int[26], d[] = new int[26] ;
        a = a.toUpperCase();
        b = b.toUpperCase();
        for(int i= 0; i < a.length(); i++){
            c[a.charAt(i) - 'A']++;
            d[b.charAt(i) - 'A']++;
        }
        for(int i = 0; i < 26; i++)
            if(c[i] != d[i] ) return false;
        return true;
    }


    // Anagrams  CAT: CAT, ACT, TAC, TCA, ATC, and CTA
    static boolean isAnagram(String a, String b) {
        // Complete the function
        // test for invalid input
        if( a == null || b == null || a.equals("") || b.equals("") )
            throw new IllegalArgumentException();

        // initial quick test for non-anagrams
        if ( a.length() != b.length() )
            return false;

        a = a.toLowerCase();
        b = b.toLowerCase();

        Map<Character, Integer> map = new HashMap<>();

        for (int k = 0; k < b.length(); k++){
            char letter = b.charAt(k);

            if( ! map.containsKey(letter)){
                map.put( letter, 1 );
            } else {
                Integer frequency = map.get( letter );
                map.put( letter, ++frequency );
            }
        }



        for (int k = 0; k < a.length(); k++){
            char letter = a.charAt(k);

            if( ! map.containsKey( letter ) )
                return false;

            Integer frequency = map.get( letter );

            if( frequency == 0 )
                return false;
            else
                map.put( letter, --frequency);
        }
        // if the code got that far it is an anagram
        return true;
    }

}
