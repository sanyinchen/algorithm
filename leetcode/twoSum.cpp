//
// Created by sanyinchen on 17/4/20.
// https://leetcode.com/problems/two-sum/#/description
//

#include <iostream>
#include <vector>
#include <map>

using namespace std;

vector<int> twoSum(vector<int> &nums, int target) {
    int length = nums.size(), dv;
    vector<int> res;
    map<int, int> maps;
    for (int i = 0; i < length; i++) {
        maps[nums[i]] = i;
    }
    for (int i = 0; i < length; i++) {

        dv = target - nums[i];
        if (maps.find(dv) != maps.cend() && maps[dv] != i) {
            res.push_back(i);
            res.push_back(maps[dv]);
            break;
        }
    }
    return res;
}

int main() {

    vector<int> a;
    a.push_back(3);
    a.push_back(3);


    vector<int> r = twoSum(a, 6);
    for (int i = 0; i < r.size(); i++) {
        cout << r[i] << " ";
    }

    return 0;
}

