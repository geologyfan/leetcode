package newcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/11
 */

public class ErWeiBiaoDiK {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long k = sc.nextLong();

        long res = findK(n, m, k);
        System.out.println(res);

        sc.close();

    }

    public static long findK(long n, long m, long k) {

        long left = 1;
        long right = m * n;
        while (left < right) {
            long mid = (left + right) >> 1;
            int count = 0;
            for (int i = 1; i < n + 1; i++) {
                count += m - Math.min(m, mid / i);
            }
            if (count < k) {
                right = mid ;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

}
