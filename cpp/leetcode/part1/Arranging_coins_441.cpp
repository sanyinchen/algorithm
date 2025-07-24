//
// Created by sanyinchen on 2020/4/13.
//
#include <iostream>

using namespace std;

class Solution {
public:
    int arrangeCoins(int n) {
        int index = 1;
        while (n >= index) {
            n -= index;
            index++;
        }
        return index - 1;
    }
};