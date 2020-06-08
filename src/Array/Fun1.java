package Array;

import java.math.BigInteger;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/7
 */

public class Fun1 {

    public static void main(String[] args){
        System.out.println(func(2,1,4));

    }



    private static String func(int N,int M,long K){
        BigInteger[][] dp = new BigInteger[N+1][M+1];
        for(int i=0;i<=N;i++){
            dp[i][0] = new BigInteger(Integer.toString(i));
        }
        for(int i=0;i<=M;i++){
            dp[0][i] = new BigInteger(Integer.toString(i));
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                dp[i][j] = dp[i-1][j].add(dp[i][j-1]).add(new BigInteger(Integer.toString(2)));
            }
        }
        StringBuilder res = new StringBuilder();

        while(K>0){
            if(N>0&&M>0){
                if(dp[N-1][M].compareTo(new BigInteger(Long.toString(K-1)))>=0){
                    K--;
                    res.append('a');
                    N--;
                }else{
                    K-=dp[N-1][M].longValue()+2;
                    res.append('b');
                    M--;
                }
            }else if(N>0){
                res.append('a');
                N--;
                K--;
            }else if(M>0){
                res.append('b');
                M--;
                K--;
            }else{
                K=0;
            }
        }
        return res.toString();
    }

    private static long compute(int N,int M){
        long count = 0;
        for(int a = 0;a<=N;a++){
            for(int b = 0;b<=M;b++){
                if(a==0){
                    count+=b;
                }else if(b==0){
                    count+=a;
                }else{
                    count+=jiecheng(N+M)/(jiecheng(N)*jiecheng(M));
                }
            }
        }
        return count;
    }
    private static long jiecheng(int m){
        long res = 1;
        while(m>1){
            res*=m--;
        }
        return res;
    }

}
