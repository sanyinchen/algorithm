//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅由小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
//
// Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 👍 2794 👎 0

# include<common.h>
//leetcode submit region begin(Prohibit modification and deletion)


struct TrieNode {
    unordered_map<char, shared_ptr<TrieNode>> children;
    int count = 0;
    bool isWord = false;
};

class Trie {
public:
    shared_ptr<TrieNode> root;

    Trie() {
        root = make_shared<TrieNode>();
    }

    // 插入一个单词
    void insert(const string& word) {
        auto node = root;
        for (char c : word) {
            if (!node->children.count(c)) {
                node->children[c] = make_shared<TrieNode>();
            }
            node = node->children[c];
            node->count++;
        }
        node->isWord = true;
    }
};


class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        Trie trie;
        for (const string& word : wordDict) {
            trie.insert(word);
        }
        unordered_map<int, bool> memo;

        function<bool(int)> dfs = [&](int start) -> bool {
            if (start == s.size()) return true;
            if (memo.count(start)) return memo[start];

            auto node = trie.root;
            for (int end = start; end < s.size(); ++end) {
                char c = s[end];
                if (!node->children.count(c)) break;
                node = node->children[c];
                if (node->isWord) {
                    if (dfs(end + 1)) {
                        return memo[start] = true;
                    }
                }
            }
            return memo[start] = false;
        };
        return dfs(0);
    }
};

//leetcode submit region end(Prohibit modification and deletion)
// int main() {
//     Solution solution;
//     vector<string> words = {"leet", "code"};
//     cout << solution.wordBreak("catsandog", words);
// }
