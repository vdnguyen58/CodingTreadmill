package com.vonguyen.leetcode.easy;

/**
 * https://leetcode.com/problems/island-perimeter/description/
 *
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid
 * cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there
 * is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that
 * isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular,
 * width and height don't exceed 100. Determine the perimeter of the island.
 *
 */
public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int p = 0;
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                if (grid[i][j] == 1) {
                    if (topWater(grid,i,j,m,n))
                        p++;
                    if (bottomWater(grid,i,j,m,n))
                        p++;
                    if (leftWater(grid,i,j,m,n))
                        p++;
                    if (rightWater(grid,i,j,m,n))
                        p++;
                }
        return p;
    }

    private static boolean topWater(int[][]g, int i, int j, int m, int n) {
        //top of the map
        if (i == 0) {
            return true;
        }
        return (g[i-1][j] == 0);
    }

    private static boolean bottomWater(int[][]g, int i, int j, int m, int n) {
        if (i == m-1) {
            return true;
        }
        return (g[i+1][j] == 0);
    }

    private static boolean leftWater(int [][]g, int i, int j, int m, int n) {
        if (j == 0) {
            return true;
        }
        return (g[i][j-1] == 0);
    }

    private static boolean rightWater(int [][]g, int i, int j, int m, int n) {
        if (j == n-1) {
            return true;
        }
        return (g[i][j+1] == 0);
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }
}
