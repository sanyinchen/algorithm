//
// Created by sanyinchen on 2025/7/22.
//
// 滑动窗口
#include <unordered_map>
#include <vector>
void sliding_window(string s) {
    unordered_map<char, int> window;

    int left = 0, right = 0;
    while (left < right && right < s.size()) {
        // 将c移入窗口
        char c = s[right];
        window.add(c);
        window[c]++;
        // 增大窗口
        right++;

        // 窗口处理

        // 判断左侧窗口是否需要收紧
        while (left < right && window needs shrink) {
            // 将d移出窗口
            char d = s[left];
            window.remove(d);
            // 缩小窗口
            left++;
            // 窗口处理
        }
    }
}
