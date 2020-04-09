//
// Created by sanyinchen on 2020/4/9.
//
#include <iostream>

using namespace std;

class Solution {
public:
    bool isSubsequence(string s, string t) {
        int sum = 0;
        for (int i = 0, j = 0; i < s.length() && j < t.length(); j++) {
            char s_char = s[i];
            char t_char = t[j];
            if (s[i] == t[j]) {
                sum++;
                i++;
            }
        }
        return sum == s.length();
    }
};
