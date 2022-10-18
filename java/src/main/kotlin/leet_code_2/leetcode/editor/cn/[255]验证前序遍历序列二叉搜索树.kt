//给定一个 无重复元素 的整数数组 preorder ， 如果它是以二叉搜索树的先序遍历排列 ，返回 true 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: preorder = [5,2,1,3,6]
//输出: true 
//
// 示例 2： 
//
// 
//输入: preorder = [5,2,6,1,3]
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 10⁴ 
// 1 <= preorder[i] <= 10⁴ 
// preorder 中 无重复元素 
// 
//
// 
//
// 进阶：您能否使用恒定的空间复杂度来完成此题？ 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 137 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    internal class Node(var data: Int) {
        var leftNode: Node? = null
        var rightNode: Node? = null
    }

    private fun checkRepeat(list: List<Int>): Boolean {
        val set: HashSet<Int> = HashSet<Int>()
        for (item in list) {
            if (set.contains(item)) {
                return false
            }
            set.add(item)
        }
        return true
    }

    fun verifyPreorder(preorder: IntArray): Boolean {
        if (preorder.size <= 1) {
            return true
        }
        val mid = preorder.sorted().toIntArray()
        val tree = buildTree(0,mid, preorder)
        var preList = ArrayList<Int>()
        var midList = ArrayList<Int>()
        scanTree(tree, preList, midList)
        for (i in preList.indices) {
            if (preList[i] != preorder[i]) {
                println("preList not match")
                return false
            }
        }

        for (i in midList.indices) {
            if (midList[i] != mid[i]) {
                println("midList not match ${i} ${midList[i]} ${mid[i]}")
                return false
            }
        }
        println("=>${checkRepeat(preorder.toList())} ${checkRepeat(midList.toList())}  ${checkRepeat(preList.toList())}")
        return true
    }

    private fun scanTree(tree: Node?, preList: ArrayList<Int>, midList: ArrayList<Int>) {
        if (tree == null) {
            return
        }
        preList.add(tree.data)
        scanTree(tree.leftNode, preList, midList)
        midList.add(tree.data)
        scanTree(tree.rightNode, preList, midList)
    }

    private fun buildTree(rootIndex: Int, mid: IntArray, preorder: IntArray): Node? {

        if (mid.size == 1) {
            return Node(mid[0])
        }
        if (rootIndex >= preorder.size) {
            return null
        }

        val rootNode = Node(preorder[rootIndex])
        var midIndex = -1
        for (i in mid.indices) {
            if (preorder[rootIndex] == mid[i]) {
                midIndex = i
                break
            }
        }
        if (midIndex == -1) {
            return null
        }
        // println("${midIndex}")
        val left = mid.sliceArray(0 until midIndex)
        val right = mid.sliceArray(midIndex + 1 until mid.size)
        rootNode.leftNode = buildTree(rootIndex + 1, left, preorder)
        rootNode.rightNode = buildTree(rootIndex + 1, right, preorder)
        return rootNode
    }
}
//leetcode submit region end(Prohibit modification and deletion)

fun main() {
    val test = Solution()
    println("hello")
    // val res = test.verifyPreorder(intArrayOf(5, 2, 6, 1, 3))
    val res = test.verifyPreorder(intArrayOf(5, 2, 1, 3, 6))
    //val res = test.verifyPreorder(intArrayOf(2, 3, 1))
    // val res = test.verifyPreorder(intArrayOf(2, 1, 3, 4))
    // val res = test.verifyPreorder(intArrayOf(3, 4, 1, 2))
    println(res)
}