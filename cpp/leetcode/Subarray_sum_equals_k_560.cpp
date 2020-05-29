//
// Created by Administrator on 2020年05月29日, 0029.
//
#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    int subarraySum(vector<int> &nums, int k) {
        int res = 0;
        if (nums.size() == 0) {
            return res;
        }
        if (nums.size() == 1) {
            return nums[0] == k ? 1 : 0;
        }
        int sums[nums.size() + 1];
        sums[0] = 0;
        sums[1] = nums[0];
        int nums_size = nums.size();
        for (int i = 1; i < nums_size; ++i) {
            sums[i + 1] = nums[i] + sums[i];
        }
        int sums_size = nums.size() + 1;
        for (int i = 0; i < sums_size - 1; ++i) {
            for (int j = i + 1; j < sums_size; ++j) {
                if (sums[j] - sums[i] == k) {
                    // cout << i << " " << j << endl;
                    res++;
                }
            }
        }
//        for (int i = 0; i < nums.size(); i++) {
//            if (nums[i] == k) {
//                res++;
//            }
//        }
        return res;
    }
};