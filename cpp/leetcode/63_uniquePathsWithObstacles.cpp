//
// Created by sanyinchen on 7/26/25.
//
#include <common.h>

struct pair_hash {
    size_t operator()(const pair<int, int>& p) const {
        return hash<int>()(p.first) ^ (hash<int>()(p.second) << 1);
    }
};

class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int i_max = obstacleGrid.size();
        int j_max = obstacleGrid[0].size();
        if (obstacleGrid[i_max - 1][j_max - 1] == 1) {
            return 0;
        }
        unordered_map<pair<int, int>, int, pair_hash> memo;
        function<int(int, int)> dfs = [&](int i, int j) {
            pair<int, int> key = {i, j};
            if (i >= i_max || j >= j_max) return 0;
            if (memo.find(key) != memo.end()) return memo[key];
            if (i == i_max - 1 && j == j_max - 1) {
                return 1;
            }
            if (obstacleGrid[i][j] == 1) {
                return 0;
            }
            memo[key] = dfs(i + 1, j) + dfs(i, j + 1);
            return memo[key];
        };
        return dfs(0, 0);;
    }
};

// int main() {
//     Solution sol = Solution();
//
//     vector<vector<int>> obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
//     cout << sol.uniquePathsWithObstacles(obstacleGrid);
//     return 0;
// }
