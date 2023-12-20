package leet_code.weekly_contest.weekly_contest_159;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class remove_sub_folders_from_the_filesystem_5231 {
    class Solution {
        public List<String> removeSubfolders(String[] folder) {
            Set<String> cache = new HashSet<>();
            Arrays.sort(folder);
            List<String> res = new ArrayList<>();
            for (String item : folder) {
                String[] folders = item.split("/");
                if (folders.length == 0) {
                    continue;
                }
                StringBuilder temp = new StringBuilder();
                String tempStr = "";
                boolean flag = true;
                for (int i = 0; i < folders.length; i++) {
                    String child = folders[i].trim();
                    if (child.length() == 0) {
                        continue;
                    }
                    temp.append(child).append("_");
                    tempStr = temp.toString();
                    if (cache.contains(tempStr)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res.add(item);
                    cache.add(tempStr);
                }
            }
            return res;
        }
    }
}
