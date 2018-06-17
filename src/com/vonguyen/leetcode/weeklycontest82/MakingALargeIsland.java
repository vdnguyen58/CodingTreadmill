package com.vonguyen.leetcode.weeklycontest82;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class MakingALargeIsland {

    int[] X = {-1, 0, 0, 1};
    int[] Y = {0, -1, 1, 0};
    int[][] domain;
    List<Integer> areaList = new ArrayList<>();
    int n;
    int m;
    int area;
    int domainCount;

    private boolean isInbound(int i, int j) {
        if (i < 0 || i >= m)
            return false;
        if (j < 0 || j >= n)
            return false;
        return true;
    }

    private boolean canMove(int[][] grid, int i1, int j1) {
        if (!isInbound(i1, j1))
            return false;
        if (grid[i1][j1] == 0)
            return false;
        if (domain[i1][j1] != 0)
            return false;
        return true;
    }

    private void explore(int[][] grid, int i, int j) {
        for (int k=0; k<4; k++) {
            int i1 = i + X[k];
            int j1 = j + Y[k];
            if (canMove(grid, i1, j1)) {
                domain[i1][j1] = domainCount;
                area += 1;
                explore(grid, i1, j1);
            }
        }
    }

    private int findMax(int i, int j) {
        int max = 0;
        Set<Integer> added = new HashSet<>();
        for (int k=0; k<4; k++) {
            int i1 = i+X[k];
            int j1 = j+Y[k];
            if (!isInbound(i1, j1) || domain[i1][j1] == 0 || added.contains(domain[i1][j1]))
                continue;
            max += areaList.get(domain[i1][j1]-1);
            added.add(domain[i1][j1]);
        }
        if (max > 0)
            return max+1;
        return max;
    }

    public int largestIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        domain = new int[m][n];
        domainCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && domain[i][j] == 0) {
                    area = 1;
                    domain[i][j] = ++domainCount;
                    explore(grid, i, j);
                    areaList.add(area);
                }
            }
        }

        if (domainCount == 0) {
            if (m == 0 && n==0)
                return 0;
            return 1;
        }
        if (domainCount == 1) {
            if (area == m*n)
                return area;
            return area+1;
        }

        int max = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    int tempMax = findMax(i, j);
                    max = (tempMax > max) ? tempMax : max;
                }
            }
        }

        if (max == 0) {
            for (int a : areaList) {
                max = (max > a) ? max : a;
            }
            max = max + 1;
        }
        return max;
    }

    public static void main(String[] args) {
        MakingALargeIsland app = new MakingALargeIsland();

        int maxM = 50;
        int maxN = 50;
        int[][] grid = new int[maxM][maxN];
        for (int i=0; i<maxM; i++) {
            if (i == 0)
                System.out.print("[");
            for (int j = 0; j < maxN; j++) {
                int val = ThreadLocalRandom.current().nextInt(0, 2);
                grid[i][j] = val;
                if (j == 0)
                    System.out.print("[");
                System.out.print(val);
                if (j < maxN - 1)
                    System.out.print(",");
                if (j == maxN - 1)
                    System.out.print("]");
            }
            if (i < maxM - 1)
                System.out.print(",");
            if (i == maxM - 1)
                System.out.print("]");
        }
        System.out.println();
        System.out.println(app.largestIsland(grid));
    }
}
