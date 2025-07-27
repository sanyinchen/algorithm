//
// Created by sanyinchen on 7/25/25.
//
#include <common.h>
#include <limits.h>

class Solution
{
public:
    int maxSum(vector<int>& nums)
    {
        unordered_set<int> s;
        int sum = INT_MIN;
        int default_value = INT_MIN;
        for (int num : nums)
        {
            default_value = max(default_value, num);
            if (num > 0 && !s.contains(num))
            {
                s.insert(num);
                if (sum == INT_MIN)
                {
                    sum = num;
                }
                else
                {
                    sum += num;
                }
            }
        }
        return max(sum, default_value);
    }
};
