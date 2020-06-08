package newcode;

import java.util.Scanner;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/8
 */

public class CongMingDeBianJi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < N; i++) {
            String str = scanner.nextLine();
            String res = fix(str);
            System.out.println(res);
        }


    }

    private static String fix(String str) {

        String res = str.replaceAll("(.)\\1+", "$1$1").replaceAll("(.)\\1(.)\\2", "$1$1$2");

        return res;
    }
}
