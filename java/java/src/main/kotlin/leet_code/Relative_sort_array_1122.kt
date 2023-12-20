package leet_code

class Solution_1122 {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        val cache1 = IntArray(1001)
        val cache2 = IntArray(1001)
        arr1.forEach {
            cache1[it]++
        }
        arr2.forEach {
            cache2[it]++
        }
        val res = ArrayList<Int>()
        for (i in arr2.indices) {
            val item = arr2[i];
            if (cache2[item] == 0) {
                continue
            }
            if (cache1[item] == 0) {
                continue
            }
            var size = cache1[item];
            while (size-- > 0) {
                res.add(item)
            }
            cache1[item] = 0;
        }
        for (i in cache1.indices) {
            if (cache1[i] == 0) {
                continue
            }
            var size = cache1[i];
            while (size-- > 0) {
                res.add(i)
            }
        }
        return res.toIntArray()
    }
}

fun main() {
    val test = Solution_1122()
    test.relativeSortArray(intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19), intArrayOf(2, 1, 4, 3, 9, 6)).forEach {
        print("$it ")
    }
}
