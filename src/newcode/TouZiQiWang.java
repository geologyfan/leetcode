package newcode;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/11
 */

public class TouZiQiWang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        BigDecimal total = new BigDecimal("1");
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            max = Math.max(max, arr[i]);
            total = total.multiply(new BigDecimal(Integer.toString(arr[i])));
        }
        BigInteger[] counts = new BigInteger[max - 1 + 1];

        for (int i = 1; i <= max; i++) {

        }


    }

    public static BigInteger compute(int[] arr, int max) {
        BigInteger count = new BigInteger("0");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < max) {
                continue;
            }
            BigInteger temp = new BigInteger("1");
            for (int j = 0; j < arr.length; j++) {
                if (j == i) {
                    continue;
                }
                int num = Math.min(arr[j], max);
                temp = temp.multiply(new BigInteger(Integer.toString(num)));
            }
            count = count.add(temp);
        }
        return count;
    }


    public static double[] twoSum2(int n) {
        int[] fi = new int[7];
        Arrays.fill(fi, 1);
        fi[0] = 0;
        for (int i = 2; i <= n; i++) {
            int[] se = new int[(fi.length - 1) + 6 + 1];
            for (int j = i; j < se.length; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k > 0) {
                        se[j] += j - k < fi.length ? fi[j - k] : 0;
                    }
                }
            }
            fi = se;
        }
        double total = Math.pow(6, n);
        List<Double> list = new ArrayList<>();
        for (int i : fi) {
            if (i > 0) {
                list.add((double) i / total);
            }
        }
        double[] res = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    public static double[] twoSum(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];

        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * n; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k > 0) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }
        double total = Math.pow((double) 6, (double) n);
        int len = 6 * n + 1 - n;
        double[] res = new double[len];
        for (int i = n; i <= 6 * n; i++) {
            res[i - n] = (double) dp[n][i] / total;
        }
        return res;
    }
}
