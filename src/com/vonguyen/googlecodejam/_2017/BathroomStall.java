package com.vonguyen.googlecodejam._2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BathroomStall {

    public BigInteger[] findRoom(BigInteger n, BigInteger k) {
        TreeMap<BigInteger, BigInteger> q = new TreeMap<>();
        q.put(n,BigInteger.ONE);
        BigInteger t = k;
        while (k.compareTo(BigInteger.ONE) > 0) {
            Map<BigInteger, BigInteger> h = new HashMap<>();
            while (!q.isEmpty()) {
                BigInteger m = q.lastKey();
                BigInteger count = q.remove(m);
                h.put(m,count);
                t = t.subtract(count);
            }
            h.forEach((k1,v1) -> {
                q.merge(k1.shiftRight(1), v1, BigInteger::add);
                q.merge(k1.subtract(BigInteger.ONE).shiftRight(1), v1, BigInteger::add);
            });

            k = k.shiftRight(1);
        }

        while (t.compareTo(BigInteger.ZERO) > 0) {
            BigInteger m = q.lastKey();
            BigInteger count = q.remove(m);
            if (t.compareTo(count) > 0) {
                t = t.subtract(count);
            } else {
                BigInteger[] temp = new BigInteger[2];
                temp[0] = m.shiftRight(1);
                temp[1] = m.subtract(BigInteger.ONE).shiftRight(1);
                return temp;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        BathroomStall app = new BathroomStall();

        for (int i=0; i<t; i++) {
            BigInteger n = new BigInteger(in.next());
            BigInteger k = new BigInteger(in.next());
            BigInteger[] p = app.findRoom(n, k);
            System.out.println("Case #" + (i+1) + ": " + p[0] + " " + p[1]);
        }
    }
}
