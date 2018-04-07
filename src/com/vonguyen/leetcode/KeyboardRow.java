package com.vonguyen.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/keyboard-row/description/
 *
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American
 * keyboard like the image below.
 */
public class KeyboardRow {
    public static String[] findWords(String[] words) {
        List<String> resultList = new ArrayList();
        for (String word : words) {
            if (sameRow(word)) {
                resultList.add(word);
            }
        }

        String[] resultArray = new String[resultList.size()];
        resultArray = resultList.toArray(resultArray);
        return resultArray;
    }

    private static Boolean sameRow(String word) {
        Integer r = getRow(word.charAt(0));
        for (int i = 1; i<word.length(); i++) {
            if (getRow(word.charAt(i)) != r) {
                return false;
            }
        }
        return true;
    }

    private static Integer getRow(char x) {
        if ("qwertyuiopQWERTYUIOP".indexOf(x) >= 0) {
            return 1;
        }
        if ("asdfghjklASDFGHJKL".indexOf(x) >= 0) {
            return 2;
        }
        if ("zxcvbnmZXCVBNM".indexOf(x) >= 0) {
            return 3;
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] input = {"Hello", "Alaska", "Dad", "Peace"};
        Arrays.stream(findWords(input)).forEach(System.out::println);
    }
}
