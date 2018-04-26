package com.vonguyen.leetcode.easy;

/**
 * https://leetcode.com/problems/reverse-string/description/
 *
 * Write a function that takes a string as input and returns the string reversed.
 *
 */
public class ReverseString {
    public static String reverseString(String s) {
        char[] charArr = s.toCharArray();
        int l = s.length();
        for (int i=0; i<l/2; i++) {
            int j = l-i-1;
            char temp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = temp;
        }
        return String.copyValueOf(charArr);
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseString(s));
    }
}
