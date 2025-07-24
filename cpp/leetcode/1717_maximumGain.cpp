#include <iostream>
#include <unordered_map>
#include <string>
#include <functional>
using namespace std;

class Solution {
    static bool remove_first_sub_str(string &str, const string &target, size_t &pos) {
        pos = str.find(target);
        if (pos != string::npos) {
            str.erase(pos, target.length());
            return true;
        }
        return false;
    }

public:
    int maximumGain(string s, int x, int y) {
        string ab = "ab", ba = "ba";
        unordered_map<size_t, int> memo;
        hash<string> hasher;

        function<int(string&)> func = [&](string &str) -> int {
            size_t h = hasher(str);
            if (memo.count(h)) return memo[h];

            int max_val = 0;
            size_t pos;

            if (x >= y) {
                if (remove_first_sub_str(str, ab, pos)) {
                    int v = x + func(str); // str 已经被修改
                    str.insert(pos, ab);   // 回溯：恢复原状态
                    max_val = max(max_val, v);
                }
                if (remove_first_sub_str(str, ba, pos)) {
                    int v = y + func(str);
                    str.insert(pos, ba);
                    max_val = max(max_val, v);
                }
            } else {
                if (remove_first_sub_str(str, ba, pos)) {
                    int v = y + func(str);
                    str.insert(pos, ba);
                    max_val = max(max_val, v);
                }
                if (remove_first_sub_str(str, ab, pos)) {
                    int v = x + func(str);
                    str.insert(pos, ab);
                    max_val = max(max_val, v);
                }
            }

            return memo[h] = max_val;
        };

        return func(s);
    }
};

int main() {
    Solution solution;
    cout << solution.maximumGain("cdbcbbaaabab", 4, 5) << endl;  // 输出：19
    return 0;
}
