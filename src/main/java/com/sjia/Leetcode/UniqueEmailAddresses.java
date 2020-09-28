package com.sjia.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    // #929 https://leetcode.com/problems/unique-email-addresses/
    // in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
    // "alice.z@leetcode.com" and "alicez@leetcode.com"
    // m.y+name@email.com will be forwarded to my@email.com


    // Runtime: 16 ms, faster than 65.43% of Java online submissions for Unique Email Addresses.
    //Memory Usage: 39.4 MB, less than 90.19% of Java online submissions for Unique Email Addresses.

    public int numUniqueEmails(String[] emails) {
        Set<String> res = new HashSet<>();
        for (String email: emails) {
            String[] tmp = email.split("@");
            String[] withDot = tmp[0].split("\\+");
            String localName = withDot[0].replace(".", "");
            res.add(localName + "@" + tmp[1]);   // tmp[1]: domain name
        }
        return res.size();
    }


}
