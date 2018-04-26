package com.vonguyen.leetcode.medium;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int len = s.length();
        char[] ch = s.toCharArray();
        boolean[][] w = new boolean[len][len];
        int maxLength = 0;
        String result = null;

        for (int l=0; l<len; l++) {
            for (int i=0; i<len-l; i++) {
                int j=i+l;
                if (ch[i]==ch[j] && (j-i<=2 || w[i+1][j-1])) {
                    w[i][j] = true;
                    if (maxLength < j-i+1) {
                        maxLength = j-i+1;
                        result = s.substring(i,j+1);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring app = new LongestPalindromicSubstring();
        System.out.println(app.longestPalindrome("abcda"));
    }
}
