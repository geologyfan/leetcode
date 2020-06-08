package netease;

import java.util.Scanner;

/**
 * @description:
 * @author: bin
 * @create: 2020/4/7
 */

public class p1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int first = sc.nextInt();
        int second = sc.nextInt();
        int res = second - first;
        for (int i = 2; i < n; i++) {
            first = second;
            second = sc.nextInt();
            res = mod(second - first, res);
        }
        System.out.println(res == 0 ? -1 : res);
    }

    public static int mod(int a, int b) {
        if (a <= 0 || b <= 0) {
            return 0;
        }
        int m = Math.max(a, b);
        int n = Math.min(a, b);
        while (m % n != 0) {
            int tmp = m % n;
            m = n;
            n = tmp;
        }
        return n;
    }


}
