package Array;

import java.util.Scanner;

/**
 * @description:
 * @author: bin
 * @create: 2020/5/28
 */

public class test4 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int[] pokers = new int[10];
        for (int i = 0; i < 13; i++) {
            int temp = sc.nextInt();
            pokers[i]++;
        }
        boolean flag = false;
        for (int i = 1; i < 10; i++) {
            pokers[i]++;
            if (judge(pokers)) {
                flag = true;
                System.out.println(i);
            }
            pokers[i]--;
        }
        if (!flag) {
            System.out.println(0);
        }
    }

    public static boolean judge(int[] pokers) {
        int[] copy = new int[10];
        for (int i = 1; i < 9; i++) {
            copy[i] = pokers[i];
        }
        for (int i = 1; i < 10; i++) {
            if (copy[i] == 3) {
                copy[i] -= 3;
            }else{

            }
        }
        return false;
    }

}
