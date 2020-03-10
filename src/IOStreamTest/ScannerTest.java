package IOStreamTest;

import java.util.Scanner;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/4
 */

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i;
        System.out.println(" a number, not 0 plz");
        while ((i = scanner.nextInt()) != 0) {
            System.out.println(i);
            System.out.println("another number, not 0 plz");

        }
        scanner.close();
    }


}
