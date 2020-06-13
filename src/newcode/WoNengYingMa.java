package newcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/12
 */

public class WoNengYingMa {
    public static void main(String[] args) {
        WoNengYingMa w = new WoNengYingMa();

        System.out.println(w.canIWin(10, 11));
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((maxChoosableInteger * (maxChoosableInteger + 1)) / 2 < desiredTotal) {
            return false;
        }
        Map<String, Boolean> states = new HashMap<>();
        boolean[] used = new boolean[maxChoosableInteger + 1];
        boolean win = false;
        for (int i = 1; i <= maxChoosableInteger; i++) {
            used[i] = true;
            if (judge(used, i, desiredTotal, states)) {
                win = true;
            }
            used[i] = false;
            if (win) {
                break;
            }
        }
        return win;
    }

    private boolean judge(boolean[] used, int sum, int desiredTotal, Map<String, Boolean> states) {
        if (sum >= desiredTotal) {
            return true;
        }
        String state = Arrays.toString(used);
        if (states.containsKey(state)) {
            return states.get(state);
        }
        boolean win = true;
        for(int i=1;i<used.length;i++){
            if(used[i]){
                continue;
            }
            if(sum+i>=desiredTotal){
                return false;
            }
            used[i] = true;
            boolean flag = false;
            for(int j = 1;j<used.length;j++){
                if(used[j]){
                    continue;
                }
                used[j] = true;
                if(judge(used,sum+i+j,desiredTotal,states)){
                    flag = true;
                }
                used[j] = false;
                if(flag){
                    break;
                }
            }
            used[i] = false;
            if(!flag){
                win = false;
                break;
            }
        }
        states.put(state,win);
        return win;
    }


}
