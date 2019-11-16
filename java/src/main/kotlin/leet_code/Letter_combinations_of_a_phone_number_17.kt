package leet_code

/**
 * Created by sanyinchen on 19-11-13.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-11-13
 */


class Letter_combinations_of_a_phone_number_17 {

    val list = mutableListOf<String>()
    val map = HashMap<String, String>()

    fun letterCombinationsHelper(group: String, subStr: String) {
        if (subStr.isEmpty()) {
            list.add(group)
            return
        }
        val letters = map.get(subStr.substring(0, 1)) ?: ""
        for (item in letters) {
            letterCombinationsHelper(group + item, subStr.substring(1))
        }
    }

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return emptyList()
        }

        map.put("2", "abc")
        map.put("3", "def")
        map.put("4", "ghi")
        map.put("5", "jkl")
        map.put("6", "mno")
        map.put("7", "pqrs")
        map.put("8", "tuv")
        map.put("9", "wxyz")

        letterCombinationsHelper("", digits)
        return list
    }

}

fun main() {
    val test = Letter_combinations_of_a_phone_number_17()
    test.letterCombinations("234").forEach {
        println(it)
    }
}