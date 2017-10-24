//
// Created by sanyinchen on 17/4/17.
//http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_1_D
//

#include <iostream>
#include <limits>
#include <string.h>
#include <vector>
#include <cstdio>

using namespace std;

vector<int> findMaxWithMidPoint(int *array, int low, int high) {

    int mid = (low + high) / 2;
    int leftSum = 0, leftLow = mid;
    int rightSum = 0, rightHigh = mid + 1;
    int maxLeft = array[leftLow], maxRight = array[rightHigh];

    vector<int> res;
    for (int i = mid; i >= low; i--) {
        leftSum += array[i];
        if (leftSum > maxLeft) {
            maxLeft = leftSum;
            leftLow = i;
        }
    }
    res.push_back(leftLow);

    for (int i = mid + 1; i <= high; i++) {
        rightSum += array[i];
        if (rightSum > maxRight) {
            maxRight = rightSum;
            rightHigh = i;
        }
    }
    res.push_back(rightHigh);
//    cout << low << " " << high << endl;
//    cout << "sum:" << maxLeft + maxRight << " left:" << leftLow << " " << "high:" << rightHigh << endl;
    res.push_back(maxLeft + maxRight);

    return res;
}


vector<int> findMax(int *array, int low, int high) {


    if (low == high) {

        vector<int> res;
        res.push_back(low);
        res.push_back(high);
        res.push_back(array[low]);
        return res;
    } else {
        int mid = (low + high) / 2;

        vector<int> left = findMax(array, low, mid);
        vector<int> right = findMax(array, mid + 1, high);
        vector<int> midRes = findMaxWithMidPoint(array, low, high);
//        cout << "left:" << left[0] << " " << left[1] << " " << left[2] << endl;
//        cout << "right:" << right[0] << " " << right[1] << " " << right[2] << endl;
//        cout << "midRes:" << midRes[0] << " " << midRes[1] << " " << midRes[2] << endl;

        if (left[2] >= right[2] && left[2] >= midRes[2]) {
            return left;
        }
        if (right[2] >= left[2] && right[2] >= midRes[2]) {

            return right;
        }

        return midRes;

    }

}


int main() {
    //freopen("../files/in.txt", "r", stdin);
    int input[200001] = {0};
    int data[200001] = {0};
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> input[i];
        if (i == 0) {
            data[i] = 0 - input[i];
        } else {
            data[i] = input[i] - input[i - 1];
        }
    }
//    for (int i = 0; i < n; i++) {
//        cout << data[i] << " ";
//    }
    //cout << endl;
    vector<int> res = findMax(data, 0, n - 1);
    //cout << res[0] << " " << res[1] << " " << res[2] << endl;
    cout << res[2] << endl;

    return 0;
}