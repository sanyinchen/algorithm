package leet_code

/**
 * Created by sanyinchen on 19-10-28.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-28
 */
class Decode_ways_91 {

    var number: Int = 0;

    fun numDecodingsHelper(nums: CharArray, end: Int) {

        if (end < 0) {
            number++
            return
        }
        // println("=>" + end)
        var cur = nums[end];
        var second = cur - '0';
        if (second != 0) {
            numDecodingsHelper(nums, end - 1);
        }
        if (end - 1 >= 0) {
            var pre = nums[end - 1];
            var first = pre - '0';
            if ((first != 0) && (first * 10 + second <= 26)) {
                numDecodingsHelper(nums, end - 2);
            }
        }
    }

    fun numDecodings(s: String): Int {

        number = 0;

        numDecodingsHelper(s.toCharArray(), s.length - 1);

        return number;
    }

}

fun main() {

    var test = Decode_ways_91();
    println(test.numDecodings("0"));

}