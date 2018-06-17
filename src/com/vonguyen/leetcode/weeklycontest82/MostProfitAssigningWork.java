package com.vonguyen.leetcode.weeklycontest82;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int m = profit.length;

        TreeMap<Integer, List<Integer>> dp = new TreeMap<>();
        for (int i=0; i<m; i++) {
            List<Integer> currItem = dp.get(difficulty[i]);
            if (currItem == null || currItem.get(0) < profit[i]) {
                List<Integer> item = Arrays.asList(profit[i], 0);
                dp.put(difficulty[i], item);
            }
        }

        int max = 0;
        for (Map.Entry<Integer, List<Integer>> entry : dp.entrySet()) {
            List<Integer> value = entry.getValue();
            if (value.get(0) > max) {
                max = value.get(0);
            }
            value.set(1, max);
        }

        int count = 0;
        for (int workerCapacity : worker) {
            Map.Entry<Integer, List<Integer>> item = dp.floorEntry(workerCapacity);
            if (item == null)
                continue;
            count += item.getValue().get(1);
        }

        return count;
    }

    public static void main(String[] args) {
        MostProfitAssigningWork app = new MostProfitAssigningWork();
        int[] difficulty = {66,1,28,73,53,35,45,60,100,44,59,94,27,88,7,18,83,18,72,63};
        int[] profit = {66,20,84,81,56,40,37,82,53,45,43,96,67,27,12,54,98,19,47,77};
        int[] worker = {61,33,68,38,63,45,1,10,53,23,66,70,14,51,94,18,28,78,100,16};
        System.out.println(app.maxProfitAssignment(difficulty, profit, worker));
    }
}
