package newcode;

import java.util.Scanner;


/**
 * @description:
 * @author: bin
 * @create: 2020/6/8
 */

public class ZhuaBuKongLianShun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        long res = compute(arr, D);
        System.out.println(res);
    }

    private static long compute(int[] buildings, int d) {
        int left = 0, right = 2;
        long res = 0;
        int len = buildings.length;
        while (left < len - 2) {
            while (right < len && buildings[right] - buildings[left] <= d) {
                right++;
            }
            if (right - left > 2) {
                res =(res+ f(right - left - 1))% 99997867;
            }
            left++;
        }
        return res;
    }

    private static long f(long i) {

        return i * (i - 1) / 2;
    }

}
