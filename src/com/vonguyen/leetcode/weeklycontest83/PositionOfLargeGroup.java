package com.vonguyen.leetcode.weeklycontest83;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionOfLargeGroup {
    public List<List<Integer>> largeGroupPositions(String S) {
        char[] tmp = S.toCharArray();
        int l = tmp.length;
        int lastPos = 0;
        List<List<Integer>> ret = new ArrayList<>();
        for (int i=1; i<l; i++) {
            if (tmp[i] != tmp[i-1]) {
                if (i - lastPos >= 3) {
                    ret.add(Arrays.asList(lastPos, i - 1));
                }
                lastPos = i;
            }
        }

        if (l - lastPos >= 3 && tmp[l-1] == tmp[lastPos]) {
            ret.add(Arrays.asList(lastPos, l - 1));
        }

        return ret;
    }

    public static void main(String[] args) {
        PositionOfLargeGroup app = new PositionOfLargeGroup();
        System.out.println(app.largeGroupPositions("abcdddeeeeaabbb"));
    }
}
