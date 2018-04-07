package com.vonguyen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/fizz-buzz/description/
 *
 * Write a program that outputs the string representation of numbers from 1 to n.
 *
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 */

public class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList();
        for (int i=1; i<=n; i++) {
            String addTo;
            if (i%15==0) {
                addTo = "FizzBuzz";
            }
            else if (i%3==0) {
                addTo = "Fizz";
            }
            else if (i%5==0) {
                addTo = "Buzz";
            }
            else {
                addTo = Integer.toString(i);
            }
            result.add(addTo);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 15;
        fizzBuzz(n).stream().forEach(System.out::println);
    }
}
