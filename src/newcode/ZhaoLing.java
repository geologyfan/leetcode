package newcode;

import java.util.Scanner;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/13
 */

public class ZhaoLing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int res = compute(1024 - N);
        System.out.println(res);
        sc.close();
    }

    private static int compute(int N) {
        int count = 0;
        while (N > 0) {
            if (N >= 64) {
                count++;
                N -= 64;
            } else if (N >= 16) {
                count++;
                N -= 16;
            } else if (N >= 4) {
                count++;
                N -= 4;
            } else {
                count++;
                N--;
            }
        }
        return count;
    }

}
