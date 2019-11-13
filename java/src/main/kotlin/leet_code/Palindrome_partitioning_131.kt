package leet_code

/**
 * Created by sanyinchen on 19-11-12.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-11-12
 */
class Palindrome_partitioning_131 {

    private var itemList = mutableListOf<String>()
    private var list = mutableListOf<MutableList<String>>()

    private fun isPalindrome(s: String): Boolean {
        if (s.isEmpty()) {
            return false
        }
        if (s.length == 1) {
            return true
        }
        var i = 0;
        var j = s.length - 1;
        while (i < j) {
            if (s[i] != s[j]) {
                return false
            }
            i++
            j--
        }
        return true
    }


    private fun curFunction(subStr: String, start: Int) {
        if (start >= subStr.length) {
            list.add(itemList.toMutableList())
            return
        }

        for (i in start until subStr.length) {
            println("$start : ${i + 1}")
            val temp = subStr.substring(start, i + 1)
            if (isPalindrome(temp)) {
                itemList.add(temp)
                curFunction(subStr, i + 1)
                itemList.removeAt(itemList.size - 1)
            }
        }
    }

    fun partition(s: String): List<List<String>> {
        list.clear()
        itemList.clear()
        curFunction(s, 0)
        return list
    }
}

fun main() {
    val time1 = System.currentTimeMillis()
    val test = Palindrome_partitioning_131()
    //val list = test.partition("seeslaveidemonstrateyetartsnomedievalsees")

    val list = test.partition("abbab")
    println("list size:" + list.size)
    list.forEach {
        println()
        it.forEach {
            print(it + " ")
        }
    }
    println()
    println("final:" + (System.currentTimeMillis() - time1))
}