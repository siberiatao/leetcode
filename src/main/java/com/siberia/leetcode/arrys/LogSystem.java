package com.siberia.leetcode.arrys;

import java.util.*;

public class LogSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = Integer.parseInt(scanner.nextLine());
        List<String> maps = new LinkedList<>();
        for (int i = 0; i < total; i++) {
            maps.add(scanner.nextLine());
        }
        maps.sort(Comparator.comparingInt(LogSystem::getMills));
        maps.forEach(System.out::println);
    }

    private static int getMills(String str) {
        String[] strings = str.split(":");
        int hour = Integer.parseInt(strings[0]) * 3600000;
        int minute = Integer.parseInt(strings[1]) * 60000;
        int second = Integer.parseInt(strings[2].split("\\.")[0]) * 1000;
        int millisecond = Integer.parseInt(strings[2].split("\\.")[1]);
        return hour + minute + second + millisecond;
    }
}
