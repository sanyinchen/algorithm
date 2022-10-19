//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 1825 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_78 {
    var allList = mutableListOf<List<Int>>()

    fun subsetsHelper(start: Int, nums: IntArray): List<Int> {
        if (start >= nums.size) {
            return emptyList()
        }
        val temp: MutableList<Int> = ArrayList<Int>()
        for (i in start until nums.size) {
            temp.add(nums[i])
            val res = subsetsHelper(start + 1, nums)
            allList.add(res)
        }
        return temp
    }

    fun subsets(nums: IntArray): List<List<Int>> {
        allList.add(subsetsHelper(0, nums))
        return allList
    }
}
//leetcode submit region end(Prohibit modification and deletion)

fun main() {
    val test = Solution_78()
    println(test.subsets(intArrayOf(1, 2, 3)))
}