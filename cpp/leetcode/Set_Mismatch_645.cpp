//
// Created by Administrator on 2020年05月28日, 0028.
//

#include <iostream>
#include <vector>
#include <set>
#include <cstring>

using namespace std;

class Solution {
public:


    vector<int> findErrorNums(vector<int> &nums) {
        vector<int> res;
        const int size = nums.size() + 1;
        if (size == 1) {
            return res;
        }
        int *temp;
        temp = new int[size]{0};
        for (int i = 0; i < nums.size(); ++i) {
            temp[nums[i]]++;
        }
        int index = -1;
        int dou = -1;
        for (int i = 1; i < size; ++i) {
            cout << temp[i] << " " << i << endl;
            if (temp[i] == 0) {
                index = i;
                continue;
            }
            if (temp[i] > 1) {
                dou = i;
            }
        }
        res.push_back(dou);
        res.push_back(index);
        return res;
    }
};

int main() {
    Solution solution;
    // vector<int> nums{1, 2, 2, 4};
    // vector<int> nums{3, 2, 2};
    vector<int> nums{1, 1};
    vector<int> res = solution.findErrorNums(nums);
    cout << res[0] << " " << res[1];
    return 0;
}