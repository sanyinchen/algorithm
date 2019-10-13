package hdu.solution_4841;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by sanyinchen on 19-10-12.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-12
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // InputStream inputStream = new FileInputStream(new File("./java/src/main/java/hdu/input.txt"));
        //Scanner cin = new Scanner(inputStream);
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt() * 2;
            int step = cin.nextInt();
            // System.out.println("n:" + n + "step:" + step);
            List<Integer> members = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                members.add(i);
            }
            int k = n / 2;
            List<Integer> recorder = new ArrayList<>();
            int len = members.size();
            int index = 0;
            while (k-- > 0 && len != 0) {
                index = (index + step - 1) % len;
//                if (index == -1) {
//                    index = len - 1;
//                }
                // System.out.println("index==>" + index);
                int bad = members.get(index);
                recorder.add(bad);
                members.remove(index);
                len--;
                index = index % len;

                //  System.out.println("len:" + len + " index:" + index);
            }
            char[] numbers = new char[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = 'G';
            }
            for (int i = 0; i < recorder.size(); i++) {
                numbers[recorder.get(i)] = 'B';
            }

            for (int ii = 0; ii < numbers.length; ii++) {
                if (ii % 50 == 0 && ii != 0) {
                    System.out.println();
                }
                System.out.print(numbers[ii]);

            }
            System.out.println();
            System.out.println();
        }
    }

}
