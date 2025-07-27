//
// Created by sanyinchen on 7/26/25.
//
#include <common.h>

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        const int rows = matrix.size();
        const int cols = matrix[0].size();
        vector<vector<int>> memo(rows, vector<int>(cols, -1));
        int maxLen = 0;

        function<int(int, int)> dfs = [&](int i, int j) -> int {
            if (i < 0 || j < 0) return 0;
            if (memo[i][j] != -1) return memo[i][j];
            if (matrix[i][j] == '0') return memo[i][j] = 0;

            int top = dfs(i - 1, j);
            int left = dfs(i, j - 1);
            int diag = dfs(i - 1, j - 1);

            return memo[i][j] = min({top, left, diag}) + 1;
        };

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                maxLen = max(maxLen, dfs(i, j));
            }
        }

        return maxLen * maxLen;
    }
};
