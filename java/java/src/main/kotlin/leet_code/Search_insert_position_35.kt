package leet_code

/**
 * Created by sanyinchen on 19-10-29.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-29
 */
class Search_insert_position_35 {

    fun getIndex(nums: IntArray, target: Int): Int {
        for (i in nums.indices) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    fun searchInsert(nums: IntArray, target: Int): Int {
        var index = getIndex(nums, target);
        if (index == -1) {
            for (i in nums.indices) {
                if (nums[i] >= target) {
                    return i;
                }
            }
            return nums.size
        }

        return index
    }
}

fun main() {
    println(Search_insert_position_35().searchInsert(intArrayOf(1, 3, 5, 6), 7));
}