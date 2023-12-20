package leet_code


class Sort_array_by_parity_ii {
    fun sortArrayByParityII(a: IntArray): IntArray {
        val start= mutableListOf<Int>();
        val end= mutableListOf<Int>();
        a.forEach {
            if (it%2==0){
                start.add(it)
            }else{
                end.add(it)
            }
        }
        val res= mutableListOf<Int>();
        var firstIndex=0;
        var secondIndex=0;
        for ( i in a.indices){
           if (i%2==0){
               res.add(start[firstIndex++])
           }else{
               res.add(end[secondIndex++])
           }
        }
        return res.toIntArray();
    }
};

fun main(){
    val test=Sort_array_by_parity_ii();
    test.sortArrayByParityII(intArrayOf(4,2,5,7))
}