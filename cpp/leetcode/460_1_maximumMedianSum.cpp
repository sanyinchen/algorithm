//
// Created by sanyinchen on 7/27/25.
//
#include <common.h>

class Solution {
public:
    long long maximumMedianSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        long long sum = 0;
        for (int i = 0, j = nums.size() - 1; i < nums.size() / 3 && j >= 0; i++, j--) {
            sum += nums[j - 1];
            cout << nums[j - 1] << endl;
            j--;

            if (i >= j) {
                break;
            }
        }
        return sum;
    }
};

int main(int argc, char* argv[]) {
    Solution s;
    vector<int> nums{2, 1, 3, 2, 1, 3};
    cout << s.maximumMedianSum(nums) << endl;
}
