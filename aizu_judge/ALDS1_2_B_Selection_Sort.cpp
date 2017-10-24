//
// Created by sanyinchen on 17/4/25.
// http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_2_B
//
#include <iostream>
#include <cstdio>

using namespace std;

void SelectionSort(int *a, int n) {
    int step = 0, min, j;
    for (int i = 0; i < n; i++) {
        min = i;
        for (j = i; j < n; j++) {
            if (a[j] < a[min]) {
                min = j;
            }
        }

        if (a[min] != a[i]) {
            step++;
            swap(a[min], a[i]);
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
    SelectionSort(a, n);
    return 0;
}

