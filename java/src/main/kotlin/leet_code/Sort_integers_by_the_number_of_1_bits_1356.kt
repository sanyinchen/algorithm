package leet_code

class Sort_integers_by_the_number_of_1_bits_1356 {
    fun sortByBits(arr: IntArray): IntArray {
        var pairs = mutableListOf<Triple<Int, Int, Int>>()
        var number = { x: Int ->
            var sum = 0;
            var temp = x;
            // var tempStr = "";
            while (temp > 0) {
                //   tempStr += (temp % 2);
                if (temp % 2 != 0) {
                    sum++;
                }
                temp /= 2;
            }
            // println("$x $tempStr ${x.toString(2)}")
            sum
        }

        var index = 0;
        arr.forEach {
            pairs.add(Triple(number(it), index++, it))
        }
        pairs.sortWith(Comparator<Triple<Int, Int, Int>> { o1, o2 ->
            if (o1.first == o2.first) {
                return@Comparator o1.third - o2.third
            } else {
                return@Comparator o1.first - o2.first
            }
        })
        return pairs.map { it.third }.toIntArray()
    }

}

fun main() {
    var test = Sort_integers_by_the_number_of_1_bits_1356();
    var input = mutableListOf<Int>(1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1).toIntArray();
    test.sortByBits(input).forEach { print("$it ") }
}