//
// Created by sanyinchen on 17/4/12.
// http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_1_A
//

#include "iostream"
#include<cstdio>

using namespace std;


/*
int *insertSort(int (&array)[8], int length) {


    for (int i = 1; i < length; i++) {

        // loop change header of array
        for (int k = 0; k < i; k++) {
            if (array[i] < array[k]) {
                swap(array[i], array[k]);
            }

        }
    }


    return array;
}
 */
void printArray(int *array, int length) {
    for (int i = 0; i < length; i++) {
        if (i != 0)cout << " ";
        cout << array[i];
    }
    cout << endl;
}

int main() {
    //freopen("../files/sort_1.txt","r",stdin);
    int array[100] = {0};
    int length = 0;
    cin >> length;
    for (int i = 0; i < length; i++) {
        cin >> array[i];
    }
    printArray(array, length);

    for (int i = 1; i < length; i++) {

        // loop change header of array
        for (int k = 0; k < i; k++) {
            if (array[i] < array[k]) {
                swap(array[i], array[k]);
            }

        }
        printArray(array, length);
    }


    return 0;
}