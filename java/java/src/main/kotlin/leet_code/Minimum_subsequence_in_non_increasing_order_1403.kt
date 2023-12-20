package leet_code

import edu.princeton.cs.algs4.In

class Solution_1403 {
    fun minSubsequence(nums: IntArray): List<Int> {
        nums.sort()
        for (step in 0 until nums.size) {
            if (getSubSum(nums, nums.size - 1 - step, nums.size - 1) > getSubSum(nums, 0, nums.size - 1 - step - 1)) {
                return getSub(nums, nums.size - 1 - step, nums.size - 1)
            }
        }
        return emptyList()
    }

    fun getSub(nums: IntArray, start: Int, end: Int): List<Int> {
        var list = ArrayList<Int>()
        for (i in start..end) {
            list.add(nums[i])
        }
        list.sort()
        return list.reversed()
    }

    fun getSubSum(nums: IntArray, start: Int, end: Int): Int {
        var sum = 0
        for (i in start..end) {
            sum += nums[i]
        }
        return sum
    }

}

fun main() {
    val test = Solution_1403()
    test.minSubsequence(intArrayOf(4, 4, 7, 6, 7)).forEach {
        print("$it ")
    }
}