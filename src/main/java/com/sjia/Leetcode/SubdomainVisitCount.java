package com.sjia.Leetcode;

import java.util.*;

public class SubdomainVisitCount {
    // #811 https://leetcode.com/problems/subdomain-visit-count/

    // Example 1:
    // Input:
    // ["9001 discuss.leetcode.com"]
    // Output:
    // ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]

/*
    Example 2:
    Input:
            ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
    Output:
            ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
*/


    // The length of cpdomains will not exceed 100.
    // The length of each domain name will not exceed 100.
    // Each address will have either 1 or 2 "." characters.
    // The input count in any count-paired domain will not exceed 10000.
    // The answer output can be returned in any order.


    // Runtime: 38 ms, faster than 9.39% of Java online submissions for Subdomain Visit Count.
    // Memory Usage: 41.5 MB, less than 17.56% of Java online submissions for Subdomain Visit Count.
        public List<String> subdomainVisits(String[] cpdomains) {
            Map<String, Integer> counts = new HashMap();
            for (String domain: cpdomains) {
                String[] cpinfo = domain.split("\\s+");
                String[] parts = cpinfo[1].split("\\.");
                int count = Integer.valueOf(cpinfo[0]);
                String cur = "";
                for (int i = parts.length - 1; i >= 0; --i) {
                    cur = parts[i] + (i < parts.length - 1 ? "." : "") + cur;
                    counts.put(cur, counts.getOrDefault(cur, 0) + count);
                }
            }

            List<String> res = new ArrayList();
            for (String dom: counts.keySet())
                res.add("" + counts.get(dom) + " " + dom);
            return res;
        }




}
