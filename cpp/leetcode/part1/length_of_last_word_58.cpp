//
// Created by sanyinchen on 2020/3/24.
//

#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:

    int lengthOfLastWord(const string &text) {
        int sum = 0;
        int pre = sum;
        for (unsigned long i = 0; i < text.size(); i++) {
            char item = text[i];
            if (item == ' ') {
                if (sum != 0) {
                    pre = sum;
                }
                sum = 0;
            } else {
                sum++;
            }
        }
        if (sum != 0) {
            pre = sum;
        }
        return pre;
    }


};

int main() {

    return 0;
}
