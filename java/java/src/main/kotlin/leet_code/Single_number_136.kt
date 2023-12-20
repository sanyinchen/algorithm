package leet_code

/**
 * Created by sanyinchen on 19-10-12.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-12
 */
class Single_number_136 {
    fun singleNumber(nums: IntArray): Int {
        var map = HashMap<Int, Int>();
        nums.forEach {
            if (map.containsKey(it)) {
                var number = map.get(it)!!;
                number++;
                map.replace(it, number);

            } else {
                map.put(it, 1)
            }
        }

        for ((key, v) in map) {
            if (v == 1) {
                return key
            }
        }
        return -1
    }
}

fun main() {
    var test = Single_number_136();
    print("${test.singleNumber(intArrayOf(2, 2, 1))}")
}