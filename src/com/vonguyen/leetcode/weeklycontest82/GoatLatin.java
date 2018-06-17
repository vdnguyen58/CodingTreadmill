package com.vonguyen.leetcode.weeklycontest82;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GoatLatin {
    public String toGoatLatin(String S) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        String aSuffix = "a";
        List<String> words = Arrays.asList(S.split(" "));
        for (int i=0; i<words.size(); i++) {
            String word = words.get(i);
            if (vowels.contains(word.charAt(0))) {
                word = word + "ma";
            } else {
                word = word.substring(1) + word.charAt(0) + "ma";
            }
            word = word + aSuffix;
            aSuffix = aSuffix + "a";
            words.set(i, word);
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        GoatLatin app = new GoatLatin();
        System.out.println(app.toGoatLatin("I speak Goat Latin").equals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa"));
        System.out.println(app.toGoatLatin("The quick brown fox jumped over the lazy dog").equals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"));
    }
}
