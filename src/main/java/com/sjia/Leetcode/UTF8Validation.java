package com.sjia.Leetcode;

public class UTF8Validation {
    // #393. UTF-8 Validation   https://leetcode.com/problems/utf-8-validation/description/
    /*
    A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:

    For a 1-byte character, the first bit is a 0, followed by its Unicode code.
    For an n-bytes character, the first n bits are all one's, the n + 1 bit is 0, followed by n - 1 bytes with the most significant 2 bits being 10.
    This is how the UTF-8 encoding would work:

         Number of Bytes   |        UTF-8 Octet Sequence
                           |              (binary)
       --------------------+-----------------------------------------
                1          |   0xxxxxxx
                2          |   110xxxxx 10xxxxxx
                3          |   1110xxxx 10xxxxxx 10xxxxxx
                4          |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx

        Input: data = [197,130,1]   Output: true
        Explanation: data represents the octet sequence: 11000101 10000010 00000001.

        Input: data = [235,140,4]   Output: false
        Explanation: data represented the octet sequence: 11101011 10001100 00000100.
        The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
     */


    // UTF最多连续4字节，即不能同时（11111xxx），不能>=248
    // revisit
    public boolean validUtf8(int[] data) {
        int index = 0;

        while (index < data.length) {
            int numBytes = getNumBytes(data[index]);
            if (numBytes == -1) {
                return false;
            }

            for (int i = 1; i < numBytes; i++) {
                if (index + i >= data.length || !isContinuation(data[index + i])) {
                    return false;
                }
            }

            index += numBytes;
        }

        return true;
    }

    private int getNumBytes(int num) {
        if ((num >> 7) == 0b0) {
            return 1;
        } else if ((num >> 5) == 0b110) {
            return 2;
        } else if ((num >> 4) == 0b1110) {
            return 3;
        } else if ((num >> 3) == 0b11110) {
            return 4;
        } else {
            return -1;
        }
    }

    private boolean isContinuation(int num) {
        return (num >> 6) == 0b10;
    }


    public static void main(String[] args) {
        UTF8Validation solution = new UTF8Validation();
        int[] data = {197, 130, 1};
        boolean isValidUtf8 = solution.validUtf8(data);
        System.out.println("Is valid UTF-8 encoding: " + isValidUtf8); // Output: true
    }


}
