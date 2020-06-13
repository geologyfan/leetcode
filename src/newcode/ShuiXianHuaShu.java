package newcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/10
 */

public class ShuiXianHuaShu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        String line;
        while ((line = br.readLine())!=null&&line.length()>0) {

            String[] nums = line.split(" ");
            int low = Integer.parseInt(nums[0]);
            int high = Integer.parseInt(nums[1]);
            func(low, high);
        }
        br.close();
    }

    private static void func(int low, int high) {
        List<Integer> list = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            if (judge(i)) {
                list.add(i);

            }
        }
        if (list.isEmpty()) {
            System.out.print("no\n");
        } else {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    System.out.print(list.get(i));
                } else {
                    System.out.print(" " + list.get(i));
                }
            }

        }

    }

    private static boolean judge(int num) {
        int n = num;
        int c = 0;
        while (n > 0) {
            int temp = n % 10;
            c += temp * temp * temp;
            n /= 10;
        }
        return c == num;
    }

}
