//
// Created by sanyinchen on 2025/7/24.
//
#include <vector>
#include <iostream>
#include <unordered_map>
#include <string>
#include <deque>
#include <tuple>
#include <unordered_set>
using namespace std;

#include <common.h>
#include <unordered_map>
#include <string>
#include <vector>
#include <memory>

using namespace std;

struct TrieNode {
    unordered_map<char, shared_ptr<TrieNode> > children;
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
    void insert(const string &word) {
        auto node = root;
        for (char c: word) {
            if (!node->children.count(c)) {
                node->children[c] = make_shared<TrieNode>();
            }
            node = node->children[c];
            node->count++;
        }
        node->isWord = true;
    }

    // 获取 word 的最短唯一前缀
    string getUniquePrefix(const string &word) {
        auto node = root;
        string prefix;
        for (char c: word) {
            node = node->children[c];
            prefix += c;
            if (node->count == 1) break;
        }
        return prefix;
    }
};

class Solution {
public:
    static string makeAbbr(const string &word, int prefixLen) {
        if (word.size() - prefixLen <= 2) return word;
        int num = word.size() - prefixLen - 1;
        return word.substr(0, prefixLen) + to_string(num) + word.back();
    }

    vector<string> wordsAbbreviation(vector<string> &words) {
        int n = words.size();
        vector<string> res(n);
        vector<int> prefixLens(n, 1); // 每个词的前缀初始为1

        do {
            unordered_map<string, vector<int> > abbrGroups;

            // 生成当前缩写，并分组
            for (int i = 0; i < n; ++i) {
                res[i] = makeAbbr(words[i], prefixLens[i]);
                abbrGroups[res[i]].push_back(i);
            }

            bool conflict = false;

            for (const auto &[abbr, idxList]: abbrGroups) {
                if (idxList.size() <= 1) continue;

                // 冲突：用 Trie 找出唯一前缀长度
                conflict = true;
                Trie trie;
                for (int idx: idxList) {
                    trie.insert(words[idx]);
                }
                for (int idx: idxList) {
                    string prefix = trie.getUniquePrefix(words[idx]);
                    prefixLens[idx] = prefix.length(); // 增加 prefix 长度
                }
            }

            if (!conflict) break; // 所有缩写都唯一了
        } while (true) ;

        // 最后再判断长度是否缩短，不缩短就保留原词
        for (int i = 0; i < n; ++i) {
            if (res[i].length() >= words[i].length()) {
                res[i] = words[i];
            }
        }

        return res;
    }
};


int main() {
    vector<string> words = {
        "like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"
    };
    Solution s;
    vector<string> res = s.wordsAbbreviation(words);
    for (auto &w: res) cout << w << endl;
    return 0;
}
