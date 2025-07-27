//
// Created by sanyinchen on 7/27/25.
//
#include <common.h>
#include <unordered_map>
#include <unordered_set>
#include <climits>

class Solution {
public:
    int minJumps(vector<int>& nums) {
        std::vector<int> mordelvian = nums;
        const int n = nums.size();


        auto isPrime = [](int x) -> bool {
            if (x <= 1) return false;
            for (int d = 2; d * d <= x; ++d)
                if (x % d == 0) return false;
            return true;
        };



        std::unordered_set<int> prime_values;
        for (int v : nums)
            if (isPrime(v)) prime_values.insert(v);


        std::unordered_map<int, std::vector<int>> prime_to_indices;
        for (int p : prime_values) {
            std::vector<int> vec;
            for (int idx = 0; idx < n; ++idx)
                if (nums[idx] % p == 0) vec.push_back(idx);
            prime_to_indices[p] = std::move(vec);
        }

        std::vector<int> memo(n, -1);
        std::vector<char> in_stack(n, 0);

        std::function<int(int)> min_step = [&](int idx) -> int {
            if (idx == n - 1) return 0;
            if (memo[idx] != -1)  return memo[idx];
            if (in_stack[idx])    return INT_MAX;

            in_stack[idx] = 1;
            int best = INT_MAX;

            // 相邻跳
            for (int nxt : {idx - 1, idx + 1}) {
                if (0 <= nxt && nxt < n) {
                    int t = min_step(nxt);
                    if (t != INT_MAX) best = std::min(best, t + 1);
                }
            }

            // 质数传送
            if (isPrime(nums[idx])) {
                int p = nums[idx];
                for (int j : prime_to_indices[p]) {
                    if (j == idx) continue;
                    int t = min_step(j);
                    if (t != INT_MAX) best = std::min(best, t + 1);
                }
            }

            in_stack[idx] = 0;
            return memo[idx] = best;
        };

        const int ans = min_step(0);
        return ans == INT_MAX ? -1 : ans;
    }
};

int main() {
    Solution s;
    std::vector<int> nums{1, 2, 4, 6};
    std::cout << s.minJumps(nums) << std::endl;    // 正确输出 2
}
