package com.vonguyen.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class CombinationSum {

    private void buildPath(int s, int[][] trace, Deque<Integer> outputList, List<List<Integer>> ret) {
        if (s == 0) {
            ret.add(Arrays.asList(outputList.toArray(new Integer[0])));
            return;
        }
        for (int i=0; i<trace[0].length; i++) {
            if (trace[s][i] != 0 && (outputList.isEmpty() || outputList.peekLast() <= trace[s][i])) {
                outputList.addLast(trace[s][i]);
                buildPath(s - trace[s][i], trace, outputList, ret);
                outputList.removeLast();
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        boolean[] w = new boolean[target+1];
        int[][] trace = new int[target+1][candidates.length];
        w[0] = true;
        for (int k=0; k<=target; k++) {
            for (int j=0; j<candidates.length; j++) {
                if (k-candidates[j] >= 0 && w[k-candidates[j]]) {
                    w[k] = true;
                    trace[k][j] = candidates[j];
                }
            }
        }

        Deque<Integer> outputList = new ArrayDeque<>();
        List<List<Integer>> ret = new ArrayList<>();
        buildPath(target, trace, outputList, ret);

        return ret;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        CombinationSum app = new CombinationSum();
        System.out.println(app.combinationSum(candidates, target));
    }
}
