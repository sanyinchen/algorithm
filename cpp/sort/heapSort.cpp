//
// Created by sanyinchen on 17/4/24.
// http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_9_B
//

#include <iostream>
#include <vector>
#include <cstdio>

using namespace std;

void _print(vector<int> res) {
    for (int i = 1; i < res.size(); i++) {
        cout << res[i] << " ";
    }
    cout << endl;
}

void maxHeap(vector<int> &heap, int i) {

    int left = 2 * i;
    int right = 2 * i + 1;
    int lagest = i;
    if (left < heap.size() && left >= 1) {
        if (heap[left] > heap[lagest]) {
            lagest = left;
        }
    }

    if (right < heap.size() && right >= 1) {
        if (heap[right] > heap[lagest]) {
            lagest = right;
        }
    }

    if (lagest != i) {
        swap(heap[lagest], heap[i]);
        maxHeap(heap, lagest);
    }

}

void buildHeap(vector<int> &heap) {
    for (int i = heap.size() / 2; i >= 1; i--) {
        maxHeap(heap, i);
    }
}

vector<int> heapSort(vector<int> heap) {
    buildHeap(heap);

    while (heap.size() > 1) {

        cout << " " << heap[1];
        swap(heap[1], heap[heap.size() - 1]);
        heap.pop_back();
        maxHeap(heap, 1);
    }
}


int main() {
    //freopen("../files/in.txt", "r", stdin);
    int n, temp;
    cin >> n;
    vector<int> input;
    input.push_back(0);
    for (int i = 0; i < n; i++) {
        cin >> temp;
        input.push_back(temp);
    }
    heapSort(input);
    cout << endl;
    return 0;
}