package com.vonguyen.leetcode.weeklycontest84;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlippingAnImage {

    class Commit {
        private String id;
        private String type;

        Commit(String id, String type) {
            this.id = id;
            this.type = type;
        }

        @Override
        public String toString() {
            return this.id + ": " + this.type;
        }
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] ret = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                ret[i][j] = (A[i][n-j-1] + 1) % 2;
            }
        }
        return ret;
    }

    public void test() {
        List<Commit> commitsList = new ArrayList<>();
        commitsList.add(new Commit("1", "a"));
        commitsList.add(new Commit("2", "a"));
        System.out.println(commitsList);
    }

    public static void main(String[] args) {
        FlippingAnImage app = new FlippingAnImage();
        app.test();
        int[][] temp = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        System.out.println(Arrays.deepToString(app.flipAndInvertImage(temp)));
    }
}