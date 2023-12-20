package leet_code

/**
 * Created by sanyinchen on 19-11-18.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-11-18
 */
class Minimum_index_sum_of_two_lists_599 {
    fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
        var mapCache = hashMapOf<String, Int>()
        for (i in list1.indices) {
            mapCache.put(list1.get(i), i)
        }
        var resPairs = arrayListOf<Pair<Int, String>>()
        for (i in list2.indices) {
            if (mapCache.containsKey(list2.get(i))) {
                var number = mapCache.get(list2.get(i))!! + i
                resPairs.add(Pair(number, list2.get(i)))
            }
        }
        resPairs.sortBy { it.first }
        var res= mutableListOf<String>()
        val min=resPairs.minBy { it.first }!!
        for (v in resPairs){
            if (v.first==min.first){
                res.add(v.second)
            }
        }
        return res.toTypedArray()
    }
}