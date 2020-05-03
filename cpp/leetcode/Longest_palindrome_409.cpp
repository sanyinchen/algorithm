//
// Created by sanyinchen on 2020/5/3.
//

#include <iostream>

using namespace std;


class Solution {
public:
    int longestPalindrome(string s) {
        const int maxLen = 'z' + 1;
        int words[maxLen] = {0};
        for (int i = 0; i < s.length(); ++i) {
            words[s[i]]++;
        }
        bool odd = false;
        int sum = 0;
        for (int j = 0; j < maxLen; ++j) {
            if (words[j] == 1) {
                odd = true;
            }
            if (words[j] % 2 == 0) {
                sum += words[j];
            } else {
                sum += (words[j] / 2 * 2);
                odd = true;
            }
        }

        return odd ? sum + 1 : sum;
    }
};

int main() {
    Solution solution;
    cout << solution.longestPalindrome("abccccdd");

    return 0;
}
