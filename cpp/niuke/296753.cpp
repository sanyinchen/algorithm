//
// Created by sanyinchen on 7/27/25.
//
#include <algorithm>
#include <cstdio>
#include <functional>
#include <iostream>
#include <unistd.h>
#include <unordered_map>
#include <unordered_set>
#include <vector>
using namespace std;

# define  int  long long

signed main() {
    freopen("niuke_input.txt", "r", stdin);
    char a, b, c;
    while (cin >> a >> b >> c) {
        unordered_set<char> set;
        function<int(char)> f = [&](char c) {
            if (set.find(c) == set.end()) {
                set.insert(c);
                return 1;
            }
            return 0;
        };
        int sum = f(a) + f(b) + f(c);
        if (sum == 1 || sum == 2) {
            cout << "YES" << endl;
        }
        else {
            cout << "NO" << endl;
        }
    }
    return 0;
}
