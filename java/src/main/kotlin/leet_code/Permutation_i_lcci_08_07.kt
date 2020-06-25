package leet_code

import java.lang.StringBuilder

class Solution_08_07 {
    fun exchange(i: Int, j: Int, array: CharArray) {
        val temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    fun getStr(array: CharArray): String {
        var str: StringBuilder = StringBuilder()
        array.forEach {
            str.append(it)
        }
        return str.toString()
    }

    fun permutation(S: String): Array<String> {
        val words = S.toCharArray()
        val res = HashSet<String>()
        fun permutationFunc(_words: CharArray, start: Int) {
            for (i in start until _words.size) {
                exchange(start, i, _words)
                res.add(getStr(words))
                permutationFunc(words, start + 1);
                exchange(i, start, _words)
            }
        }
        for (i in words.indices) {
            permutationFunc(words, 0)
        }
        return res.toTypedArray()

    }


}

fun main() {
    val test = Solution_08_07();
    test.permutation("qwe").forEach {
        println(it)
    }
}