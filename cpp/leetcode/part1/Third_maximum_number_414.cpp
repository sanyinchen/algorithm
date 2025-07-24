//
// Created by sanyinchen on 2020/4/12.
//
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:

    void thirdMaxHelper(vector<int> &nums) {
        sort(nums.begin(), nums.end());
        while (nums.size() > 3) {
            nums.erase(nums.begin());
        }

    }

    int thirdMax(vector<int> &nums) {

        vector<int> res;
        for (auto item:nums) {
            if (find(res.begin(), res.end(), item) == res.end()) {
                res.push_back(item);
                thirdMaxHelper(res);
            }
        }
        if (res.size() < 3) {
            return res[res.size() - 1];
        }
        // cout << res.size() << endl;
        return res[0];
    }
};

int main() {
    Solution solution;
    vector<int> test;
    test.push_back(3);
    test.push_back(2);
    test.push_back(1);
    cout << solution.thirdMax(test);
    return 0;
}