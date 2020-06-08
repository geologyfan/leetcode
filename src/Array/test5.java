package Array;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @description:
 * @author: bin
 * @create: 2020/5/28
 */

public class test5 {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    }

    private void feature() {

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            fun();
        }
    }

    private void fun() {
        HashMap<String, Integer> last = new HashMap<>();
        int max = 0;
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int n = sc.nextInt();
            HashMap<String, Integer> cur = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String s = String.valueOf(sc.nextInt()) + String.valueOf(sc.nextInt());
                int l = last.getOrDefault(s, 0);
                max = Math.max(l + 1, max);
                cur.put(s, l + 1);
            }
            last = cur;
        }
        System.out.println(max);
    }

}
