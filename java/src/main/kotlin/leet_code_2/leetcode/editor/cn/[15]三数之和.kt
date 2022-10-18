//////////给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有
//和为
//// 0
////// 且
////////不重
//////////复的三元组。 
//////////
////////// 注意：答案中不可以包含重复的三元组。 
//////////
////////// 
//////////
////////// 示例 1： 
//////////
////////// 
//////////输入：nums = [-1,0,1,2,-1,-4]
//////////输出：[[-1,-1,2],[-1,0,1]]
////////// 
//////////
////////// 示例 2： 
//////////
////////// 
//////////输入：nums = []
//////////输出：[]
////////// 
//////////
////////// 示例 3： 
//////////
////////// 
//////////输入：nums = [0]
//////////输出：[]
////////// 
//////////
////////// 
//////////
////////// 提示： 
//////////
////////// 
////////// 0 <= nums.length <= 3000 
////////// -10⁵ <= nums[i] <= 10⁵ 
////////// 
////////// Related Topics 数组 双指针 排序 👍 4376 👎 0
////////
//////
////
//


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size <= 2) {
            return emptyList()
        }
        nums.sort()
        val set: MutableMap<Int, Int> = HashMap<Int, Int>()
        nums.forEach {
            if (set.containsKey(it)) {
                set[it] = (set[it]!! + 1)
            } else {
                set[it] = 1
            }
        }
        return threeSumExtra(nums, 0, ArrayList<List<Int>>(), set, HashSet<String>())
    }

    private fun addToSum(sum: MutableList<List<Int>>, arrayList: MutableList<Int>, sumSet: MutableSet<String>) {
        var tempSetItem = "${arrayList[0]}_${arrayList[1]}_${arrayList[2]}"
        if (sumSet.contains(tempSetItem)) {
            return
        }
        sum.add(arrayList)
        sumSet.add(tempSetItem)
    }

    private fun threeSumExtra(nums: IntArray, i: Int, sum: MutableList<List<Int>>, set: MutableMap<Int, Int>, sumSet: MutableSet<String>)
            : List<List<Int>> {
        if (i >= nums.size - 2) {
            return sum
        }
        var j = i + 1;
        val cur = nums[i]
        while (j < nums.size - 1) {
            var second = nums[j]
            var temp = 0 - (second + cur)
            var list: MutableList<Int> = ArrayList()
            list.add(cur)
            list.add(second)
            list.add(temp)
            list.sort()
            if (set.containsKey(temp)) {
                var tempIndexSum: Int = set[temp]!!
                if (temp == cur) {
                    tempIndexSum--
                }
                if (temp == second) {
                    tempIndexSum--
                }
                if (tempIndexSum > 0) {
                    addToSum(sum, list, sumSet)
                }
            }
            j++
        }
        return threeSumExtra(nums, i + 1, sum, set, sumSet)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

fun main() {
    val test = Solution_15()
    println("hello")
    test.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)).forEach {
        println("\n====")
        it.forEach {
            print("$it ")
        }
    }
}