//
// Created by sanyinchen on 8/1/25.
//
#include <common.h>

class Solution {
public:
    int earliestFinishTime(vector<int>& landStartTime, vector<int>& landDuration, vector<int>& waterStartTime,
                           vector<int>& waterDuration) {
        vector<pair<int, int>> land;
        vector<pair<int, int>> water;
        for (int i = 0; i < landStartTime.size(); i++) {
            land.emplace_back(landStartTime[i], landStartTime[i] + landDuration[i]);
        }
        for (int i = 0; i < waterStartTime.size(); i++) {
            water.emplace_back(waterStartTime[i], waterStartTime[i] + waterDuration[i]);
        }
        int res = INT_MAX;
        for (auto& it : land) {
            for (auto& it2 : water) {
                vector<pair<int, int>> temp;
                temp.push_back(it);
                temp.push_back(it2);
                sort(temp.begin(), temp.end(), [](pair<int, int> a, pair<int, int> b) {
                    return a.first - b.first;
                });
                if (temp[0].second <= temp[1].first) {
                    res = min(res, temp[0].second);
                }
            }
        }
        return res;
    }
};


int main(int argc, char* argv[]) {
    Solution solution;
    vector<int> landStartTime = {2, 8};
    vector<int> landDuration = {4, 1};
    vector<int> waterStartTime = {6};
    vector<int> waterDuration = {3};
    cout << solution.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
    return 0;
}
