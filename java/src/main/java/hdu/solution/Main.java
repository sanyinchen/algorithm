package hdu.solution;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by sanyinchen on 19-10-12.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-12
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(new File("./java/src/main/java/hdu/input.txt"));
        Scanner cin = new Scanner(inputStream);
        // Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {

        }
    }

}
