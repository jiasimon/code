package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.Collections;

public class PartitionArrayThreeEqual {
    // #1013  https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
    // 3 <= A.length <= 50000
    // -10^4 <= A[i] <= 10^4


    // use stream
    // Runtime: 4 ms, faster than 26.37% of Java online submissions for Partition Array Into Three Parts With Equal Sum.
    //Memory Usage: 46.6 MB, less than 10.13% of Java online submissions for Partition Array Into Three Parts With Equal Sum.
/*    public boolean canThreePartsEqualSum(int[] A) {
        int sum = Arrays.stream(A).sum();
        int group=0, average = sum/3, count=0;
        for (int a : A){
            group +=a;
            if(group == average) {
                count++;
                group=0;
                if (count==2 && group !=0) return true; // if (count==2) failed on [1,-1,1,-1]
            }
        }
        return count>=3 && sum%3 ==0;
    }*/


    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Partition Array Into Three Parts With Equal Sum.
    // Memory Usage: 46.3 MB, less than 10.13% of Java online submissions for Partition Array Into Three Parts With Equal Sum.
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int a : A) sum +=a;
        int group=0, average = sum/3, count=0;
        for (int a : A){
            group +=a;
            if(group == average) {
                count++;
                group=0;
                // if (count==2 && group !=0) return true; // if (count==2) failed on [1,-1,1,-1]
            }
        }
        return count>=3 && sum%3 ==0;
    }

}
