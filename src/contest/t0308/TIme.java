package contest.t0308;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/8
 */

public class TIme {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            maxTime = Math.max(maxTime, countTime(i, manager, informTime, 0));
        }
        return maxTime;
    }

    public int countTime(int cur, int[] manager, int[] informTime, int time) {
        if (manager[cur] == -1) {
            return time;
        }
        return countTime(manager[cur], manager, informTime, time + informTime[manager[cur]]);
    }
}
