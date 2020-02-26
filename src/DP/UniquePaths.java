package DP;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/26
 */

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths2(9, 35));
    }

    public int uniquePaths(int m, int n) {
        //TimeLimited
        return walk(m, n, 1, 1);
    }

    public int walk(int m, int n, int curM, int curN) {
        if (curM == m && curN == n) {
            return 1;
        } else if (curM > m || curN > n) {
            return 0;
        } else
            return walk(m, n, curM + 1, curN) + walk(m, n, curM, curN + 1);
    }

    public int uniquePaths2(int m, int n) {
        int[][] path = new int[m][n];
        path[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    path[i][j] = 1;
                } else
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }
        return path[m - 1][n - 1];
    }

}
