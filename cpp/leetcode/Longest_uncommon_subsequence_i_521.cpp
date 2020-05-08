//
// Created by sanyinchen on 2020/5/8.
//
#include <string>
#include <iostream>

using namespace std;

class Solution {
public:
    int findLUSlength(string a, string b) {
        // cout << "compare:" << a.compare(b);
        if (a.compare(b) == 0) {
            return -1;
        }
        int a_len = a.length();
        int b_len = b.length();
        return max(a_len, b_len);

    }
};