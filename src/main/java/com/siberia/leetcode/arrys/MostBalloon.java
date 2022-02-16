package com.siberia.leetcode.arrys;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MostBalloon {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> balloon = new HashMap<>();
        balloon.put('b', 0);
        balloon.put('a', 0);
        balloon.put('l', 0);
        balloon.put('o', 0);
        balloon.put('n', 0);
        for (int i = 0; i < text.length(); i++) {
            if (balloon.containsKey(text.charAt(i))) {
                balloon.put(text.charAt(i), balloon.get(text.charAt(i)) + 1);
            }
        }
        balloon.put('l', balloon.get('l') / 2);
        balloon.put('0', balloon.get('o') / 2);
        return balloon.values().stream().min(Comparator.comparing((O1) -> O1)).get();
    }
}
