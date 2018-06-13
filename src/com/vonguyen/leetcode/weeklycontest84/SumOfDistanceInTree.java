package com.vonguyen.leetcode.weeklycontest84;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfDistanceInTree {

    int[] count;
    int[] sum;
    boolean[] visited;
    List<Integer>[] adjList;
    int n;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        this.n = N;
        adjList = new ArrayList[N];
        for (int i=0; i<N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        count = new int[N];
        sum = new int[N];
        visited = new boolean[N];
        Arrays.fill(visited, false);
        Arrays.fill(count, 1);
        traverse1(0);
        Arrays.fill(visited, false);
        traverse2(0);
        return sum;
    }

    private void traverse1(int root) {
        visited[root] = true;
        List<Integer> adjV = adjList[root];
        for (int child : adjV) {
            if (!visited[child]) {
                traverse1(child);
                count[root] = count[root] + count[child];
                sum[root] = sum[root] + sum[child] + count[child];
            }
        }
    }

    private void traverse2(int root) {
        visited[root] = true;
        List<Integer> adjV = adjList[root];
        for (int child : adjV) {
            if (!visited[child]) {
                sum[child] = sum[root] - count[child] + n - count[child];
                traverse2(child);
            }
        }
    }

    public static void main(String[] args) {
        SumOfDistanceInTree app = new SumOfDistanceInTree();
        int N = 6;
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        app.sumOfDistancesInTree(N, edges);
    }
}
