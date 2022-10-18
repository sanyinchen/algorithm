package leet_code

import leet_code.common.ListNode
import java.util.*
import kotlin.collections.ArrayList

class Palindrome_linked_list_02_06 {


    fun isPalindrome(head: ListNode?): Boolean {
        return isPalindromeExtra(head, ArrayDeque())
    }

    private fun isPalindromeExtra(head: ListNode?, list: Deque<Int>): Boolean {
        if (head == null) {
            return true
        }
        list.add(head.`val`)
        if (!isPalindromeExtra(head.next, list)) {
            return false
        }
        println("==========")
        list.forEach {
            println(it)
        }
        return list.pollFirst() == head.`val`
    }
}

fun main() {
    println("hello")
    val listNode = ListNode(1)
    listNode.next = ListNode(2)
    listNode.next.next = ListNode(2)
    listNode.next.next.next = ListNode(1)
    println(Palindrome_linked_list_02_06().isPalindrome(listNode))
}