package leet_code


/**
 * Created by sanyinchen on 19-11-14.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-11-14
 */

class Generate_parentheses_22 {

    val list = mutableListOf<String>()

    fun generateParenthesisHelper(cur: String, left: Int, right: Int, max: Int) {
        if (cur.length == max * 2) {
            list.add(cur)
            return
        }

        if (left < max) {
            generateParenthesisHelper(cur + "(", left + 1, right, max)
        }
        if (right < left) {
            generateParenthesisHelper(cur + ")", left, right + 1, max)
        }

    }

    fun generateParenthesis(n: Int): List<String> {
        if (n == 0) {
            return emptyList()
        }
        generateParenthesisHelper("", 0, 0, n)
        return list
    }


}