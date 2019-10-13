package leet_code

/**
 * Created by sanyinchen on 19-10-13.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-13
 */
class Valid_sudoku_36 {
    fun isValidSudoku(board: Array<CharArray>): Boolean {

        for (i in 0..8) {
            var cache = HashSet<Char>();
            var cache2 = HashSet<Char>();
            for (j in 0..8) {
                if (board[i][j] != '.') {
                    if (cache.contains(board[i][j])) {
                        println("$i $j ${board[i][j]} one")
                        return false;
                    } else {
                        cache.add(board[i][j])
                    }
                }
                if (board[j][i] != '.') {
                    if (cache2.contains(board[j][i])) {
                        println("$j $i ${board[j][i]} two")
                        return false;
                    } else {
                        cache2.add(board[j][i])
                    }
                }

            }
        }
        for (iMax in 0..8 step 3) {
            for (jMax in 0..8 step 3) {
                var cache = HashSet<Char>();
                for (i in iMax..iMax + 3) {
                    for (j in jMax..jMax + 3) {
                        if (board[i][j] != '.') {
                            if (cache.contains(board[i][j])) {
                                println("$i $j ${board[i][j]} three")
                                return false;
                            } else {
                                cache.add(board[i][j])
                            }
                        }
                    }
                }

            }
        }


        return true;
    }
}