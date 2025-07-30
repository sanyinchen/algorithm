//给定一个字符串 s 和一个字符串字典
// wordDict ，在字符串
// s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。 
//
// 注意：词典中的同一个单词可能在分段中被重复使用多次。 
//
// 
//
// 示例 1： 
//
// 
//输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
//输出:["cats and dog","cat sand dog"]
// 
//
// 示例 2： 
//
// 
//输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine",
//"pineapple"]
//输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
//解释: 注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//输出:[]
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 20 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 10 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中所有字符串都 不同 
// 
//
// Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 回溯 👍 792 👎 0

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
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        Trie trie;
        for (const string& word : wordDict) {
            trie.insert(word);
        }
        unordered_map<int, vector<string>> memo;

        function<vector<string>(int)> dfs = [&](int start) -> vector<string> {
            if (memo.count(start)) {
                //cout << "cache" << " " << start << endl;
                return memo[start];
            }
            vector<string> result;

            if (start == s.size()) {
                result.push_back("");
                return result;
            }

            auto node = trie.root;
            string word;

            for (int end = start; end < s.size(); ++end) {
                char c = s[end];
                word += c;
                if (!node->children.count(c)) break;
                node = node->children[c];

                if (node->isWord) {
                    vector<string> subsentences = dfs(end + 1);
                    for (const string& sub : subsentences) {
                        if (sub.empty())
                            result.emplace_back(word);
                        else
                            result.emplace_back(word + " " + sub);
                    }
                }
            }

            return memo[start] = result;
        };
        return dfs(0);
    }
};

//leetcode submit region end(Prohibit modification and deletion)
int main() {
    Solution solution;
    string str = "catsanddog";
    vector<string> words = {"cat", "cats", "and", "sand", "dog"};
    for (const string& word : solution.wordBreak(str, words)) {
        cout << word << endl;
    }
    return 0;
}
