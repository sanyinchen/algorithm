//
// Created by sanyinchen on 17/4/25.
// https://leetcode.com/problems/reverse-integer/#/description
//

#include <iostream>
#include <vector>
#include <cmath>
#include <limits>

using namespace std;

int reverse(int x) {
    int negative = false;
    if (x == 0)return 0;
    if (x < 0) {
        negative = true;
        x = abs(x);
    }
    long long step = 1;
    long long sum = 0;
    vector<int> array;
    while (x > 0) {
        array.push_back(x % 10);
        x /= 10;
    }
    for (int i = array.size() - 1; i >= 0; i--) {
        sum += step * array[i];
        step *= 10;
        if (sum > numeric_limits<int>::max())return 0;
    }
    if (negative) {
        sum = 0 - sum;
    }
    return sum;
}

int main() {
    int x = 1534236469;
    cout << reverse(x);
//    int m = numeric_limits<int>::min();
//
//    cout << m << endl;
//    cout << m * m << endl;
    return 0;
}