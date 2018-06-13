package com.vonguyen.leetcode.weeklycontest83;

import java.util.Arrays;

public class UniqueLetterString {
    public int uniqueLetterString(String S) {
        int n = S.length();
        if (n == 0)
            return 0;
        char[] ch = S.toCharArray();
        int[] cur = new int[n];
        int[] contrib = new int[256];
        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);
        cur[0] = 1;
        int result = 1;
        contrib[ch[0]] = 1;
        lastIndex[ch[0]] = 0;
        for (int i=1; i<n; i++) {
            char c = ch[i];
            cur[i] = cur[i-1] - contrib[c] + (i - lastIndex[c]);
            contrib[c] = i - lastIndex[c];
            lastIndex[c] = i;
            result+= cur[i];
        }
        return result;
    }

    public static void main(String[] args) {
        UniqueLetterString app = new UniqueLetterString();
        System.out.println(app.uniqueLetterString("ABC"));
    }
}
