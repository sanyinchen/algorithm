package leet_code;


/**
 * Created by sanyinchen on 19-10-12.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-12
 */

class Solution {

    fun move2End(nums: IntArray, i: Int) {
        if (i >= nums.size) {
            return
        }
        var temp = nums[i];
        for (index in IntRange(i, nums.size - 2)) {
            nums[index] = nums[index + 1];
        }
        nums[nums.size - 1] = temp;
    }

    fun removeDuplicates(nums: IntArray): Int {
        var len = nums.size;
        var i = 0;
        while (i <= len - 2) {
            if (nums[i] == nums[i + 1]) {
                len--;
                move2End(nums, i + 1);
            } else {
                i++;
            }

        }
        return len;
    }

}


fun main(args: Array<String>) {

    var s = Solution();
    val numbers: IntArray = intArrayOf(0, 0);
    println("hello===>" + numbers.size)
    var len = s.removeDuplicates(numbers);
    for (i in IntRange(0, len - 1)) {
        print("${numbers[i]} ")
    }
}