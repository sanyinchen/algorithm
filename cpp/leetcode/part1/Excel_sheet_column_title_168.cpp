//
// Created by Administrator on 2020年04月06日, 0006.
//
#include <iostream>
#include <algorithm>

using namespace std;

class Solution {
public:
    string convertToTitle(int n) {
        string str;
        while (n > 0) {
            n -= 1;
            int i = n % 26;
            char item = i + 'A';

            str += item;
            n /= 26;
            cout << i << " " << n << endl;
        }
        reverse(str.begin(), str.end());
        return str;
    }

};