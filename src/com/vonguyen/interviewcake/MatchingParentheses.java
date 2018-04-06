package com.vonguyen.interviewcake;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://www.interviewcake.com/question/python/matching-parens
 *
 * I like parentheticals (a lot).
 * <p>
 * "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing."
 * <p>
 * Write a function that, given a sentence like the one above, along with the position of an opening parenthesis, finds
 * the corresponding closing parenthesis.
 * <p>
 * Example: if the example string above is input with the number 10 (position of the first parenthesis), the output
 * should be 79 (position of the last parenthesis).
 */
public class MatchingParentheses {

    public static String myFunction(String arg) {

        final Map<Integer, Integer> pair = new HashMap<>();
        final Stack<Integer> stack = new Stack<>();

        final char[] str = arg.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                stack.push(i);
            } else if (str[i] == ')') {
                final int k = stack.pop();
                pair.put(k, i);
            }
        }

        final int inp = 10;
        System.out.println(String.format("%d -> %d", inp, pair.get(inp)));
        return "running with " + arg;
    }

    public static void main(String[] args) {
        // run your function through some test cases here
        // remember: debugging is half the battle!
        String testInput = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
        System.out.println(myFunction(testInput));
    }
}
