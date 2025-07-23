//
// Created by sanyinchen on 2025/7/23.
//
#include <vector>
#include <iostream>
#include <unordered_map>
#include <string>
#include <deque>
#include <tuple>
#include <unordered_set>
using namespace std;

using ULL = unsigned long long;

class Solution {
public:
    char kthCharacter(long long k_origin, vector<int> &operations) {
        ULL k = k_origin;
        ULL str_len = 1;
        int shift = 0;
        function<void(int)> find_kth_char = [&](int index) {
            if (index == operations.size()) {
                return;
            }
            if (str_len > (ULLONG_MAX >> 1)) {
                return;
            }
            int op = operations[index];
            str_len <<= 1;
            find_kth_char(index + 1);
            str_len /= 2;
            // 回溯反推
            if (k > str_len) {
                k -= str_len;
                // op == 0 时，复制自己，字符没变，只需减 k
                // op ==1 时，偏移+1
                if (op == 1) {
                    shift++;
                }
            }
        };
        find_kth_char(0);
        // 最后从 'a' 加上 shift 次偏移即可
        return static_cast<char>('a' + (shift % 26));
    }
};

int main() {
    Solution s;
    vector<int> operations = {0, 1, 0, 1};
    cout << s.kthCharacter(10, operations) << endl;
}
