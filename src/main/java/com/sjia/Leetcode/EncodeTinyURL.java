package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class EncodeTinyURL {
    // #535. Encode and Decode TinyURL  https://leetcode.com/problems/encode-and-decode-tinyurl/description/

    /*
    Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.

There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

    Input: url = "https://leetcode.com/problems/design-tinyurl"
    Output: "https://leetcode.com/problems/design-tinyurl"

    Explanation:
    Solution obj = new Solution();
    string tiny = obj.encode(url); // returns the encoded tiny url.
    string ans = obj.decode(tiny); // returns the original url after decoding
     */


    private static final String BASE_HOST = "http://tinyurl.com/";
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int ENCODE_LENGTH = 6;

    private Map<String, String> urlToCodeMap;
    private Map<String, String> codeToUrlMap;

    public EncodeTinyURL() {
        urlToCodeMap = new HashMap<>();
        codeToUrlMap = new HashMap<>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (urlToCodeMap.containsKey(longUrl)) {
            return urlToCodeMap.get(longUrl);
        }

        String code;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ENCODE_LENGTH; i++) {
                int index = (int) (Math.random() * CHARACTERS.length());
                sb.append(CHARACTERS.charAt(index));
            }
            code = sb.toString();
        } while (codeToUrlMap.containsKey(code));

        String shortUrl = BASE_HOST + code;
        urlToCodeMap.put(longUrl, shortUrl);
        codeToUrlMap.put(shortUrl, longUrl);

        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return codeToUrlMap.getOrDefault(shortUrl, "");
    }

    public static void main(String[] args) {
        EncodeTinyURL codec = new EncodeTinyURL();

        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        String shortUrl = codec.encode(longUrl);
        System.out.println("Encoded URL: " + shortUrl);

        String decodedUrl = codec.decode(shortUrl);
        System.out.println("Decoded URL: " + decodedUrl);
    }



}
