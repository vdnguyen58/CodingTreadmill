package com.vonguyen.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and
 * it returns a short URL such as http://tinyurl.com/4e9iAk.
 *
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode
 * algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be
 * decoded to the original URL.
 *
 */
public class EncodeDecodeTinyURL {
    private static String httpStr = "http://tinyurl.com/";
    private static Map<String, String> storedTinied = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public static String encode(String longUrl) {
        String encodedToken = Long.toString(longUrl.hashCode() & 0xFFFFFFFFL);
        storedTinied.put(encodedToken, longUrl);
        return httpStr + encodedToken;
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        return storedTinied.get(shortUrl.replace(httpStr,""));
    }

    public static void main(String[] args) {
        String input = "https://leetcode.com/problems/design-tinyurl";
        String output = encode(input);
        String decoded = decode(output);
        System.out.println("Original String: " + input);
        System.out.println("Encoded: " + output);
        System.out.println("Decoded: " + decoded);
        System.out.println(input.equals(decoded) ? "Matched" : "Not matched");
    }
}
