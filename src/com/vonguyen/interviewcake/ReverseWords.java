package com.vonguyen.interviewcake;

/**
 * https://www.interviewcake.com/question/java/reverse-words
 * 
 * You're working on a secret team solving coded transmissions.
 * <p>
 * Your team is scrambling to decipher a recent message, worried it's a plot to break into a major European National
 * Cake Vault. The message has been mostly deciphered, but all the words are backwards! Your colleagues have handed off
 * the last step to you.
 * <p>
 * Write a method reverseWords() that takes a message as an array of characters and reverses the order of the words
 * in-place.
 * <p>
 * Why an array of characters instead of a string?
 * <p>
 * The goal of this question is to practice manipulating strings in place. Since we're modifying the message, we need a
 * mutable ↴ type like an array, instead of Java's immutable strings.
 * <p>
 * For example:
 * <p>
 * char[] message = { 'c', 'a', 'k', 'e', ' ',
 * 'p', 'o', 'u', 'n', 'd', ' ',
 * 's', 't', 'e', 'a', 'l' };
 * <p>
 * reverseWords(message);
 * <p>
 * System.out.println(message);
 * // prints: "steal pound cake"
 * <p>
 * When writing your method, assume the message contains only letters and spaces, and all words are separated by one space.
 */

public class ReverseWords {
    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    private static void swapSequence(char[] str, int i, int j) {
        while (i < j) {
            swap(str, i++, j--);
        }
    }

    public static String myFunction(String arg) {
        // write the body of your function here
        char[] str = arg.toCharArray();

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
        System.out.println(str);

        return "running with " + arg;
    }

    public static void main(String[] args) {
        // run your function through some test cases here
        // remember: debugging is half the battle!
        String testInput = "test input";
        System.out.println(myFunction(testInput));
    }
}
