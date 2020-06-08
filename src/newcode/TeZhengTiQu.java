package newcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/8
 */

public class TeZhengTiQu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();
            Map<String, Integer> last = new HashMap<>();
            int maxFe = 0;
            for (int j = 0; j < M; j++) {
                int numOfF = sc.nextInt();
                Map<String, Integer> cur = new HashMap<>();
                for (int k = 0; k < numOfF; k++) {
                    int fi = sc.nextInt();
                    int se = sc.nextInt();
                    String str = fi + " " + se;
                    int lastNum = last.getOrDefault(str, 0);
                    maxFe = Math.max(maxFe, lastNum + 1);
                    cur.put(str, lastNum + 1);
                }
                last = cur;
            }
            System.out.println(Math.max(maxFe, 1));
        }
    }

}
