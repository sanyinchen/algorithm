//
// Created by sanyinchen on 2020/5/6.
//
#include <string>
#include <math.h>
#include <iostream>

using namespace std;

class Solution {
public:
    int longestPalindromeSubseq(string s) {
        int dp[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j < s.length(); ++j) {
                dp[i][j] = 1;
            }
        }
        int len = s.length();
        for (int k = 2; k <= len; ++k) {
            for (int i = 0; i < len - k + 1; ++i) {
                int j = i + k - 1;
                if (s[i] == s[j]) {
                    dp[i][j] = 2 + (k == 2 ? 0 : dp[i + 1][j - 1]);
                } else {
                    dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
//        for (int i = 0; i < s.length(); ++i) {
//            for (int j = 0; j < s.length(); ++j) {
//                cout << dp[i][j] << " ";
//            }
//            cout << endl;
//        }
        return dp[0][len - 1];
    }
};