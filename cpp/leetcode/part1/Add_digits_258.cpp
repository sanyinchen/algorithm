
#include <iostream>

using namespace std;

class Solution {
public:
    int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int temp = 0;
        while (num > 0) {
            temp += num % 10;
            num /= 10;
        }
        return addDigits(temp);
    }
};