//
// Created by sanyinchen on 17/4/24.
//

#include <iostream>
#include <vector>

using namespace std;

double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2) {

    vector<int> merge;
    nums1.push_back(-1);
    nums2.push_back(-1);
    for (int i = 0, j = 0; i < nums1.size() - 1 || j < nums2.size() - 1;) {
        if (i == nums1.size() - 1 && j == nums2.size() - 1) {
            break;
        }
        if (i == nums1.size() - 1 && j != nums2.size() - 1) {
            for (int k = j; k < nums2.size() - 1; k++) {
                merge.push_back(nums2[k]);
            }
            break;
        }
        if (i != nums1.size() - 1 && j == nums2.size() - 1) {
            for (int k = i; k < nums1.size() - 1; k++) {
                merge.push_back(nums1[k]);
            }
            break;
        }

        if (nums1[i] < nums2[j]) {
            merge.push_back(nums1[i++]);
        } else {
            merge.push_back(nums2[j++]);
        }

    }
//    for (int i = 0; i < merge.size(); i++) {
//        cout << merge[i] << " ";
//    }
//    cout << endl;

    return (merge[(merge.size() - 1) / 2] + merge[(merge.size()) / 2]) / 2.0;
}

int main() {
    vector<int> a;
    vector<int> b;
    a.push_back(1);
    a.push_back(2);
    b.push_back(3);
    b.push_back(4);
    cout << findMedianSortedArrays(a, b);
    return 0;
}