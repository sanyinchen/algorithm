//
// Created by sanyinchen on 2020/4/8.
//
#include <iostream>
#include <map>
#include <vector>

using namespace std;

class Solution {
public:
    bool wordPattern(std::string pattern, std::string str) {
        map<char, string> keys;
        map<string, char> r_keys;
        vector<string> values;
        for (int i = 0; i < str.size(); ++i) {
            string item;
            while (i < str.size() && str[i] != ' ') {
                item += str[i];
                i++;
            }
            if (!item.empty() && item != " ") {
                values.push_back(item);
            }
        }
        if (pattern.size() != values.size()) {
            return false;
        }
        for (int i = 0; i < pattern.size(); i++) {
            char key = pattern[i];
            string value = values[i];
            if (keys.count(key)) {
                string getV = keys.at(key);
                if (getV != value) {
                    return false;
                }
            } else {
                keys.insert(make_pair(key, value));
            }
        }
        for (int i = 0; i < pattern.size(); i++) {
            char value = pattern[i];
            string key = values[i];
            if (r_keys.count(key)) {
                char getV = r_keys.at(key);
                if (getV != value) {
                    return false;
                }
            } else {
                r_keys.insert(make_pair(key, value));
            }
        }
        return true;
    }
};