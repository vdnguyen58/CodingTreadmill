package com.vonguyen.googlecodejam._2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class OversizedPancakeFlipeer {

    private void flip(char[] s, int pos, int len) {
        for (int i=pos; i<pos+len; i++) {
            s[i] = (s[i] == '+') ? '-' : '+';
        }
    }

    private int flipPancakes(String s, int k) {
        char[] temp = s.toCharArray();

        int count = 0;
        for (int i=0; i<=s.length() - k; i++) {
            if (temp[i] == '-'){
                flip(temp, i, k);
                count++;
            }
        }

        for (char c : temp) {
            if (c == '-') {
                return -1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        OversizedPancakeFlipeer app = new OversizedPancakeFlipeer();
        int t = in.nextInt();
        for (int i=1; i<=t ; i++) {
            String s = in.next();
            int k = in.nextInt();
            int result = app.flipPancakes(s, k);
            if (result >= 0) {
                System.out.println("Case #" + i + ": " + result);
            } else {
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            }
        }
    }
}
