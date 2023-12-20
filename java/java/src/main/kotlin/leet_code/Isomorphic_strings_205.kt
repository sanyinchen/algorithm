package leet_code

/**
 * Created by sanyinchen on 19-11-4.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-11-4
 */
class Isomorphic_strings_205 {

    fun isIsomorphic(s: String, t: String): Boolean {
        var map1 = HashMap<Char, Char>();
        var map2 = HashMap<Char, Char>();
        for (index in 0..s.length - 1) {
            var tChar = t[index];
            var sChar = s[index];
            map1.put(tChar, sChar);
            map2.put(sChar, tChar);
        }
        var strBuilder = StringBuilder()
        var strBuilder2 = StringBuilder()
        for (index in 0..t.length - 1) {
            var tChar = t[index];
            strBuilder.append(map1.get(tChar));
            var sChar = s[index];
            strBuilder2.append(map2.get(sChar));
        }

        return strBuilder.toString() == s && strBuilder2.toString() == t;
    }
}

fun main() {
    var test = Isomorphic_strings_205();
    println(test.isIsomorphic("ab", "aa"))
    println(test.isIsomorphic("foo", "bar"))
    println(test.isIsomorphic("egg", "foo"))
}