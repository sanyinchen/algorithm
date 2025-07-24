//
// Created by sanyinchen on 17/4/24.
//

#include <iostream>
#include <vector>

using namespace std;


struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(nullptr) {}
};

ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
    int sum = 0;
    vector<int> sa, sb, sr;
    while (l1 != nullptr) {
        sa.push_back(l1->val);
        l1 = l1->next;
    }
    while (l2 != nullptr) {
        sb.push_back(l2->val);
        l2 = l2->next;
    }
    ListNode *res = new ListNode(0);
    ListNode *resTemp = res;
    for (int i = 0, j = 0; i < sa.size() | j < sb.size(); j++, i++) {
        if (i < sa.size() && j < sb.size()) {
            sum += sa[i] + sb[j];
        }
        if (i < sa.size() && j >= sb.size()) {
            sum += sa[i];
        }
        if (i >= sa.size() && j < sb.size()) {
            sum += sb[j];
        }
        ListNode *temp = new ListNode(sum % 10);
        resTemp->next = temp;
        resTemp = temp;
        sum /= 10;
        //cout << "-" << sum << endl;

    }
    if (sum != 0) {

        ListNode *final = new ListNode(sum);
        resTemp->next = final;
    }
    return res->next;
}

void _print(ListNode *first) {

    while (first != nullptr) {
        cout << first->val << " ";
        first = first->next;
    }
    cout << endl;

}

int main() {

    int a[] = {2, 4, 3};
    int b[] = {5, 6, 4};
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

    ListNode *r = addTwoNumbers(first, second);

    _print(r);
//    _print(second);
    return 0;
}