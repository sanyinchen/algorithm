//
// Created by Administrator on 2020年04月05日, 0005.
//

class Solution {
public:
    int trailingZeroes(int n) {
        int nums = 0;
        while (n > 0) {
            nums += n / 5;
            n /= 5;

        }
        return nums;
    }
};