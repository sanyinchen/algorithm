//爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
//
// 最初，黑板上有一个数字 n 。在每个玩家的回合，玩家需要执行以下操作： 
//
// 
// 选出任一 x，满足 0 < x < n 且 n % x == 0 。 
// 用 n - x 替换黑板上的数字 n 。 
// 
//
// 如果玩家无法执行这些操作，就会输掉游戏。 
//
// 只有在爱丽丝在游戏中取得胜利时才返回 true 。假设两个玩家都以最佳状态参与游戏。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：true
//解释：爱丽丝选择 1，鲍勃无法进行操作。
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：false
//解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
//
// Related Topics 脑筋急转弯 数学 动态规划 博弈 👍 439 👎 0

// 2025-07-30 09:10:02	获取当前时间
# include <common.h>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    bool divisorGame(int n) {
        unordered_map<int, bool> memo;

        function<bool(int)> dfs = [&](int x) -> bool {
            if (memo.count(x)) return memo[x];
            for (int i = 1; i < x; ++i) {
                if (x % i == 0) {
                    if (!dfs(x - i)) {
                        return memo[x] = true; // 对手输 → 我赢
                    }
                }
            }
            return memo[x] = false; // 所有情况对手都赢 → 我输
        };

        return dfs(n);
    }
};

//leetcode submit region end(Prohibit modification and deletion)
// int main() {
//     Solution solution;
//     cout << solution.divisorGame(2) << endl;
//     return 0;
// }
