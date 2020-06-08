package Array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/27
 */

public class Factorize {
    public static void main(String[] args) {
        Factorize f = new Factorize();
        System.out.println(f.factorize(10));
    }

    public int factorize(int n) {
        if (n < 10) {
            return n;
        }
        int m = 0;
        List<Integer> list = new ArrayList<>();
        boolean flag;
        while (n >= 10) {
            flag = false;
            for (int i = 9; i > 1; i--) {
                if (n % i == 0) {
                    n /= i;
                    list.add(i);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return -1;
            }
        }
        list.add(n);
        for(int i=list.size()-1;i>=0;i--){
            m  =m*10+list.get(i);
        }
        return m;
    }

}
