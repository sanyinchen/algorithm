//
// Created by sanyinchen on 7/27/25.
//
#include <common.h>

class Solution {
public:
    long long numOfSubsequences(string s) {
        vector<char> chars = {'L', 'C', 'T'};

        auto get_max_lct = [&](const string& s) -> long long {
            long long L = 0, LC = 0, LCT = 0;
            for (const char ch : s) {
                if (ch == 'L') L++;
                else if (ch == 'C') LC += L;
                else if (ch == 'T') LCT += LC;
            }
            return LCT;
        };

        long long res = get_max_lct(s);


        for (char c : chars) {
            for (int i = 0; i <= s.size(); i++) {
                string t = s; // 拷贝一次
                t.insert(t.begin() + i, c); // O(n) 插入，但只执行一次
                res = max(res, get_max_lct(t));
            }
        }
        return res;
    }
};


int main(int argc, char* argv[]) {
    Solution s;
    // vector<int> nums{2, 1, 3, 2, 1, 3};
    cout << s.numOfSubsequences("LC") << endl;
}
