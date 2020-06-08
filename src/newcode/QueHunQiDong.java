package newcode;

import java.util.*;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/8
 */

public class QueHunQiDong {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] pokers = new int[10];
        for (int i = 0; i < 13; i++) {
            pokers[sc.nextInt()]++;
        }
        boolean flag = false;
        for (int i = 1; i < 10; i++) {
            if (pokers[i] == 4) {
                continue;
            }
            pokers[i]++;
            if (judge(pokers, true)) {
                flag = true;
                System.out.print(i+" ");
            }
            pokers[i]--;

        }
        if (!flag) {
            System.out.println(0);
        }

    }

    private static boolean judge(int[] pokers, boolean flag) {
        boolean allZero = true;
        for (int i = 1; i < 10; i++) {
            if (pokers[i] == 0) {
                continue;
            }
            allZero = false;
            if (pokers[i] >= 3) {
                pokers[i] -= 3;
                if (judge(pokers, flag)) {
                    pokers[i] += 3;
                    return true;
                }
                pokers[i] += 3;
            }
            if (pokers[i] >= 2 && flag) {
                pokers[i] -= 2;
                if (judge(pokers, false)) {
                    pokers[i] += 2;
                    return true;
                }
                pokers[i] += 2;
            }
            if (pokers[i] >= 1) {
                if (i < 8 && pokers[i + 1] >= 1 && pokers[i + 2] >= 1) {
                    pokers[i]--;
                    pokers[i + 1]--;
                    pokers[i + 2]--;
                    if (judge(pokers, flag)) {
                        pokers[i]++;
                        pokers[i + 1]++;
                        pokers[i + 2]++;
                        return true;
                    }
                    pokers[i]++;
                    pokers[i + 1]++;
                    pokers[i + 2]++;
                } else {
                    return false;
                }
            }
        }

        return allZero;
    }


}
