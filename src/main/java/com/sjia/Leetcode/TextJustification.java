package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    //  #68. Text Justification  https://leetcode.com/problems/text-justification/
    /*
    Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
    Output:
    [
       "This    is    an",
       "example  of text",
       "justification.  "
    ]
     */


    public static List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        int word = 0;

        while(word<words.length){

            int j = word-1;
            int characters = 0;


            while(j+1<words.length && characters+words[j+1].length() + j+1-word<=maxWidth)
            {
                j++;
                characters+=words[j].length();
            }
            result.add(line(words , word , j, characters , maxWidth));
            word = j+1;
        }
        return result;
    }

    public static String line(String words[],int start,int end, int Linelen,int max)
    {
        StringBuilder a = new StringBuilder();
        int p=1,q=0;
        if(end!=start)
        {
            p=(max-Linelen)/(end-start);
            q=(max-Linelen)%(end-start);
        }

        for(int i=start;i<=end;i++)
        {
            a.append(words[i]);
            if(i!=end)
            {
                if(end==words.length-1) a.append(" ");
                else {
                    for(int j=1;j<=p;j++) a.append(" ");
                    if(q-->=1) a.append(" ");
                }
            }
        }
        while(a.length()<max) a.append(" ");
        return a.toString();
    }





    //  Need follow up, failed test case 2
    public static List<String> fullJustify2(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int start = 0; // Start index of the current line

        while (start < n) {
            int end = findEndIndex(words, start, maxWidth); // End index of the current line
            int charCount = countCharacters(words, start, end); // Total character count of the words in the current line
            int wordCount = end - start + 1; // Number of words in the current line

            // Calculate the number of spaces to be inserted between words
            int spaces = maxWidth - charCount;
            int spacesBetweenWords = wordCount > 1 ? spaces / (wordCount - 1) : spaces;
            int extraSpaces = wordCount > 1 ? spaces % (wordCount - 1) : spaces;

            StringBuilder sb = new StringBuilder();
            for (int i = start; i <= end; i++) {
                sb.append(words[i]);

                // Insert spaces between words
                if (i < end) {
                    for (int j = 0; j < spacesBetweenWords; j++) {
                        sb.append(" ");
                    }

                    // Distribute any extra spaces evenly
                    if (extraSpaces > 0) {
                        sb.append(" ");
                        extraSpaces--;
                    }
                }
            }

            // Append any remaining spaces to the right for the last line
            int remainingSpaces = maxWidth - sb.length();
            for (int i = 0; i < remainingSpaces; i++) {
                sb.append(" ");
            }

            result.add(sb.toString());
            start = end + 1;
        }

        return result;
    }

    // Find the end index of the current line
    private static int findEndIndex(String[] words, int start, int maxWidth) {
        int end = start;
        int lineLength = words[end].length();

        while (end + 1 < words.length && lineLength + words[end + 1].length() + 1 <= maxWidth) {
            end++;
            lineLength += words[end].length() + 1;
        }

        return end;
    }

    // Count the total number of characters in the words from start to end indices
    private static int countCharacters(String[] words, int start, int end) {
        int count = 0;

        for (int i = start; i <= end; i++) {
            count += words[i].length();
        }

        return count;
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;

        List<String> result = fullJustify(words, maxWidth);
        for (String line : result) {
            System.out.println(line);
        }
    }






}
