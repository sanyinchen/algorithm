package leet_code

/**
 * Created by sanyinchen on 19-11-15.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-11-15
 */
class Subsets_78 {

    var itemList = mutableListOf<Int>()
    var allList = mutableListOf<List<Int>>()


    fun subsetsHelper(start: Int, nums: IntArray) {
        if (start > nums.size) {
            return
        }
        allList.add(itemList.toMutableList())
        for (i in start until nums.size) {
            itemList.add(nums[i])
            subsetsHelper(start + 1, nums)
            itemList.removeAt(itemList.size - 1)
        }
    }

    fun subsets(nums: IntArray): List<List<Int>> {
        if (nums.isEmpty()) {
            return emptyList()
        }
        itemList.clear()
        allList.clear()
        subsetsHelper(0, nums)
        return allList
    }
}

fun main() {
    Subsets_78().subsets(intArrayOf(1, 2, 3)).forEach {
        println(it)
    }
}