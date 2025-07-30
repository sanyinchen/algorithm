#include <algorithm>
#include <cstdio>
#include <functional>
#include <iostream>
#include <unistd.h>
#include <unordered_map>
#include <unordered_set>
#include <vector>
using namespace std;

# define  int  long long

signed main() {
    freopen("niuke_input.txt", "r", stdin);
    int n;
    cin >> n;
    while (n--) {
        int nums_len;
        cin >> nums_len;
        string nums;
        cin >> nums;
        // cout << nums << endl;
        int first = -1;
        int second = -1;
        int third = -1;
        for (int i = 0; i < nums_len; i++) {
            if (nums[i] == '1') {
                if (first == -1) {
                    first = i;
                    continue;
                }
                if (second == -1) {
                    second = i;
                    continue;
                }
                if (third == -1) {
                    third = i;
                }
            }
        }
        if (second - first == third - second) {
            cout << "YES" << endl;
        }
        else {
            cout << "NO" << endl;
        }
        // vector<int> nums(nums_len);
        // for (int i = 0; i < nums_len; i++) {
        //     cin >> nums[i];
        // }
        // for (int i = 0; i < nums_len; i++) {
        //     cout << nums[i] << " ";
        // }
    }
    return 0;
}
