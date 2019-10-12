package leet_code

/**
 * Created by sanyinchen on 19-10-12.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-12
 */


class Move_zeroes_283 {

    fun move2End(nums: IntArray, i: Int, end: Int) {
        if (i >= nums.size) {
            return
        }
        var temp = nums[i];
        for (index in IntRange(i, end - 2)) {
            nums[index] = nums[index + 1];
        }
        nums[end - 1] = temp;
    }

    fun moveZeroes(nums: IntArray): Unit {
        var i = 0
        var len = nums.size;
        while (i < len) {
            if (nums[i] == 0) {
                move2End(nums, i, len);
                len--;
            } else {
                i++;
            }

        }
    }
}

fun main() {
    println("==>")
    var test = Move_zeroes_283();
    var args = intArrayOf(0, 0, 1);
    test.moveZeroes(args)
    args.forEach { println(it) }

}