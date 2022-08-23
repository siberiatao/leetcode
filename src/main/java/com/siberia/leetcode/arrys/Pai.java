package com.siberia.leetcode.arrys;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Pai {

    public static Map<String, List<Integer>> number = new HashMap<>();
    public static Map<String, List<Integer>> color = new HashMap<>();

    public static boolean[] used;

    public static int result = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String numbers = in.nextLine();
        String colors = in.nextLine();

        String[] countNumbers = numbers.split(" ");
        String[] countColors = colors.split(" ");

        used = new boolean[countColors.length];

        for (int i = 0; i < countColors.length; ++i) {
            List<Integer> ns = number.getOrDefault(countNumbers[i], new LinkedList<>());
            ns.add(i);
            List<Integer> cs = color.getOrDefault(countColors[i], new LinkedList<>());
            cs.add(i);
            number.put(countNumbers[i], ns);
            color.put(countColors[i], cs);
        }

        for (int i = 0; i < used.length; ++i) {
            backTrack(countNumbers, countColors, i, 0);
        }
        System.out.println(result);

    }

    public static boolean isEnd(String numberStr, String colorStr) {
        AtomicBoolean nt = new AtomicBoolean(true);
        number.get(numberStr).forEach(i -> nt.set(nt.get() & used[i]));
        AtomicBoolean ct = new AtomicBoolean(true);
        color.get(colorStr).forEach(i -> ct.set(ct.get() & used[i]));
        return nt.get() && ct.get();
    }

    public static void backTrack(String[] numbers, String[] colors, int index, int count) {
        if (used[index] || isEnd(numbers[index], colors[index])) {
            result = Math.max(count, result);
            return;
        }
        used[index] = true;
        List<Integer> nextNumber = number.get(numbers[index]);
        if (!nextNumber.isEmpty()) {
            for (Integer integer : nextNumber) {
                backTrack(numbers, colors, integer, count + 1);
            }
        }
        List<Integer> nextColor = color.get(colors[index]);
        if (!nextColor.isEmpty()) {
            for (Integer integer : nextColor) {
                backTrack(numbers, colors, integer, count + 1);
            }
        }
        used[index] = false;
    }
}