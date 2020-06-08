package newcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/8
 */

public class ZuiJiaPeiDui {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < len; i++) {
            set.add(sc.nextInt());
        }
        for (int i = 0; i < len; i++) {
            int temp = sc.nextInt();
            if (set.contains(temp)) {
                count++;
                set.remove(temp);
            }
        }
        if (set.isEmpty()) {
            System.out.println(count == len ? count - 1 : count);
        } else {
            System.out.println(count + 1);
        }


    }

}
