//
// Created by sanyinchen on 2020/4/8.
//
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    string getHint(string secret, string guess) {
        int secrets[10] = {};
        int guesses[10] = {};
        int b_number = 0;
        int a_number = 0;
        for (int i = 0; i < secret.size(); i++) {
            secrets[secret[i] - '0']++;
            guesses[guess[i] - '0']++;
            if (secret[i] == guess[i]) {
                a_number++;
            }
        }
        b_number -= a_number;
        for (int j = 0; j < 10; ++j) {
            int s_number = secrets[j];
            int g_number = guesses[j];
            if (s_number <= g_number) {
                b_number += s_number;
            } else {
                b_number += g_number;
            }
        }
        return to_string(a_number)+"A"+to_string(b_number)+"B";
    }
};