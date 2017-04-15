//
// Created by sanyinchen on 17/4/13.
//

#include <iostream>
#include <vector>
#include <stack>

using namespace std;


int *_merge(int *array, int start, int end) {

    int mid = (end + start) / 2;
    int leftN = mid - start + 1;
    int left[leftN + 1];
    int rightN = end - mid;
    int right[rightN + 1];
    int k = start;
    left[leftN] = numeric_limits<int>::max();
    right[rightN] = numeric_limits<int>::max();
    for (int i = 0; i < leftN; i++) {
        left[i] = array[start + i];
    }
    for (int i = 0; i < rightN; i++) {
        right[i] = array[i + mid + 1];
    }


    for (int i = 0, j = 0; i < leftN || j < rightN;) {

        if (left[i] == numeric_limits<int>::max() && right[j] != numeric_limits<int>::max()) {
            array[k++] = right[j++];
            continue;
        }
        if (right[j] == numeric_limits<int>::max() && left[i] != numeric_limits<int>::max()) {
            array[k++] = left[i++];
            continue;
        }
        if (right[j] == numeric_limits<int>::max() && left[i] == numeric_limits<int>::max()) {
            break;
        }


        if (left[i] < right[j]) {
            array[k++] = left[i++];
        } else {
            array[k++] = right[j++];
        }

    }


    return array;

}

int *mergeSort(int *array, int start, int end) {
    int mid = (end + start) / 2;
    if (start < end) {
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        return _merge(array, start, end);
    } else {
        return array;
    }

}


vector<int> _merge(vector<int> left, vector<int> right) {

    if (left.size() == 0) {
        return right;
    }
    if (right.size() == 0) {
        return left;
    }
    int leftN = left.size() + 1;
    int rightN = right.size() + 1;
    vector<int> array;

    left.push_back(numeric_limits<int>::max());
    right.push_back(numeric_limits<int>::max());


    for (int i = 0, j = 0; i < leftN || j < rightN;) {

        if (left[i] == numeric_limits<int>::max() && right[j] != numeric_limits<int>::max()) {
            array.push_back(right[j++]);

            continue;
        }
        if (right[j] == numeric_limits<int>::max() && left[i] != numeric_limits<int>::max()) {
            array.push_back(left[i++]);

            continue;
        }
        if (right[j] == numeric_limits<int>::max() && left[i] == numeric_limits<int>::max()) {
            break;
        }


        if (left[i] < right[j]) {
            array.push_back(left[i++]);

        } else {
            array.push_back(right[j++]);

        }

    }

    return array;

}


vector<int> mergeSortNoRecursion(int *array, int n) {

    stack<vector<int >> dataStack;
    stack<vector<int >> stateStack;
    vector<int> left, right, temp;
    for (int i = 0; i < n; i++) {
        dataStack.push(vector<int>(1, array[i]));
    }
    while (stateStack.size() != 1) {

        while (dataStack.size() != 0) {
            right = vector<int>(0);
            left = vector<int>(0);

            right = dataStack.top();
            dataStack.pop();
            if (dataStack.size() != 0) {
                left = dataStack.top();
                dataStack.pop();
            }
            stateStack.push(_merge(left, right));
        }

        if (stateStack.size() == 1) {
            break;
        }
        //sync stateStack to dataStack
        while (stateStack.size() != 0) {
            dataStack.push((vector<int> &&) stateStack.top());
            stateStack.pop();;
        }

    }

    //vector<int> res = stateStack.top();

    return stateStack.top();
}


int main() {

    int a[] = {5, 2, 4, 7, 1, -1, 2, 6};

    cout << "---recursion-----" << endl;

    int *r = mergeSort(a, 0, 7);

    for (int i = 0; i < 8; i++) {
        cout << r[i] << " ";
    }
    cout <<endl<< "---no recursion-----" << endl;
    vector<int> res = mergeSortNoRecursion(a, 8);
    for (int i = 0; i < res.size(); i++) {
        cout << res[i] << " ";
    }
    cout << endl;

    return 0;
}