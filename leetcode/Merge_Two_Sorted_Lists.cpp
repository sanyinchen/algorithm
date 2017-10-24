//
// Created by sanyinchen on 17/4/25.
//https://leetcode.com/problems/merge-two-sorted-lists/#/description
//

#include <iostream>

using namespace std;


struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(nullptr) {}
};

void _print(ListNode *first) {

    while (first != nullptr) {
        cout << first->val << " ";
        first = first->next;
    }
    cout << endl;

}

ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {

    ListNode *res = new ListNode(-1);

    ListNode *resTemp = res;


    while (l1 != nullptr && l2 != nullptr) {
        ListNode *temp = new ListNode(-1);
        if (l1->val <= l2->val) {
            temp->val = l1->val;
            l1 = l1->next;
        } else {
            temp->val = l2->val;
            l2 = l2->next;
        }
        resTemp->next = temp;
        resTemp = temp;
    }
    if (l1 != nullptr) {
        resTemp->next = l1;
    }
    if (l2 != nullptr) {
        resTemp->next = l2;
    }
    res = res->next;

    return res;
}

int main() {
    int a[] = {2, 3, 3};
    int b[] = {1, 3, 4};


    ListNode *first = new ListNode(a[0]);
    ListNode *firstTemp = first;

    ListNode *second = new ListNode(b[0]);
    ListNode *secondTemp = second;

    for (int i = 1; i < 3; i++) {
        ListNode *temp = new ListNode(a[i]);
        firstTemp->next = temp;
        firstTemp = temp;
    }
    for (int i = 1; i < 3; i++) {
        ListNode *temp = new ListNode(b[i]);
        secondTemp->next = temp;
        secondTemp = temp;
    }
    _print(mergeTwoLists(first, second));
    return 0;
}
