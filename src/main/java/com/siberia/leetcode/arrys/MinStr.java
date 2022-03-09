package com.siberia.leetcode.arrys;

import java.util.Scanner;

public class MinStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = s.length();
        if (n < 2) {
            System.out.println(s);
            System.exit(0);
        }
        char[] test = s.toCharArray();
        char tempChar;
        int minChar;
        for (int i = 0; i < n; i++) {
            minChar = getMin(test, i);
            if (test[i] == test[minChar]) {
                continue;
            } else if (test[i] > test[minChar]) {
                tempChar = test[i];
                test[i] = test[minChar];
                test[minChar] = tempChar;
                break;
            }

        }
        System.out.println(String.copyValueOf(test));
    }

    static int getMin(char[] test, int index) {
        int result = index;
        for (int i = index; i < test.length; i++) {
            if (result <= test[i]) {
                result = i;
            }
        }
        return result;
    }
}