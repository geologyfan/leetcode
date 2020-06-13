package newcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/10
 */

public class XuanQuJian {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null&&line.length()>0) {
            int n = Integer.parseInt(line);
            String[] strs = br.readLine().split(" ");
            int[] arr = new int[strs.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
            long max = func1(arr);
            System.out.println(max);
        }
        br.close();
    }

    private static long func1(int[] nums) {
        long max = 0;
        for (int i = 0; i < 100; i++) {
            long sum = 0;
            int realMin = 101;

            for (int num : nums) {
                if (num >= i) {
                    sum += num;
                    realMin = Math.min(realMin, num);
                } else {
                    max = Math.max(max, sum * realMin);
                    sum=0;
                    realMin=101;
                }
            }
            max = Math.max(max, realMin * sum);
        }
        return max;

    }


}
