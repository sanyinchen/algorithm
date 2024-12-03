//
// Created by sanyinchen on 2020/4/8.
//
#include <iostream>
using namespace std;

class Solution {
public:
    bool isUgly(int num) {
        bool flag = true;
        while (num > 0 && flag) {
            flag = false;
            if (num % 30 == 0) {
                flag = true;
                num /= 30;
                continue;
            }
            if (num % 15 == 0) {
                flag = true;
                num /= 15;
                continue;
            }
            if (num % 10 == 0) {
                flag = true;
                num /= 10;
                continue;
            }
            if (num % 6 == 0) {
                flag = true;
                num /= 6;
                continue;
            }
            if (num % 5 == 0) {
                flag = true;
                num /= 5;
                continue;
            }
            if (num % 3 == 0) {
                flag = true;
                num /= 3;
                continue;
            }
            if (num % 2 == 0) {
                flag = true;
                num /= 2;
                continue;
            }
        }
        return num == 1;
    }
};
int main() {
    Solution s;
}