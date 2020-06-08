package newcode;

import java.util.Scanner;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/8
 */

public class HuiWenShuSuoYin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            String str = sc.nextLine();
            find(str);
        }

    }

    private static void find(String str) {
        int low = 0;
        int high = str.length() - 1;
        int res = -1;
        while (low < high) {
            if (str.charAt(low) == str.charAt(high)) {
                low++;
                high--;
            } else {

                if (judge(str, low + 1, high)) {
                    res = low;
                    break;
                } else {
                    res = high;
                    break;
                }

            }
        }
        System.out.println(res);
    }

    private static boolean judge(String str, int low, int high) {
        while (low < high) {
            if (str.charAt(low) != str.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }


}
