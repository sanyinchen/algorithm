package leet_code;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by sanyinchen on 19-9-14.
 * <p>
 * from https://leetcode-cn.com/problems/minimum-factorization/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-14
 */

class Minimum_Factorization_625 {


    static class Solution {

        private static final Set<String> cacheSet = new HashSet<>();
        private static final int[] SINGLE = new int[]{2, 3, 5, 7};


        private List<Integer> getPrimeFactorList(int n) {
            List<Integer> res = new ArrayList<>();
            res.add(1);
            for (int prime : SINGLE) {
                while (n % prime == 0) {
                    res.addAll(getSpFactor(prime));
                    n = n / prime;
                }
            }

            if (n > 1) {
                res.addAll(getSpFactor(n));
            }
            return res;
        }

        private List<Integer> getSpFactor(int factor) {
            List<Integer> list = new ArrayList<>();
            if (factor < 10) {
                list.add(factor);
                return list;
            }
            if (factor == 10) {
                list.add(0);
                list.add(1);
                return list;
            }
            do {

                list.add(factor % 10);
                factor = factor / 10;

            } while (factor % 10 != 0);

            return list;
        }

        private int getSum(List<Integer> remains) {
            int sum = 1;
            for (Integer item : remains) {
                sum *= item;
            }
            return sum;
        }

        private String getCacheKey(List<Integer> remains) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer item : remains) {
                stringBuilder.append(item);
            }
            return stringBuilder.toString();
        }

        private void smallestFactorization(List<Integer> remains, List<BigInteger> res, int n) {

            for (int i = 0; i < remains.size() - 1; i++) {
                for (int j = i + 1; j < remains.size(); j++) {
                    int first = remains.get(i);
                    int second = remains.get(j);
                    if (first * second < 10) {
                        List<Integer> newList = new ArrayList<>(remains);
                        newList.remove(i);
                        newList.remove(j - 1);
                        newList.add(first * second);
                        Collections.sort(newList, new Comparator<Integer>() {
                            @Override
                            public int compare(Integer t1, Integer t2) {
                                return t1 - t2;
                            }
                        });

                        String cacheKey = getCacheKey(newList);
                        if (cacheSet.contains(cacheKey)) {
                            continue;
                        }
                        cacheSet.add(cacheKey);
                        if (getSum(newList) > n) {
                            return;
                        }
                        smallestFactorization(newList, res, n);
                    }
                }
            }

            StringBuilder number = new StringBuilder();
            int sum = 1;
            for (Integer item : remains) {
                number.append(item);
                sum *= item;
            }
            if (sum == n) {
                res.add(new BigInteger(number.toString()));
            }

        }


        public int smallestFactorization(int a) {
            cacheSet.clear();
            List<BigInteger> nums = new ArrayList<>();
            BigInteger min;
            List<Integer> res = getPrimeFactorList(a);
            Collections.sort(res, new Comparator<Integer>() {
                @Override
                public int compare(Integer t1, Integer t2) {
                    return t1 - t2;
                }
            });
            if (res.size() == 1) {
                if (res.get(0) >= 10) {
                    return 0;
                } else {
                    return res.get(0);
                }
            }

            smallestFactorization(res, nums, a);
            if (nums.size() == 0) {
                return 0;
            }
            if (nums.size() == 1) {
                return nums.get(0).intValue();
            }
            BigInteger max = new BigInteger(Integer.MAX_VALUE + "");
            min = max;
            for (BigInteger item : nums) {
                if (min.compareTo(item) > 0) {
                    min = item;
                }
            }
            if (min.compareTo(max) >= 0) {
                return 0;
            }
            return min.intValue();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long time1 = System.currentTimeMillis();
        System.out.println(solution.smallestFactorization(15));
        System.out.println("cost time:" + (System.currentTimeMillis() - time1));
    }
}
