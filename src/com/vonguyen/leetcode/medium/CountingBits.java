package com.vonguyen.leetcode.medium;

import java.util.Arrays;

public class CountingBits {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        ret[0] = 0;
        if (num == 0) {
            return ret;
        }
        ret[1] = 1;
        if (num == 1) {
            return ret;
        }
        for (int i=2; i<=num; i++) {
            ret[i] = ret[i>>1] + (i&1);
        }

        return ret;
    }

    public static void main(String[] args) {
        CountingBits app = new CountingBits();
        System.out.println(Arrays.toString(app.countBits(5)));
    }
}
