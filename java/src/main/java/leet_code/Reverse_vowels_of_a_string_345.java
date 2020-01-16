package leet_code;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.Stack;

public class Reverse_vowels_of_a_string_345 {
    class Solution {
        private boolean isVowelChar(char item) {
            char lowChar = Character.toLowerCase(item);
            return lowChar == 'a' || lowChar == 'e' || lowChar == 'i' || lowChar == 'o' || lowChar == 'u';
        }

        public String reverseVowels(String str) {
            Stack<Character> stack = new Stack<>();
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (isVowelChar(chars[i])) {
                    stack.push(chars[i]);
                }
            }

            for (int i = 0; i < chars.length; i++) {
                if (isVowelChar(chars[i])) {
                    chars[i] = stack.pop();
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                stringBuilder.append(chars[i]);
            }
            return stringBuilder.toString();
        }
    }
}
