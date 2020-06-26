package leet_code

import edu.princeton.cs.algs4.In
import kotlin.math.abs

class Solution_1030 {
    fun allCellsDistOrder(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray> {
        var temp = ArrayList<DataBean>()
        for (i in 0 until R) {
            for (j in 0 until C) {
                temp.add(DataBean(abs(i - r0) + abs(j - c0), i, j))
            }
        }
        temp.sortWith(Comparator<DataBean> { o1, o2 -> o1.dis - o2.dis })
        var res: Array<IntArray> = Array(temp.size) { IntArray(2) }
        for (i in temp.indices) {
            res[i] = intArrayOf(temp[i].rIndex, temp[i].cIndex)
        }
        return res
    }

    data class DataBean(var dis: Int, var rIndex: Int, var cIndex: Int)
}

