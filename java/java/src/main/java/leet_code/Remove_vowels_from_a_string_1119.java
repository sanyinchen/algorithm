package leet_code;

public class Remove_vowels_from_a_string_1119 {
    public String removeVowels(String str) {
        if (str == null) {
            return str;
        }
        char[] chars = new char[]{'a', 'e', 'i', 'o', 'u'};
        for (char item : chars) {
            str = str.replaceAll(item + "", "");
        }
        return str;
    }
}
