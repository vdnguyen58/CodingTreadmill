package com.vonguyen.leetcode.medium;

public class MaxIncreaseKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] maxOfRow = new int[m];
        int[] maxOfColumn = new int[n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] > maxOfRow[i])
                    maxOfRow[i] = grid[i][j];
                if (grid[i][j] > maxOfColumn[j])
                    maxOfColumn[j] = grid[i][j];
            }
        }

        int result = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                result += Integer.min(maxOfRow[i],maxOfColumn[j]) - grid[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        MaxIncreaseKeepCitySkyline app = new MaxIncreaseKeepCitySkyline();
        System.out.println(app.maxIncreaseKeepingSkyline(grid));
    }
}
