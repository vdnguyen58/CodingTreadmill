package com.vonguyen.leetcode.weeklycontest83;

public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int N) {
        int count = 0;
        for (int b=1; b<=2*Math.sqrt(N); b++) {
            if (2*N % (b+1) != 0) {
                continue;
            }
            if (((2*N)/(b+1)-b) <= 0) {
                continue;
            }
            if (((2*N)/(b+1)-b) % 2 != 0) {
                continue;
            }
            //System.out.println((((2*N)/(b+1)-b))/2 + " " + (b+1));
            count++;
        }
        return count+1;
    }

    public static void main(String[] args) {
        ConsecutiveNumbersSum app = new ConsecutiveNumbersSum();
        System.out.println(app.consecutiveNumbersSum(1000000000));
    }
}
