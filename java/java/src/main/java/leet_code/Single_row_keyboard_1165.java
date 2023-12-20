package leet_code;

import java.util.HashMap;
import java.util.Map;

public class Single_row_keyboard_1165 {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> cache = new HashMap<>();
        for (int i = 0; i < keyboard.length(); i++) {
            cache.put(keyboard.charAt(i), i);
        }
        int sum = cache.get(word.charAt(0));
        for (int i = 0; i < word.length() - 1; i++) {
            sum += Math.abs(cache.get(word.charAt(i + 1)) - cache.get(word.charAt(i)));
        }
        return sum;
    }
}
