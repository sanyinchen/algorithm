package leet_code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sanyinchen on 19-9-19.
 * <p>
 * from https://leetcode-cn.com/problems/walls-and-gates/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-19
 */

class Walls_and_gates_286 {
    static class Solution {
        private Map<String, Integer> cache = new HashMap<>();

        private String getCacheKey(int i, int j) {
            return i + "_" + j;
        }

        public boolean wallsAndGatesHelper(int[][] rooms, int i, int j) {
            if (i < 0 || j < 0) {
                return false;
            }
            if (i >= rooms.length) {
                return false;
            }
            if (j >= rooms[i].length) {
                return false;
            }
            if (rooms[i][j] != Integer.MAX_VALUE) {
                if (rooms[i][j] >= 0) {
                    return true;
                } else {
                    return false;
                }
            }
//            if (wallsAndGatesHelper(rooms, i - 1, j - 1)) {
//                if (rooms[i][j] == Integer.MAX_VALUE) {
//                    rooms[i][j] = 0;
//                } else {
//                    rooms[i][j]++;
//                }
//            }
            if (cache.containsKey(getCacheKey(i - 1, j - 1))) {
                int v = cache.get(getCacheKey(i - 1, j - 1));
                if (v >= 0 && v != Integer.MAX_VALUE) {
                    if (rooms[i][j] == Integer.MAX_VALUE) {
                        rooms[i][j] = 0;
                    } else {
                        rooms[i][j] = rooms[i - 1][j - 1] + 1;
                    }
                    cache.put(getCacheKey(i, j), rooms[i][j]);
                }
            } else {
                if (wallsAndGatesHelper(rooms, i - 1, j - 1)) {
                    if (rooms[i][j] == Integer.MAX_VALUE) {
                        rooms[i][j] = 0;
                    } else {
                        rooms[i][j] = rooms[i - 1][j - 1] + 1;
                    }
                    cache.put(getCacheKey(i, j), rooms[i][j]);
                }
            }


            if (cache.containsKey(getCacheKey(i - 1, j))) {
                int v = cache.get(getCacheKey(i - 1, j));
                if (v >= 0 && v != Integer.MAX_VALUE) {
                    if (rooms[i][j] == Integer.MAX_VALUE) {
                        rooms[i][j] = 0;
                    } else {
                        rooms[i][j] = rooms[i - 1][j] + 1;
                    }
                    cache.put(getCacheKey(i, j), rooms[i][j]);
                }
            } else {
                if (wallsAndGatesHelper(rooms, i - 1, j)) {
                    if (rooms[i][j] == Integer.MAX_VALUE) {
                        rooms[i][j] = 0;
                    } else {
                        rooms[i][j] = rooms[i - 1][j] + 1;
                    }
                    cache.put(getCacheKey(i, j), rooms[i][j]);
                }
            }


            if (cache.containsKey(getCacheKey(i - 1, j + 1))) {
                int v = cache.get(getCacheKey(i - 1, j + 1));
                if (v >= 0 && v != Integer.MAX_VALUE) {
                    if (rooms[i][j] == Integer.MAX_VALUE) {
                        rooms[i][j] = 0;
                    } else {
                        rooms[i][j] = rooms[i - 1][j + 1] + 1;
                    }
                    cache.put(getCacheKey(i, j), rooms[i][j]);
                }
            } else {
                if (wallsAndGatesHelper(rooms, i - 1, j + 1)) {
                    if (rooms[i][j] == Integer.MAX_VALUE) {
                        rooms[i][j] = 0;
                    } else {
                        rooms[i][j] = rooms[i - 1][j + 1] + 1;
                    }
                    cache.put(getCacheKey(i, j), rooms[i][j]);
                }
            }


            if (cache.containsKey(getCacheKey(i, j - 1))) {
                int v = cache.get(getCacheKey(i, j - 1));
                if (v >= 0 && v != Integer.MAX_VALUE) {
                    if (rooms[i][j] == Integer.MAX_VALUE) {
                        rooms[i][j] = 0;
                    } else {
                        rooms[i][j] = rooms[i][j - 1] + 1;
                    }
                    cache.put(getCacheKey(i, j), rooms[i][j]);
                }
            } else {
                if (wallsAndGatesHelper(rooms, i, j - 1)) {
                    if (rooms[i][j] == Integer.MAX_VALUE) {
                        rooms[i][j] = 0;
                    } else {
                        rooms[i][j] = rooms[i][j - 1] + 1;
                    }
                    cache.put(getCacheKey(i, j), rooms[i][j]);
                }
            }


            if (cache.containsKey(getCacheKey(i, j + 1))) {
                int v = cache.get(getCacheKey(i, j + 1));
                if (v >= 0 && v != Integer.MAX_VALUE) {
                    if (rooms[i][j] == Integer.MAX_VALUE) {
                        rooms[i][j] = 0;
                    } else {
                        rooms[i][j] = rooms[i][j + 1] + 1;
                    }
                    cache.put(getCacheKey(i, j), rooms[i][j]);
                }
            } else {
                if (wallsAndGatesHelper(rooms, i, j + 1)) {
                    if (rooms[i][j] == Integer.MAX_VALUE) {
                        rooms[i][j] = 0;
                    } else {
                        rooms[i][j] = rooms[i][j + 1] + 1;
                    }
                    cache.put(getCacheKey(i, j), rooms[i][j]);
                }
            }
            if (cache.containsKey(getCacheKey(i + 1, j - 1))) {
                int v = cache.get(getCacheKey(i + 1, j - 1));
                if (v >= 0 && v != Integer.MAX_VALUE) {
                    if (rooms[i][j] == Integer.MAX_VALUE) {
                        rooms[i][j] = 0;
                    } else {
                        rooms[i][j] = rooms[i + 1][j - 1] + 1;
                    }
                    cache.put(getCacheKey(i, j), rooms[i][j]);
                }
            } else {
                if (wallsAndGatesHelper(rooms, i + 1, j - 1)) {
                    if (rooms[i][j] == Integer.MAX_VALUE) {
                        rooms[i][j] = 0;
                    } else {
                        rooms[i][j] = rooms[i + 1][j - 1] + 1;
                    }
                    cache.put(getCacheKey(i, j), rooms[i][j]);
                }
            }

            if (cache.containsKey(getCacheKey(i + 1, j))) {
                int v = cache.get(getCacheKey(i + 1, j));
                if (v >= 0 && v != Integer.MAX_VALUE) {
                    if (rooms[i][j] == Integer.MAX_VALUE) {
                        rooms[i][j] = 0;
                    } else {
                        rooms[i][j] = rooms[i + 1][j] + 1;
                    }
                    cache.put(getCacheKey(i, j), rooms[i][j]);
                }
            } else {
                if (wallsAndGatesHelper(rooms, i + 1, j)) {
                    if (rooms[i][j] == Integer.MAX_VALUE) {
                        rooms[i][j] = 0;
                    } else {
                        rooms[i][j] = rooms[i + 1][j] + 1;
                    }
                    cache.put(getCacheKey(i, j), rooms[i][j]);
                }
            }


            if (cache.containsKey(getCacheKey(i + 1, j + 1))) {
                int v = cache.get(getCacheKey(i + 1, j + 1));
                if (v >= 0 && v != Integer.MAX_VALUE) {
                    if (rooms[i][j] == Integer.MAX_VALUE) {
                        rooms[i][j] = 0;
                    } else {
                        rooms[i][j] = rooms[i + 1][j + 1] + 1;
                    }
                    cache.put(getCacheKey(i, j), rooms[i][j]);
                }
            } else {
                if (wallsAndGatesHelper(rooms, i + 1, j + 1)) {
                    if (rooms[i][j] == Integer.MAX_VALUE) {
                        rooms[i][j] = 0;
                    } else {
                        rooms[i][j] = rooms[i + 1][j + 1] + 1;
                    }
                    cache.put(getCacheKey(i, j), rooms[i][j]);
                }
            }
//            if (wallsAndGatesHelper(rooms, i - 1, j + 1)) {
//                if (rooms[i][j] == Integer.MAX_VALUE) {
//                    rooms[i][j] = 0;
//                } else {
//                    rooms[i][j]++;
//                }
//            }
//            if (wallsAndGatesHelper(rooms, i, j - 1)) {
//                if (rooms[i][j] == Integer.MAX_VALUE) {
//                    rooms[i][j] = 0;
//                } else {
//                    rooms[i][j]++;
//                }
//            }
//            if (wallsAndGatesHelper(rooms, i, j + 1)) {
//                if (rooms[i][j] == Integer.MAX_VALUE) {
//                    rooms[i][j] = 0;
//                } else {
//                    rooms[i][j] = rooms[i][j + 1] + 1;
//                }
//            }
//            if (wallsAndGatesHelper(rooms, i + 1, j - 1)) {
//                if (rooms[i][j] == Integer.MAX_VALUE) {
//                    rooms[i][j] = 0;
//                } else {
//                    rooms[i][j]++;
//                }
//            }

//            if (wallsAndGatesHelper(rooms, i + 1, j)) {
//                if (rooms[i][j] == Integer.MAX_VALUE) {
//                    rooms[i][j] = 0;
//                } else {
//                    rooms[i][j] = rooms[i + 1][j] + 1;
//                }
//            }
//            if (wallsAndGatesHelper(rooms, i + 1, j + 1)) {
//                if (rooms[i][j] == Integer.MAX_VALUE) {
//                    rooms[i][j] = 0;
//                } else {
//                    rooms[i][j] = rooms[i + 1][j + 1] + 1;
//                }
//            }

            return false;
        }

        private Set<String> visited = new HashSet<>();

        public boolean wallsAndGatesHelper2(int[][] rooms, int i, int j) {
            System.out.println("i:" + i + " j:" + j);
            if (i < 0 || j < 0) {
                return false;
            }
            if (i >= rooms.length) {
                return false;
            }
            if (j >= rooms[i].length) {
                return false;
            }
            if (rooms[i][j] != Integer.MAX_VALUE) {
                if (rooms[i][j] >= 0) {
                    return true;
                } else {
                    return false;
                }
            }

            if (!visited.contains(getCacheKey(i, j))) {
                visited.add(getCacheKey(i, j));
                if (wallsAndGatesHelper2(rooms, i - 1, j)) {
                    if (rooms[i][j] == Integer.MAX_VALUE) {
                        rooms[i][j] = 1;
                    } else {
                        rooms[i][j] = rooms[i - 1][j] + 1;
                    }
                }

                if (wallsAndGatesHelper2(rooms, i, j + 1)) {
                    if (rooms[i][j] == Integer.MAX_VALUE) {
                        rooms[i][j] = 1;
                    } else {
                        rooms[i][j] = rooms[i][j + 1] + 1;
                    }
                }


                if (wallsAndGatesHelper2(rooms, i + 1, j)) {
                    if (rooms[i][j] == Integer.MAX_VALUE) {
                        rooms[i][j] = 1;
                    } else {
                        rooms[i][j] = rooms[i + 1][j] + 1;
                    }
                }
            }


            return false;
        }

        public void wallsAndGates(int[][] rooms) {
            wallsAndGatesHelper2(rooms, 0, 0);
//            for (int i = 0; i < rooms.length; i++) {
//                for (int j = 0; j < rooms[i].length; j++) {
//                    wallsAndGatesHelper2(rooms, i, j);
//                }
//            }
        }
    }

    public static void main(String[] args) {
        int[][] x = new int[][]{{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1,
                        2147483647, -1}, {0, -1, 2147483647, 2147483647}};
        // System.out.println(x.length);
        new Solution().wallsAndGates(x);
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
    }
}
