package leet_code.weekly_contest.weely_154;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maximum_Number_Of_Balloons_5189 {

    static class Solution {
        public int maxNumberOfBalloons(String text) {
            if (text == null || text.length() < 7) {
                return 0;
            }
            Map<Character, Integer> ballonMap = new HashMap<>();
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (ballonMap.containsKey(c)) {
                    ballonMap.put(c, ballonMap.get(c) + 1);
                } else {
                    ballonMap.put(c, 1);
                }
            }
            List<Integer> res = new ArrayList<>();
            if (ballonMap.containsKey('b')) {
                res.add(ballonMap.get('b'));
            } else {
                return 0;
            }
            if (ballonMap.containsKey('a')) {
                res.add(ballonMap.get('a'));
            } else {
                return 0;
            }
            if (ballonMap.containsKey('l')) {
                res.add(ballonMap.get('l') / 2);
            } else {
                return 0;
            }
            if (ballonMap.containsKey('o')) {
                res.add(ballonMap.get('o') / 2);
            } else {
                return 0;
            }
            if (ballonMap.containsKey('n')) {
                res.add(ballonMap.get('n'));
            } else {
                return 0;
            }
            int min = res.get(0);
            for (Integer item : res) {
                if (min > item) {
                    min = item;
                }
            }
            return min;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxNumberOfBalloons("leetcode"));
    }
}
