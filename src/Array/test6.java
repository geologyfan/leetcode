package Array;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: bin
 * @create: 2020/5/28
 */

public class test6 {


    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
        nthUglyNumber(10);
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(2);
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(i1,1);
        map.put(i2,1);

        System.out.println(map.get(1));

    }

    public static int nthUglyNumber(int n) {
        int count2 = 0;
        int count3 = 0;
        int count5 = 0;
        int[] dp = new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            int a = dp[count2]*2;
            int b = dp[count3]*3;
            int c = dp[count5]*5;
            int min = Math.min(a,Math.min(b,c));
            dp[i]= min;
            if(min==a)
                count2++;
            if(min==b)
                count3++;

             if(min==c) count5++;

        }
        return dp[n-1];
    }

    public static int findKthNumber(int n, int k) {
        long prefix = 1;
        int count = 1;
        while (count < k) {
            int num = getNum(prefix, n);
            if (count + num > k) {
                count++;
                prefix *= 10;
            } else {
                count += num;
                prefix++;
            }
        }
        return (int) prefix;
    }

    public static int getNum(long prefix, int n) {
        int count = 0;
        for (long a = prefix, b = prefix + 1; a <= n; a *= 10, b *= 10) {
            count += Math.min(n + 1, b) - a;
        }

        return count;
    }

    private void build(int money) {
        int[] num = new int[1024];
        for (int i = 1; i < 1024; i++) {
            if (i >= 64) {
                num[i] = Math.min(num[i - 64], Math.min(num[i - 16], Math.min(num[i - 4], num[i - 1]))) + 1;
            } else if (i >= 16) {
                num[i] = Math.min(num[i - 16], Math.min(num[i - 4], num[i - 1])) + 1;
            } else if (i >= 4) {
                num[i] = Math.min(num[i - 4], num[i - 1]) + 1;
            } else {
                num[i] = num[i - 1] + 1;
            }
        }
        System.out.println(num[money]);
    }

}
