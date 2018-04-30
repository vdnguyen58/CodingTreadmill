package com.vonguyen.leetcode.medium;

public class ReverseWordsInAString {
    private void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    private void swapSequence(char[] str, int i, int j) {
        while (i < j) {
            swap(str, i++, j--);
        }
    }

    private String trimString(String str) {
        String[] temp = str.trim().split("\\s+");
        StringBuilder strBuilder = new StringBuilder("");
        for (String item : temp) {
            strBuilder.append(item.trim());
            strBuilder.append(" ");
        }
        return strBuilder.toString().trim();
    }

    public String reverseWords(String arg) {
        char[] str = trimString(arg).toCharArray();
        swapSequence(str, 0, str.length - 1);

        int i = 0;
        int j = 0;
        while (j < str.length) {
            if (str[j] == ' ') {
                swapSequence(str, i, j - 1);
                i = j + 1;
                j = i;
            } else {
                ++j;
            }
        }
        swapSequence(str, i, str.length - 1);
        return String.copyValueOf(str);
    }

    public static void main(String[] args) {
        ReverseWordsInAString app = new ReverseWordsInAString();
        System.out.println(app.reverseWords("   the   sky is blue"));
    }
}
