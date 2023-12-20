package leet_code

import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Solution_1086 {
    fun highFive(items: Array<IntArray>): Array<IntArray> {
        val map = HashMap<Int, PriorityQueue<Int>>()
        items.forEach {
            val key = it[0]
            val v: Int = it[1]
            if (map.containsKey(key)) {
                val temp = map[key]!!
                temp.add(v)
                if (temp.size > 5) {
                    temp.remove()
                }
            } else {
                val priorityQueue = PriorityQueue<Int>(Comparator<Int> { o1, o2 -> o1 - o2 })
                priorityQueue.add(v)
                map[key] = priorityQueue
            }
        }
        val res = ArrayList<IntArray>()
        map.forEach {
            var sum = 0;
            var number = it.value.size
            while (!it.value.isEmpty()) {
                sum += it.value.poll()
            }
            val item = intArrayOf(it.key, sum / number)
            res.add(item)
        }
        res.sortWith(Comparator { o1, o2 -> o1[0] - o2[0] })
        return res.toTypedArray()
    }
}

fun main() {
    val test = Solution_1086()
    test.highFive(arrayOf(intArrayOf(1, 91),
            intArrayOf(1, 92),
            intArrayOf(2, 93),
            intArrayOf(2, 97),
            intArrayOf(1, 60),
            intArrayOf(2, 77),
            intArrayOf(1, 65),
            intArrayOf(1, 87),
            intArrayOf(1, 100),
            intArrayOf(2, 100),
            intArrayOf(2, 76))).forEach {
        print("[ ${it[0]} ${it[1]} ]")
    }
}


