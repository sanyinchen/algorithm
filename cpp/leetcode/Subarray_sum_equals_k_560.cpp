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
        int v_size = nums.size() + 1;
        vector<int> sums(v_size * 2);
        sums[0] = 0;
        sums[1] = nums[0];
        int nums_size = nums.size();
        for (int i = 1; i < nums_size; ++i) {
            sums[i + 1] = nums[i] + sums[i];
        }
        int sums_size = v_size;
        for (int i = 0; i < sums_size - 1; ++i) {
            for (int j = i + 1; j < sums_size; ++j) {
                if (sums[j] - sums[i] == k) {
                    // cout << i << " " << j << endl;
                    res++;
                }
            }
        }

        return res;
    }
};

int main() {
    Solution solution;
    vector<int> inputs{-1, -1, 1};
    cout << solution.subarraySum(inputs, 0) << endl;
    vector<int> inputs2{1, 1, 1};
    cout << solution.subarraySum(inputs2, 2) << endl;
    vector<int> inputs3{1, 2, 3};
    cout << solution.subarraySum(inputs3, 3);
    return 0;
}