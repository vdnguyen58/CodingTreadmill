package com.vonguyen.leetcode;

/**
 * https://leetcode.com/problems/license-key-formatting/description/
 * You are given a license key represented as a string S which consists only alphanumeric character and dashes.
 * The string is separated into N+1 groups by N dashes.
 *
 * Given a number K, we would want to reformat the strings such that each group contains exactly K characters,
 * except for the first group which could be shorter than K, but still must contain at least one character.
 * Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted
 * to uppercase.
 *
 * Given a non-empty string S and a number K, format the string according to the rules described above.
 */

public class LicenseKeyFormatting {

    private static String az = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890";

    private static String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        char[] sArr = S.toCharArray();
        int count = 0;
        String result = "";
        for (int i=S.length()-1; i>=0; i--) {
            if (az.indexOf(sArr[i]) >= 0) {
                result = sArr[i] + result;
                count++;
            }
            if (count == K) {
                result = "-" + result;
                count = 0;
            }
        }
        if (result.length() == 0) {
            return "";
        }
        if (result.charAt(0) == '-') {
            result = result.substring(1, result.length());
        }
        return result;
    }

    public static void main(String[] args) {
        String S = "5F3Z-2e-9-w";
        int K = 4;
        System.out.println(licenseKeyFormatting(S,K));
    }
}
