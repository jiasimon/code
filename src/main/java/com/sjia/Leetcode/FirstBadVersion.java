package com.sjia.Leetcode;

public class FirstBadVersion {

    // #278 https://leetcode.com/problems/first-bad-version/
    //

    // Runtime: 12 ms, faster than 99.38% of Java online submissions for First Bad Version.
    //Memory Usage: 36.4 MB, less than 8.03% of Java online submissions for First Bad Version.
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right -left)/2;
            if (isBadVersion(mid)) {
                right =mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    private boolean isBadVersion(int mid) {
        return mid >20;
    }


}
