//
// Created by sanyinchen on 7/26/25.
//
struct pair_hash {
    size_t operator()(const pair<int, int>& p) const {
        return hash<int>()(p.first) ^ (hash<int>()(p.second) << 1);
    }
};
unordered_map<pair<int, int>, int, pair_hash> memo;