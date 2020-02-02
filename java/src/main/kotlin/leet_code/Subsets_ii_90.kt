package leet_code

class Subsets_ii_90 {
    var itemList = mutableListOf<Int>()
    var allList = mutableListOf<List<Int>>()


    fun isContained(list: List<Int>): Boolean {
        allList.forEach() {
            if (it.size == list.size) {
                val temp=list.toMutableList()
                temp.sort()
                val temp2=it.toMutableList();
                temp2.sort()
                val pairs = temp.zip(temp2)
                for (v in pairs) {
                    if (v.first != v.second) {
                        return@forEach
                    }
                }
                return true
            }
        }
        return false
    }

    fun subsetsWithDupHelper(start: Int, nums: IntArray) {

        val templist = itemList.toMutableList()
        if (!isContained(templist)) {
            allList.add(templist)
        }
        for (i in start until nums.size) {
            itemList.add(nums[i])
            subsetsWithDupHelper(i + 1, nums)
            itemList.removeAt(itemList.size - 1)
        }
    }

    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        if (nums.isEmpty()) {
            return emptyList()
        }
        itemList.clear()
        allList.clear()
        subsetsWithDupHelper(0, nums)
        return allList;
    }
}

fun main() {
    Subsets_ii_90().subsetsWithDup(intArrayOf(4, 4, 4, 1, 4)).forEach({
        println(it)
    })
}