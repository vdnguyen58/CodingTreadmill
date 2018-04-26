package com.vonguyen.leetcode.medium;

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int len = s.length();
        char[] ch = s.toCharArray();
        int[][] w = new int[len][len];
        int maxLength = 0;
        String result = null;

        for (int i=0; i<len; i++) {
            w[i][i] = 1;
        }

        for (int l=2; l<=len; l++) {
            for (int i=0; i<=len-l; i++) {
                int j = i+l-1;
                if (ch[i]==ch[j]) {
                    w[i][j] = w[i+1][j-1] + 2;
                } else {
                    w[i][j] = Integer.max(w[i+1][j],w[i][j-1]);
                }
            }
        }

        return w[0][len-1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence app = new LongestPalindromicSubsequence();
        System.out.println(app.longestPalindromeSubseq("cbbdadddbd"));
    }
}
