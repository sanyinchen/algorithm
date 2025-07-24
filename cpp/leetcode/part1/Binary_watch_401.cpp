//
// Created by sanyinchen on 2020/4/10.
//
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution {
public:
    string getHour(vector<int> hours) {
        int hour = 8 * hours[3] + 4 * hours[2] + 2 * hours[1] + hours[0];
        if (hour >= 12) {
            return "";
        }
        return to_string(hour);
    }

    string getMinutes(vector<int> minutes) {
        int res = 32 * minutes[5] + 16 * minutes[4] + 8 * minutes[3] + 4 * minutes[2] + 2 * minutes[1] + minutes[0];
        if (res >= 60) {
            return "";
        }
        if (res < 10) {
            return "0" + to_string(res);
        } else {
            return to_string(res);
        }
    }

    vector<string> readBinaryWatchHelper(int hNumber, int mNumber) {
        vector<string> res;

        int hours[4] = {0};
        int minutes[6] = {0};
        for (int i = 0; i < hNumber; i++) {
            hours[i] = 1;
        }
        vector<vector<int >> hours_vector;
        sort(hours, hours + 4);
        do {
            vector<int> temp;
            temp.reserve(4);
            for (int i = 0; i < 4; i++) {
                temp.push_back(hours[i]);
            }
            hours_vector.push_back(temp);

        } while (next_permutation(hours, hours + 4));


        for (int i = 0; i < mNumber; i++) {
            minutes[i] = 1;
        }
        vector<vector<int >> minutes_vector;
        sort(minutes, minutes + 6);
        do {
            vector<int> temp;
            temp.reserve(6);
            for (int i = 0; i < 6; i++) {
                temp.push_back(minutes[i]);
            }
            minutes_vector.push_back(temp);

        } while (next_permutation(minutes, minutes + 6));

        for (int i = 0; i < hours_vector.size(); ++i) {
            vector<int> hour = hours_vector[i];
            for (int j = minutes_vector.size() - 1; j >= 0; j--) {
                vector<int> minute = minutes_vector[j];
                string hour_str = getHour(hour);
                string minute_str = getMinutes(minute);
                if (hour_str == "" || minute_str == "") {
                    continue;
                }
                res.push_back(hour_str + ":" + minute_str);
            }
        }
        return res;
    }

    vector<string> readBinaryWatch(int num) {

        vector<string> res;
        if (num == 0) {
            res.push_back("0:00");
            return res;
        }
        for (int i = 0; i <= num; i++) {
            int hour = i;
            int minute = num - i;
            if (hour > 4 || minute > 6) {
                continue;
            }
            vector<string> temp = readBinaryWatchHelper(hour, minute);
            res.insert(res.end(), temp.begin(), temp.end());
        }
        sort(res.begin(), res.end());

        return res;
    }
};

int main() {
    Solution solution;
    vector<string> res = solution.readBinaryWatch(5);
    for (int i = 0; i < res.size(); ++i) {
        cout << res[i] << endl;
    }
    return 0;
}