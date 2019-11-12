package leet_code

import java.util.*
import kotlin.collections.HashMap
import kotlin.math.abs

/**
 * Created by sanyinchen on 19-11-9.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-11-9
 */

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val map = HashMap<Int, Stack<Int>>()

    for (i in nums.indices) {
        if (map.containsKey(nums[i])) {
            if (abs(i - (map[nums[i]]?.peek() ?: Int.MAX_VALUE)) <= k) {
                return true
            }
            map[nums[i]]?.add(i)
        } else {
            map[nums[i]] = Stack()
            map[nums[i]]?.add(i)
        }

    }
    return false
}

fun main() {
    println(containsNearbyDuplicate(intArrayOf(99, 99), 2))
}