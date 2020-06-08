package newcode;

import java.util.Scanner;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/8
 */

public class BanGongShi {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt()+1;
        int y = sc.nextInt()+1;
        int n = sc.nextInt();
        int[][] matrix = new int[x][y];
        for(int i=0;i<n;i++){
            matrix[sc.nextInt()][sc.nextInt()]=1;
        }
        sc.close();
        long[][] dp = new long[x][y];
        dp[0][0] = 1;
        for(int i=1;i<x;i++){
            dp[i][0] = matrix[i][0]==0?0:dp[i-1][0];
        }
        for(int i=1;i<y;i++){
            dp[0][i] = matrix[0][i]==0?0:dp[0][i-1];
        }
        for(int i=1;i<x;i++){
            for(int j=1;j<y;j++){
                dp[i][j] = matrix[i][j]==0?0:dp[i-1][j]+dp[i][j-1];
            }
        }
        System.out.println(dp[x-1][y-1]);
    }

    private static int walk(int[][] matrix, int x, int y) {
        int[][] dp = new int[x][y];
        dp[0][0] = 1;
        for(int i=1;i<x;i++){
            if(matrix[i][0]==1){
                dp[i][0] = 0;
            }else{
                dp[i][0] = dp[i-1][0];
            }
        }
        for(int i=1;i<y;i++){
            if(matrix[0][i]==1){
                dp[0][i]=0;
            }else{
                dp[0][i] = dp[0][i-1];
            }
        }
        for(int i=1;i<x;i++){
            for(int j=1;j<y;j++){
                if(matrix[i][j]==1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[x-1][y-1];
    }
}
