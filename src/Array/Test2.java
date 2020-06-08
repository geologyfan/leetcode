package Array;

import java.util.Scanner;

/**
 * @description:
 * @author: bin
 * @create: 2020/5/21
 */

public class Test2 {
    static int ans=0;
    static int[] arr ;
    public static void main(String[] args) {
        int n=40;
        arr = new int[n+1];
        dfs(2,n);
        System.out.println(ans);
    }


//    static int getNextPrime(int n){
//        for(int i=2;i<=n;i++){
//
//        }
//    }

    static void dfs(int index,int n){
        if(index==n+1){
            ans=(ans+1)%1000000007;
            return;
        }
        if(arr[index]==-1){
            dfs(index+1,n);
        }else if(arr[index]==0){
            for(int i=1;i*index<=n;i++){
                arr[i*index]=-1;
            }
            dfs(index+1,n);
            for(int i=1;i*index<=n;i++){
                arr[i*index]=0;
            }
            dfs(index+1,n);
        }
    }



    static int compute(String s) {
        int[] numOfChar = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            numOfChar[temp - 'a'] += 1;
        }
        boolean flag = false;
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            int count = numOfChar[i];
            if (count > 0 && count % 2 == 0) {
                flag = true;
            }
            if (count % 2 == 1) {
                ans++;
            }
        }
        if (ans == 0) {
            return flag ? 1 : 0;
        }
        return ans;

    }


    public static int delete(String s) {
        for (int i = s.length() - 2; i >= 0; i -= 2) {
            if (judge(s.substring(0, i))) {
                return i;
            }
        }
        return 2;
    }

    public static boolean judge(String s) {
        int len = s.length();
        int p = len / 2;
        int i = 0;
        while (p < s.length()) {
            if (s.charAt(i) != s.charAt(p)) {
                return false;
            }
            p++;
            i++;
        }
        return true;
    }
}
