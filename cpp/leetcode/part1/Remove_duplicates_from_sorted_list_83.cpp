//
// Created by sanyinchen on 2020/3/26.
//

#include <iostream>
#include <unordered_set>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {
        using namespace __gnu_cxx;

        unordered_set<int> cache;
        ListNode *headCopy = head;
        while (headCopy != NULL && headCopy->next != NULL) {
            if (headCopy->val == headCopy->next->val) {
                headCopy->next = headCopy->next->next;
            } else {
                headCopy = headCopy->next;

            }
        }

        return head;
    }
};

int main() {
    ListNode one_zero = ListNode(1);
    ListNode one = ListNode(1);
    ListNode two = ListNode(2);
    ListNode *head = &one_zero;
    head->next = &one;
    head->next->next = &two;
//    while (head != NULL) {
//        cout << head->val << endl;
//        head = head->next;
//    }
    Solution solution = Solution();
    ListNode *res = solution.deleteDuplicates(head);
    while (res != NULL) {
        cout << res->val << endl;
        res = res->next;
    }
    return 0;
}

