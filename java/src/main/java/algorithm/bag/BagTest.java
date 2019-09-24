package algorithm.bag;

import java.util.Iterator;

/**
 * Created by sanyinchen on 19-9-23.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-23
 */

public class BagTest {


    public static void main(String[] args) {
        Bag<Integer> bag = new Bag<>();
        bag.add(1).add(2).add(3);
        Iterator<Integer> iterator = bag.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        Iterator<Integer> iterator2 = bag.iterator();
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + " ");
        }
    }
}
