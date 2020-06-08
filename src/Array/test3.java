package Array;

import java.util.Scanner;

/**
 * @description:
 * @author: bin
 * @create: 2020/5/28
 */

public class test3 {
    int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int[] buildings = new int[N];
        for (int i = 0; i < N; i++) {
            buildings[i] = sc.nextInt();
        }

        long res = compute(buildings, D);
        System.out.println(res);
    }

    private static long compute(int[] buildings, int d) {
        int left = 0, right = 2;
        long res = 0;
        int len = buildings.length;
        while (left<len-2) {
            if (right<len&&buildings[right] - buildings[left] <= d) {
                right++;
            } else if (right - left > 2) {
                res = (res + f(right - left-1)) % 99997867;
                left++;
            } else {
                left++;
            }
        }
        return res;
    }

    private static long f(long i) {

        return i * (i - 1) / 2;
    }


}
