//
// Created by sanyinchen on 2020/6/5.
//
#include <iostream>
#include <vector>
#include <set>

using namespace std;

class Solution {
public:
    set<string> visited;

    string getCacheKey(int i, int j) {
        return to_string(i) + "_" + to_string(j);
    }

    void swap(int &i, int &j) {
        int temp = i;
        i = j;
        j = temp;
    }

    bool isVisited(int i, int j) {
        return (visited.find(getCacheKey(i, j)) != visited.end());
    }

    vector<int> spiralOrder(vector<vector<int>> &matrix) {
        vector<int> res;
        if (matrix.size() == 0) {
            return res;
        }
        pair<int, int> i(0, matrix.size());
        pair<int, int> j(0, matrix[0].size());

        int len = 0;
        int max = i.second * j.second;
        if (max == 0) {
            return res;
        }
        //  int step = 1;
        bool horizontal = true;

        pair<int, int> cur_i = i;
        pair<int, int> cur_j = j;
        while (len < max) {
            if (!isVisited(cur_i.first, cur_j.first)) {
                len++;
                res.push_back(matrix[cur_i.first][cur_j.first]);
                visited.insert(getCacheKey(cur_i.first, cur_j.first));

            } else {

                if (horizontal) {

                    if (!isVisited(cur_i.first, cur_j.first + 1) && (cur_j.first + 1) < cur_j.second) {
                        cur_j.first++;
                        continue;
                    }
                    if (!isVisited(cur_i.first, cur_j.first - 1) && (cur_j.first - 1) >= 0) {
                        cur_j.first--;
                        continue;
                    }
                    horizontal = false;
                }
                if (!isVisited(cur_i.first + 1, cur_j.first) && (cur_i.first + 1) < cur_i.second) {
                    cur_i.first++;
                    continue;
                }
                if (!isVisited(cur_i.first - 1, cur_j.first) && (cur_i.first - 1) >= 0) {
                    cur_i.first--;
                    continue;
                }
                horizontal = true;
            }
        }
        return res;
    }
};

int main() {
    vector<vector<int>> matrix = {{1, 2, 3},
                                  {4, 5, 6},
                                  {7, 8, 9}};
    Solution solution;
    vector<int> res = solution.spiralOrder(matrix);
    for (int i = 0; i < res.size(); ++i) {
        cout << res[i] << " ";
    }
    return 0;
}