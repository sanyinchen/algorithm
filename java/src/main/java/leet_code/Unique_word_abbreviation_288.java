package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by sanyinchen on 20-1-6.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-6
 */

class Unique_word_abbreviation_288 {
    static class ValidWordAbbr {
        HashSet<String> sources = new HashSet<>();
        Map<String, Integer> hashcodes = new HashMap<>();

        public ValidWordAbbr(String[] dictionary) {
            sources.addAll(Arrays.asList(dictionary));

            for (String item : sources) {
                String key = getHash(item);
                System.out.println(item + " hash: " + key);
                if (!hashcodes.containsKey(key)) {
                    hashcodes.put(key, 1);
                } else {
                    hashcodes.replace(key, hashcodes.get(key) + 1);
                }
            }
        }

        private String getHash(String str) {
            if (str.length() <= 2) {
                return str;
            }
            return "" + str.charAt(0) + (str.length() - 2) + str.charAt(str.length() - 1);
        }

        public boolean isUnique(String word) {
            String hash = getHash(word);
            System.out.println("find: " + word + " " + hash);
            if (hashcodes.containsKey(hash)) {
                if (sources.contains(word) && hashcodes.get(hash) == 1) {
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
