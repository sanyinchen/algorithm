package leet_code.weekly_contest.biweekly_contest_12;

import java.util.ArrayList;
import java.util.List;

// todo fail
public class Array_transformation_5096 {
    class Solution {
        public List<Integer> transformArray(int[] arr) {

            int[] arrayB = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                arrayB[i] = arr[i];
            }
            for (int j = 1; j < arr.length; j++) {
                for (int i = 1; i < arr.length - 1; i++) {
                    if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                        arr[i] += 1;
                        arrayB[i] = arr[i];
                    }
                    if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                        arr[i] += 1;
                        arrayB[i] = arr[i];
                    }
                }
                for (int i = 0; i < arrayB.length; i++) {
                    arr[i] = arrayB[i];
                }
            }
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                res.add(arr[i]);
            }
            return res;
        }
    }
}
