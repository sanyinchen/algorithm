//
// Created by sanyinchen on 2020/4/8.
//
#include <vector>
#include <map>

using namespace std;

class NumArray {
public:
    vector<int> nums;
    map<string, int> cache;

    NumArray(vector<int> &nums) {
        this->nums = nums;
    }

    int sumRange(int i, int j) {
        int sum = 0;
        string key = to_string(i) + "_" + to_string(j);
        if (cache.count(key)) {
            return cache.at(key);
        }
        for (int start = i; start <= j; start++) {
            sum += nums[start];
        }
        cache.insert(make_pair(key, sum));
        return sum;
    }
};
