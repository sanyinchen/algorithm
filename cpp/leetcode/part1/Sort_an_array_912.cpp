//
// Created by sanyinchen on 2020/3/31.
//
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<int> sortArray(vector<int> &nums) {
        sort(nums.begin(), nums.end());
        return nums;
    }
};