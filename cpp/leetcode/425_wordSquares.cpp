//
// Created by sanyinchen on 7/25/25.
//
#include <common.h>

struct TrieNode {
    unordered_map<char, shared_ptr<TrieNode>> children;
    vector<string> startsWith; // 用于存储以该前缀开头的所有单词
};

class Trie {
public:
    shared_ptr<TrieNode> root;

    Trie() {
        root = make_shared<TrieNode>();
    }

    void insert(const string& word) {
        auto node = root;
        for (char c : word) {
            if (!node->children.count(c)) {
                node->children[c] = make_shared<TrieNode>();
            }
            node = node->children[c];
            node->startsWith.push_back(word);
        }
    }

    vector<string> findByPrefix(const string& prefix) {
        auto node = root;
        for (char c : prefix) {
            if (!node->children.count(c)) return {};
            node = node->children[c];
        }
        return node->startsWith;
    }
};

class Solution {
public:
    vector<vector<string>> res;
    int wordLen = 0;
    Trie trie;

    vector<vector<string>> wordSquares(vector<string>& words) {
        if (words.empty()) return {};
        wordLen = words[0].size();
        for (auto& word : words) {
            trie.insert(word);
        }

        vector<string> path;
        for (auto& word : words) {
            path.push_back(word);
            backtrack(path);
            path.pop_back();
        }

        return res;
    }

    void backtrack(vector<string>& path) {
        if (path.size() == wordLen) {
            res.push_back(path);
            return;
        }

        // 构造当前列的前缀
        string prefix;
        int idx = path.size(); // 第 idx 行时，要拼出第 idx 列的前缀
        for (auto& word : path) {
            prefix += word[idx];
        }

        // 从 Trie 中找到所有匹配该前缀的单词
        for (auto& candidate : trie.findByPrefix(prefix)) {
            path.push_back(candidate);
            backtrack(path);
            path.pop_back();
        }
    }
};
