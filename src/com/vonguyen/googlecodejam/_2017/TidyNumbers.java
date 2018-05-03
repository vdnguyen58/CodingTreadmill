package com.vonguyen.googlecodejam._2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TidyNumbers {

    private int isTidy(char[] n) {
        for (int i=1; i<n.length; i++) {
            if (n[i] < n[i-1]) {
                return i-1;
            }
        }
        return -1;
    }

    private String findNextTidyNumber(String n) {
        String result = "";
        int pos = isTidy(n.toCharArray());
        int size = n.length();
        while (pos != -1) {
            String p1 = n.substring(0,pos);
            char p2 = (char)((int) n.charAt(pos) - 1);
            n = p1 + p2;
            int l = size - (pos+1);
            while (l-->0) result = "9" + result;
            size = pos+1;
            pos = isTidy(n.toCharArray());
        }
        if (n.equals("0"))
            n = "";
        return n + result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        TidyNumbers app = new TidyNumbers();
        int t = in.nextInt();
        for (int i=0; i<t; i++) {
            String n = in.next();
            System.out.println("Case #" + (i+1) + ": " + app.findNextTidyNumber(n));
        }
    }
}
