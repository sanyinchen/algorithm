//
// Created by sanyinchen on 2025/7/22.
//
#include <vector>
#include <iostream>
#include <unordered_map>
#include <string>
#include <deque>
#include <tuple>
#include <unordered_set>
using namespace std;

class Solution {
public:
    int maximumUniqueSubarray(vector<int> &nums) {
        unordered_map<int, int> window;
        unordered_set<int> s;
        int left = 0, right = 0;
        int max_sum = 0;

        while (left <= right && right < nums.size()) {
            int c = nums[right];
            window[c]++;
            // 增大窗口
            right++;
            int sum = 0;
            for (auto it = window.begin(); it != window.end(); it++) {
                sum += it->first;
                if (it->second > 1) {
                    s.insert(it->first);
                }
            }
            if (s.empty()) {
                max_sum = max(max_sum, sum);
            }
            while (left < right && !s.empty()) {
                // 将d移出窗口
                int d = nums[left];
                window[d]--;
                sum -= d;
                if (window[d] <= 1) {
                    s.erase(d);
                    if (window[d] == 0) {
                        window.erase(d);
                    }
                }

                // 缩小窗口
                left++;
                if (s.empty()) {
                    max_sum = max(max_sum, sum);
                }
            }
        }
        return max_sum;
    }
};

// int main() {
//     Solution solution;
//     vector<int> nums = {4, 2, 4, 5, 6};
//     cout << solution.maximumUniqueSubarray(nums);
// }
