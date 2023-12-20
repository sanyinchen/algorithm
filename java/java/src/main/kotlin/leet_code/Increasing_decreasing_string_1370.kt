package leet_code

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

class Solution_1370 {
    fun sortString(s: String): String {
        var chars = s.toCharArray()
        Arrays.sort(chars)
        var lists = ArrayList<Deque<Char>>()
        for (item in chars) {
            var hasAdded = false
            for (i in lists.indices) {
                var deque = lists[i]
                if (deque.peekLast() == item) {
                    continue
                }
                deque.addLast(item)
                hasAdded = true
                break
            }
            if (!hasAdded) {
                var newDeque = ArrayDeque<Char>()
                newDeque.addFirst(item)
                lists.add(newDeque)

            }
        }
        var stringBuilder = StringBuilder()
        var back = false;
        lists.forEach {
            while (!it.isEmpty()) {
                stringBuilder.append(if (back) it.pollLast() else it.pollFirst())
            }
            back = !back
        }
        return stringBuilder.toString()
    }
}

fun main() {
    val test = Solution_1370()
    println(test.sortString("aaaabbbbcccc"))
}