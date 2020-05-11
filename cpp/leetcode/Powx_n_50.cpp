//
// Created by sanyinchen on 2020/5/11.
//
#include <iostream>

using namespace std;

class Solution {
public:

    double fastPow(double x, long n) {
        if (n == 1) {
            return x;
        }
        double temp = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        }
        return temp * temp * x;
    }

    double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1.0 / fastPow(x, -(long)n);
        }
        return fastPow(x, n);
    }
};