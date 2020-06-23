package leet_code

class NumMatrix(matrix: Array<IntArray>) {
    var cahce: Array<IntArray> = Array(matrix.size) { IntArray(matrix[0].size) };

    init {
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                cahce[i][j] = getSafeValue(i - 1, j, cahce) + getSafeValue(i, j - 1, cahce) - getSafeValue(i - 1, j - 1, cahce) + matrix[i][j]
            }
        }

    }

    private fun getSafeValue(row: Int, col: Int, array: Array<IntArray>): Int {
        if (row < 0 || col < 0) {
            return 0
        }
        if (row >= array.size || col >= array[0].size) {
            return 0
        }
        return array[row][col]
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {

        return (getSafeValue(row2, col2, cahce)
                - getSafeValue(row2, col1 - 1, cahce)
                - getSafeValue(row1 - 1, col2, cahce)
                + getSafeValue(row1 - 1, col1 - 1, cahce))
    }

}


fun main() {
    val test = arrayOf(
            intArrayOf(3, 0, 1, 4, 2),
            intArrayOf(5, 6, 3, 2, 1),
            intArrayOf(1, 2, 0, 1, 5),
            intArrayOf(4, 1, 0, 1, 7),
            intArrayOf(1, 0, 3, 0, 5)
    )
    val numMatrix: NumMatrix = NumMatrix(test);
    print(numMatrix.sumRegion(2, 1, 4, 3))
}