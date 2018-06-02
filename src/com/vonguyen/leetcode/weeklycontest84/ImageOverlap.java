package com.vonguyen.leetcode.weeklycontest84;

public class ImageOverlap {

    private int[] shiftImage(int[] A, int j, int i) {
        int[] ret = new int[A.length];
        if (j != 0) {
            for (int k=0; k<A.length; k++) {
                if (0<= k-j && k-j < A.length) {
                    ret[k] = A[k-j];
                } else {
                    ret[k] = 0;
                }
            }
        } else {
            for (int k=0; k<A.length; k++) {
                ret[k] = A[k];
            }
        }
        if (i < 0) {
            for (int k=0; k<A.length; k++) {
                ret[k] = (ret[k] << (-i)) % (1<<A.length);
            }
        } else if (i > 0) {
            for (int k=0; k<A.length; k++) {
                ret[k] = ret[k] >> i;
            }
        }
        return ret;
    }

    private int countBits(int i) {
        int count = 0;
        while (i > 0) {
            count = count + (i & 1);
            i = i >> 1;
        }
        return count;
    }

    private int countBits(int[] A, int[] B) {
        int count = 0;
        for (int i=0; i<A.length; i++) {
            count = count + countBits(A[i]&B[i]);
        }
        return count;
    }

    private int[] transform(int[][] A) {
        int n = A.length;
        int[] ret = new int[n];
        for (int i=0; i<n; i++) {
            int c1 = 0;
            for (int j=0; j<n; j++) {
                c1 = c1 + (A[i][n - j - 1] << j);
            }
            ret[i] = c1;
        }
        return ret;
    }

    public int largestOverlap(int[][] A, int[][] B) {
        int[] AA = transform(A);
        int[] BB = transform(B);
        int n = A.length;
        int max = 0;
        for (int i=-n+1; i<n; i++) {
            for (int j=-n+1; j<n; j++) {
                int[] CC = shiftImage(AA, i, j);
                int count = countBits(CC, BB);
                if (max < count) {
                    max = count;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        ImageOverlap app = new ImageOverlap();
        /*
        int[] A = {6, 2, 2};
        int[] B = {0, 3, 1};
        System.out.println(Arrays.toString(app.shiftImage(A, 0, -1)));
        System.out.println(app.countBits(0));
        System.out.println(app.countBits(A, B));
        */
        int[][] AA = {{1, 1, 0},{0, 1, 0},{0, 1, 0}};
        int[][] BB = {{0, 0, 0},{0, 1, 1},{0, 0, 1}};
        System.out.println(app.largestOverlap(AA, BB));
    }
}
