//
// Created by sanyinchen on 2020/4/7.
//
#include <iostream>
#include <algorithm>

using namespace std;

class Solution {
public:
    int titleToNumber(string str) {
        reverse(str.begin(), str.end());
        long sum = 0;
        long step = 1;
        for (int i = 0; i < str.size(); ++i) {
            char item = str[i];
            sum += (item - 'A' + 1) * step;
            step *= 26;
        }
        return sum;
    }
};