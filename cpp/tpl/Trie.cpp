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
