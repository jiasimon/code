package com.sjia.Leetcode;

public class FindTownJudge {
    // #997 https://leetcode.com/problems/find-the-town-judge/
    // The town judge trusts nobody.
    // Everybody (except for the town judge) trusts the town judge.
    // There is exactly one person that satisfies properties 1 and 2.

    // 1 <= N <= 1000
    // 0 <= trust.length <= 10^4
    // trust[i].length == 2
    // trust[i] are all different
    // trust[i][0] != trust[i][1]
    // 1 <= trust[i][0], trust[i][1] <= N


    //
    // Runtime: 2 ms, faster than 99.90% of Java online submissions for Find the Town Judge.
    // Memory Usage: 46.6 MB, less than 94.97% of Java online submissions for Find the Town Judge.
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
        for (int[] i : trust) {
            count[i[0]]--;
            count[i[1]]++;
        }
        for ( int j=1; j <= N; j++ ) {
            if(count[j] == N-1) return j;
        }
        return -1;

    }


}
