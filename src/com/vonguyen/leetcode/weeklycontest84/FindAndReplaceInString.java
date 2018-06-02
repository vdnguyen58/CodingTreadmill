package com.vonguyen.leetcode.weeklycontest84;

import java.util.Arrays;

public class FindAndReplaceInString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int[] pos = new int[S.length()];
        Arrays.fill(pos,-1);
        String ret = "";
        for (int i=0; i<indexes.length; i++) {
            if (S.indexOf(sources[i],indexes[i]) == indexes[i]) {
                Arrays.fill(pos,indexes[i],indexes[i]+sources[i].length(),i);
            }
        }
        for (int i=0; i<pos.length; i++) {
            if (pos[i] == -1) {
                ret = ret + S.charAt(i);
            } else {
                if (i == 0 || (pos[i] != pos[i-1])) {
                    ret = ret + targets[pos[i]];
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String S = "wreorttvosuidhrxvmvo";
        int[] indexes = {14,12,10,5,0,18};
        String[] sources = {"rxv","dh","ui","ttv","wreor","vo"};
        String[] targets = {"frs","c","ql","qpir","gwbeve","n"};
        FindAndReplaceInString app = new FindAndReplaceInString();
        System.out.println(app.findReplaceString(S, indexes, sources, targets).equalsIgnoreCase("gwbeveqpirosqlcfrsmn"));
    }
}
