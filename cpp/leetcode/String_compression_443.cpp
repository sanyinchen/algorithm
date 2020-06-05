//
// Created by sanyinchen on 2020/6/3.
//
#include <iostream>
#include <map>
#include <set>
#include <vector>


using namespace std;

class Solution {
public:
    int compress(vector<char> &chars) {
        printvector(chars, chars.size());
        map<char, int> cache;
        chars.push_back('0');
        int old_len = chars.size();
        int len = 0;
        int sum = 1;
        for (int i = 1; i < chars.size(); ++i) {
            if (chars[i] == chars[i - 1]) {
                sum++;
            } else {
                chars[len++] = chars[i - 1];
                if (sum == 1) {
                    continue;
                }
                if (sum < 10) {
                    chars[len++] = sum + '0';
                    sum = 1;
                    continue;
                }
                if (sum >= 10) {
                    vector<int> temp = splitInt(sum);
                    for (int j = temp.size() - 1; j >= 0; j--) {
                        chars[len++] = temp[j] + '0';
                    }
                    sum = 1;
                }
            }
        }

        printvector(chars, len);
        return len;
    }

    vector<int> splitInt(int v) {
        vector<int> res;
        if (v < 10) {
            res.push_back(v);
            return res;
        }
        while (v > 0) {
            res.push_back(v % 10);
            v /= 10;
        }
        return res;
    }

    void printvector(vector<char> chars, int len) {
        for (int i = 0; i < len; i++) {
            cout << chars[i] << ' ';
        }
        cout << endl;
    }
};


int main() {
    Solution solution;
    // vector<char> input = {'a'};
    vector<char> input = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a'};
    cout << solution.compress(input);
}