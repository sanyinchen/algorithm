package leet_code;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by sanyinchen on 20-1-15.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-15
 */

class Number_of_atoms_726 {
    static class Solution {


        public String countOfAtoms(String formula) {
            Stack<Pair> stack = new Stack<>();
            for (int i = 0; i < formula.length(); i++) {
                char item = formula.charAt(i);
                if (item == ')') {
                    List<Pair> list = new ArrayList<>();
                    while (!stack.isEmpty() && !stack.peek().item.equals("(")) {
                        list.add(stack.pop());
                    }
                    stack.pop();
                    StringBuilder number = new StringBuilder();
                    i++;
                    boolean flag = false;
                    while (i < formula.length() && formula.charAt(i) >= '0' && formula.charAt(i) <= '9') {
                        number.append(formula.charAt(i));
                        i++;
                        flag = true;
                    }
                    if (flag) {
                        i--;
                    }
                    if (number.toString().equals("")) {
                        number.append("0");
                    }
                    int times = Integer.parseInt(number.toString());
                    if (times <= 0) {
                        times = 1;
                    }
                    for (int jj = 0; jj < list.size(); jj++) {
                        Pair pair = list.get(jj);
                        pair.times *= times;
                        stack.push(pair);
                    }

                } else if (item >= '0' && item <= '9') {
                    StringBuilder number = new StringBuilder();
                    while (i < formula.length() && formula.charAt(i) >= '0' && formula.charAt(i) <= '9') {
                        number.append(formula.charAt(i));
                        i++;
                    }
                    i--;
                    int times = Integer.parseInt(number.toString());
                    if (times <= 0) {
                        times = 1;
                    }
//                    Pair pair = stack.pop();
//                    pair.times *= times;
                    stack.peek().times *= times;
                } else {
                    StringBuilder itemTemp = new StringBuilder();
                    itemTemp.append(item);
                    while (i < formula.length() - 1 && formula.charAt(i + 1) <= 'z' && formula.charAt(i + 1) >= 'a') {
                        itemTemp.append(formula.charAt(i + 1));
                        i++;
                    }
                    stack.push(new Pair(itemTemp.toString(), 1));
                }
            }
            List<Pair> pairs = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();
            while (!stack.isEmpty()) {
                Pair item = stack.pop();
                if (!map.containsKey(item.item)) {
                    map.put(item.item, item.times);
                } else {
                    map.replace(item.item, map.get(item.item) + item.times);
                }
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                pairs.add(new Pair(entry.getKey(), entry.getValue()));
            }
            pairs.sort(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o1.item.compareTo(o2.item);
                }
            });
            StringBuilder res = new StringBuilder();
            for (Pair pair : pairs) {
                res.append(pair.toStringBuilder().toString());
            }
            return res.toString();
        }

        private class Pair {
            String item;
            int times;

            public Pair(String item, int times) {
                this.item = item;
                this.times = times;
            }

            public StringBuilder toStringBuilder() {
                StringBuilder stringBuilder = new StringBuilder();
                if (times <= 1) {
                    stringBuilder.append(item);
                    return stringBuilder;
                }
                return stringBuilder.append(item).append(times);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.print(solution.countOfAtoms("(((U42Se42Fe10Mc31Rh49Pu49Sb49)49V39Tm50Zr44Og6)33(" +
//                "(W2Ga48Tm14Eu46Mt12)23(RuRnMn11)7(Yb15Lu34Ra19CuTb2)47(Md38BhCu48Db15Hf12Ir40)7CdNi21" +
//                "(Db40Zr24Tc27SrBk46Es41DsI37Np9Lu16)46(Zn49Ho19RhClF9Tb30SiCuYb16)15)37(Cr48(Ni31)25
//                (La8Ti17Rn6Ce35)" +
//                "36(Sg42Ts32Ca)37Tl6Nb47Rh32NdGa18Cm10Pt49(Ar37RuSb30Cm32Rf28B39Re7F36In19Zn50)46)38" +
//                "(Rh19Md23No22PoTl35Pd35Hg)41)50"));
        System.out.print(solution.countOfAtoms("K4(ON(SO3)2)2"));
    }
}
