package com.siberia.leetcode.arrys;

import java.util.Arrays;
import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String length = in.nextLine();
        String content = in.nextLine();
        String[] split = content.split(" ");
        int[] nums = new int[Integer.parseInt(length)];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                for (int k = i - 1; k >= 0; k--) {
                    if (nums[i] == nums[j] + 2 * nums[k]) {
                        System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}
