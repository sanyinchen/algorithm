//
// Created by sanyinchen on 2020/4/8.
//
#include <iostream>

using namespace std;

class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        int magazines['z' + 1] = {};
        for (int i = 0; i < magazine.size(); i++) {
            magazines[magazine[i]]++;
        }
        for (int i = 0; i < ransomNote.size(); i++) {
            int key = ransomNote[i];
            if (magazines[key] <= 0) {
                return false;
            }
            magazines[key]--;
        }
        return true;
    }
};