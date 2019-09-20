package leet_code;

import leet_code.common.ListNode;

public class Delete_node_in_a_linked_list_237 {

    public void deleteNode(ListNode node) {
        int val=node.next.val;
        node.next=node.next.next;
        node.val=val;
    }
}
