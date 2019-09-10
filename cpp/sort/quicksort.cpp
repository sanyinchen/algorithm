#include <iostream>
#include<vector>
#include <stack>

using namespace std;

int test[2] = {1, 4};

vector<int> quickSort(vector<int> arry) {
    int length = arry.size();
    if (length < 2) {

        return arry;
    } else {
        vector<int> less, greater;
        for (int i = 1; i < length; i++) {
            if (arry[i] < arry[0]) {
                less.push_back(arry[i]);
            } else {
                greater.push_back(arry[i]);
            }
        }
        vector<int> left = quickSort(less);
        vector<int> right = quickSort(greater);
        vector<int> a;
        int leftSize = left.size();
        for (int i = 0; i < leftSize; i++) {
            a.push_back(left[i]);
        }
        a.push_back(arry[0]);
        int rightSize = right.size();
        for (int i = 0; i < rightSize; i++) {
            a.push_back(right[i]);
        }
        return a;

    }
}

void quickSort1() {
    int lenght = sizeof(test) / sizeof(test[0]);
    vector<int> a;

    for (int i = 0; i < lenght; i++) {
        a.push_back(test[i]);
    }

    vector<int> b = quickSort(a);

    for (int i = 0; i < b.size(); i++) {
        cout << b[i] << " ";
    }
}

bool isNullOfLeft(vector<int> left) {

    return left.size() == 0;
}

bool isNullOfRight(vector<int> right) {

    return right.size() == 0;
}


vector<int> quickSoryWithoutRecursion(vector<int> array) {

    stack<vector<int >> stacks;
    vector<int> top, res;
    stacks.push(array);

    while (true) {
        vector<int> less, greater, mid;
        top = stacks.top();
        stacks.pop();
        for (int i = 1; i < top.size(); i++) {
            if (top[i] < top[0]) {
                less.push_back(top[i]);
            } else {
                greater.push_back(top[i]);
            }
        }

        if (!isNullOfRight(greater)) {
            stacks.push(greater);
        }

        if (isNullOfLeft(less)) {
            res.push_back(top[0]);
        } else {
            mid.push_back(top[0]);
            stacks.push(mid);
            stacks.push(less);
        }

        if (stacks.size() == 0) {
            break;
        }

    }
    return res;

}


int main() {

    int lenght = sizeof(test) / sizeof(test[0]);
    vector<int> a;

    for (int i = 0; i < lenght; i++) {
        a.push_back(test[i]);
    }

    vector<int> b = quickSort(a);

    b = quickSoryWithoutRecursion(a);

    cout << "quick sort by no partition" << endl;
    for (int i = 0; i < b.size(); i++) {
        cout << b[i] << " ";
    }
    cout << endl;
    cout << "quick sort by partition" << endl;
    for (int i = 0; i < b.size(); i++) {
        cout << b[i] << " ";
    }


    return 0;
}




