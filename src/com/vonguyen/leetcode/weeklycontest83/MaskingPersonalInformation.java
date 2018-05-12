package com.vonguyen.leetcode.weeklycontest83;

public class MaskingPersonalInformation {

    private boolean emailAddress(String arg) {
        return arg.indexOf('@') >= 0;
    }

    private String convertEmailAddress(String s) {
        String s1 = s.toLowerCase();
        int pos = s1.indexOf('@');
        char ch1 = s1.charAt(0);
        char ch2 = s1.charAt(pos-1);
        String s2 = s1.substring(pos);
        return ch1 + "*****" + ch2 + s2;
    }

    private boolean isNumber(char t) {
        return (t>='0' && t<='9');
    }

    private String convertPhoneNumber(String s) {
        char[] temp = s.toCharArray();
        String lastPart = "";
        for (char c : temp) {
            if (isNumber(c)) {
                lastPart = lastPart + c;
            }
        }
        String countrySign = (lastPart.length() > 10) ? "+" : "";
        String ret = "";
        int count = 0;
        int l = lastPart.length();
        for (int i=l-1; i>=0; i--) {
            if (ret.length() > 3) {
                ret = "*" + ret;
            } else {
                ret = lastPart.charAt(i) + ret;
            }
            count++;
            if (count >= 3 && ret.length() > 3 && i != 0) {
                count = 0;
                ret = "-" + ret;
            }
        }

        return countrySign+ret;
    }

    public String maskPII(String S) {
        if (emailAddress(S)) {
            return convertEmailAddress(S);
        } else {
            return convertPhoneNumber(S);
        }
    }

    public static void main(String[] args) {
        MaskingPersonalInformation app = new MaskingPersonalInformation();
        System.out.println(app.maskPII("AB@qq.com"));
        System.out.println(app.maskPII("1(234)567-890"));
    }
}
