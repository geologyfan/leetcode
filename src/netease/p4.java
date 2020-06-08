package netease;

import java.util.Scanner;

/**
 * @description:
 * @author: bin
 * @create: 2020/4/7
 */

public class p4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        int[][] res = new int[n][m];
        boolean[][] used = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]==0){
                    res[i][j] = 0;
                }else{
                    res[i][j] = find(i, j, map,used);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(res[i][j]);
                if (j == m - 1) {
                    System.out.print("\n");
                } else {
                    System.out.print(" ");
                }
            }
        }

    }

    public static int find(int i, int j, int[][] map,boolean[][] used) {
        if(i>=map.length||i<0||j>=map[0].length||j<0||used[i][j]){
            return 1000;
        }
        if(map[i][j]==0){
            return 0;
        }
        used[i][j] = true;
        int left = find(i,j-1,map,used);
        int right = find(i,j+1,map,used);
        int up = find(i-1,j,map,used);
        int down = find(i+1,j,map,used);
        used[i][j] = false;
        return 1+min(left,right,up,down);
    }

    public static int min(int a,int b,int c,int d){
        int min = a;
        min = Math.min(min,b);
        min = Math.min(min,c);
        min = Math.min(min,d);
        return min;
    }

}
