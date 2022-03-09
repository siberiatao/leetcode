package com.siberia.leetcode.arrys;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            if (getChange(i, chars)) {
                System.out.println(String.valueOf(chars));
                return;
            }
        }
        System.out.println(str);
    }

    public static boolean getChange(int p, char[] chars) {
        char minChar = chars[p];
        int mark = p;
        for (int i = chars.length - 1; i > p; --i) {
            if (chars[i] < minChar) {
                minChar = chars[i];
                mark = i;
            }
        }
        if (mark != p) {
            char temp = chars[p];
            chars[p] = chars[mark];
            chars[mark] = temp;
            return true;
        }
        return false;
    }
}
