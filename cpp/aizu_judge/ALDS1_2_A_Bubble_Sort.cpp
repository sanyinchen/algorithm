//
// Created by sanyinchen on 17/4/25.
// http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_2_A
//
#include <iostream>
#include <cstdio>

using namespace std;

void bubbleSort(int *a, int n) {
    int step = 0;
    for (int i = 0; i < n; i++) {
        for (int j = n - 1; j >= i + 1; j--) {
            if (a[j] < a[j - 1]) {
                swap(a[j], a[j - 1]);
                step++;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        if (i != 0)cout << " ";
        cout << a[i];
    }
    cout << endl;
    cout << step << endl;
}


int main() {
    //freopen("../files/in.txt", "r", stdin);
    int a[101], n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    bubbleSort(a, n);
    return 0;
}

