//3274-check-if-two-chessboard-squares-have-the-same-color


//给你两个字符串 coordinate1 和 coordinate2，代表 8 x 8 国际象棋棋盘上的两个方格的坐标。 
//
// 以下是棋盘的参考图。 
//
// 
//
// 如果这两个方格颜色相同，返回 true，否则返回 false。 
//
// 坐标总是表示有效的棋盘方格。坐标的格式总是先字母（表示列），再数字（表示行）。 
//
// 
//
// 示例 1： 
//
// 
// 输入： coordinate1 = "a1", coordinate2 = "c3" 
// 
//
// 输出： true 
//
// 解释： 
//
// 两个方格均为黑色。 
//
// 示例 2： 
//
// 
// 输入： coordinate1 = "a1", coordinate2 = "h3" 
// 
//
// 输出： false 
//
// 解释： 
//
// 方格 "a1" 是黑色，而 "h3" 是白色。 
//
// 
//
// 提示： 
//
// 
// coordinate1.length == coordinate2.length == 2 
// 'a' <= coordinate1[0], coordinate2[0] <= 'h' 
// '1' <= coordinate1[1], coordinate2[1] <= '8' 
// 
//
// Related Topics 数学 字符串 👍 23 👎 0


#include"../../comm.h"

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
private:
    static array<array<int, 8>, 8> board; // 静态成员变量声明
public:
    bool checkTwoChessboards(string coordinate1, string coordinate2) {
           return board[coordinate1[0]-'a'][coordinate1[1]-'1']==board[coordinate2[0]-'a'][coordinate2[1]-'1'];
    }
};
array<array<int, 8>, 8> Solution::board = [] {
    array<array<int, 8>, 8> tempBoard{};
    for (int i = 0; i < 8; ++i) {
        for (int j = 0; j < 8; ++j) {
            tempBoard[i][j] = (i + j) % 2; // 黑白格初始化
        }
    }
    return tempBoard;
}();
//leetcode submit region end(Prohibit modification and deletion)

int main() {
    Solution s;
    cout<<s.checkTwoChessboards("a1","c3");
}