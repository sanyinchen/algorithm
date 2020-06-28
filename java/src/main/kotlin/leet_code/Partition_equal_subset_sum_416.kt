package leet_code

// todo
class Solution_416 {
    fun canPartition(nums: IntArray): Boolean {
        val dp = Array(nums.size) { IntArray(nums.size) }
        // nums.sort()
        val sum = nums.sum()
//        for (i in 0 until nums.size) {
//            dp[i][0] = nums[i]
//        }
        for (i in 0 until nums.size) {
            for (j in i until nums.size) {
                if (i == j) {
                    dp[i][j] = nums[j]
                } else {
                    dp[i][j] = dp[i][j - 1] + nums[j]
                }

            }
        }
        dp.forEach {
            it.forEach { sub ->
                print("$sub ")
            }
            println()
        }

        for (i in 0 until nums.size) {
            for (j in 1 until nums.size) {
                if (sum - dp[i][j] == dp[i][j]) {
                    return true
                }
            }
        }
        return false;
    }
}

fun main() {
    val test = Solution_416();
    // print(test.canPartition(intArrayOf(23, 13, 11, 7, 6, 5, 5)))
    print(test.canPartition(intArrayOf(1, 2, 3)))
}